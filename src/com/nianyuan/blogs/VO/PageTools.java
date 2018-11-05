package com.nianyuan.blogs.VO;

import javax.servlet.http.HttpServletRequest;

import com.nianyuan.blogs.DAO.BogoPAO;
import com.nianyuan.blogs.PO.BreakPage;

public class PageTools {

	public static BreakPage tools(HttpServletRequest request){
		
		BogoPAO m = new BogoPAO();
		BreakPage b = new BreakPage(m.totalRoles());
		// get date info from web page
		String code = request.getParameter("page");
		if(code != null){
			
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			if("xia".equals(code)){
				b.downPage(currentPage);
			}
			else if("shang".equals(code)){
				b.upPage(currentPage);
			}
			else if("shou".equals(code)){
				b.firstPage();
			}
			else if ("wei".equals(code)){
				b.endPage();
			}
		}
		
		return b;
	}
}
