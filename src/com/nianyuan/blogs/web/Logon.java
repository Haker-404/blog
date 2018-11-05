package com.nianyuan.blogs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nianyuan.blogs.VO.LoginVO;
@WebServlet("/Logon.do")
public class Logon extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Logon() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		得到用户名和密码，进行验证，验证通过则成功登录，否则登录失败
		response.setContentType("text/html;charset=utf-8");
		LoginVO l = new LoginVO();
		String path = "";
		if(l.checkPass(request)){

//			密码正确且是第一次登录
			path ="index/index.jsp";
		}
		else
		{
//			账号密码错误，或不是第一次登录
			String massage ="账号或密码错误，或已经有相同账号登录";
			String m = new String(massage);
			path ="logon.jsp";
		}
		response.sendRedirect(path);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
