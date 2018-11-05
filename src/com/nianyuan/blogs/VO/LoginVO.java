package com.nianyuan.blogs.VO;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nianyuan.blogs.DAO.BlogsDAO;
import com.nianyuan.blogs.PO.Users;


public class LoginVO {
	
	public Users PackUsers(HttpServletRequest request){
		
		Users u = new Users();
		u.setUser(request.getParameter("u"));
		u.setPass(request.getParameter("p"));
		u.setName(request.getParameter("name"));
		u.setBirthday(request.getParameter("date"));
		String sex = request.getParameter("b");
		if(sex.equals("man")){
			u.setSex("man");
		}
		else{
			u.setSex("weman");
		}
		return u;
	}
	/**
	 * checkout the UserName 
	 * @param request
	 * @return
	 */
	public boolean checkUsers(HttpServletRequest request){
		
		if((!"".equals(request.getParameter("p")))&&(!"".equals(request.getParameter("u")))){
			
			boolean b = false;
			// Query the Database
			ArrayList<Users> al = (ArrayList<Users>)new BlogsDAO().queryPerson();
			// 遍历比较
			for(int i=0; i<al.size(); i++){
				
				Users u = (Users)al.get(i);
				if(u.getUser().equals(request.getParameter("u"))){				
					b=true;
					break;
				}
			}
			// 如果不一样 返回false
			if(b){			
				return false;
			}
			else
			{
				return true;
			}
		}		
		return false;
	}
	/**
	 * checkout the password
	 * @param request
	 * @return
	 */
	public boolean checkPass(HttpServletRequest request){
		
		String user = request.getParameter("u");
		String pass = request.getParameter("p");
		
		boolean b = false;
		
		if((pass!=null)&(user!=null)){
			// get application
			ServletContext sc = request.getServletContext();
			String Pass = new BlogsDAO().queryPassByUser(user);
			if(pass.equals(Pass)){
				
				// 密码正确 ,判断是否为第一次登录
				if(checkFirstlogon(sc, user)){
					
					// 如果是，存入session中 返回true
					HttpSession s = request.getSession();
					s.setAttribute("user", user);
					s.setAttribute("log", "user");
					b = true;
				}				
			}
		}		
		return b;
	}
	
	/**
	 * 判断该用户是否为第一次登录
	 * @param sc
	 * @param user
	 * @return
	 */
	private boolean checkFirstlogon(ServletContext sc, String user){
		
		// 从application中取出user判断该用户是否为第一次登陆
		boolean b = false;
		// 试图从application中去取
		ArrayList al = (ArrayList)sc.getAttribute("ListUser");
		if(al == null){
			al = new ArrayList<Users>();
			al.add(user);
			sc.setAttribute("ListUser", al);
			b = true;
		}
		else
		{
			boolean is = false;
			for(int i=0; i<al.size(); i++ ){
				
				String userName = (String)al.get(i);
				if(userName.equals(user)){ // 表示已经有相同用户名登陆
					
					is = true;
					b = false;
					break;
				}
			}
			// //将user写入application中
			if(!is){
				al.add(user);
				sc.setAttribute("ListUser", al);
				b = true;
			}
		}
		return b;	
	}
}
