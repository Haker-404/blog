package com.nianyuan.blogs.VO;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 得到当前session,实现权限控制
		HttpServletRequest re = (HttpServletRequest)arg0;
		// 转型
		HttpServletResponse res = (HttpServletResponse)arg1;
		
		HttpSession s = re.getSession();
		String massage = (String)s.getAttribute("log");
		
		// 验证session中的值，决定是否放行
		if("user".equals(massage)){
			//ͨ 通过验证 放行
			arg2.doFilter(arg0, arg1);
		}
		else{
			// 没有通过验证，拦截住，并返回首页重新登陆	
			res.sendRedirect("/blog233/logon.jsp");
		}	
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub	
	}
}
