<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="com.nianyuan.blogs.PO.*" %>
<%@ page  import="com.nianyuan.blogs.DAO.*" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>博客驿站</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="index/style.css" rel="stylesheet" type="text/css" media="screen" />
<style>
.news{
	float:right;
}
.font{	
width:auto;
      margin-left:1px;
      float:left;
      font-family:Arial, Helvetica, sans-serif; 
      font-size:15px;
      color:#5f5f5f;
      line-height:35px;
      text-transform:uppercase
}

</style>
</head>
<body>
	<div id="logo">
		<h1><a href="index.jsp">博客驿站 </a></h1>
		
	<% 
		String user = (String)session.getAttribute("user");
	if(user!=null) request.getRequestDispatcher("blog233/index/index.jsp").forward(request,response);;
    %>
    <%
    BogoPAO dao = new BogoPAO();
    ArrayList<Bogo> blogs = new ArrayList<Bogo>();
    if((blogs = dao.getAllLogo("select * from logo_copy1"))!=null)System.out.println("sdftdg");
    else System.out.println("uuuu");
    request.setAttribute("blogs", blogs);
    %>
    	<br />您好，&nbsp;&nbsp;<a href ="/blog233/logon.jsp"><b>请登录</b></a>&nbsp;&nbsp;&nbsp;<a href ="/blog233/logon.jsp">退出</a>
	</div>
	<hr />
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="index.jsp" class="first">驿站首页</a></li>
				<li class="current_page_item"><a href="/blog233/logon.jsp">查看心语</a></li>
				<li><a href="/blog233/logon.jsp">留下心语</a></li>
		
				<li><a href="#">后台管理</a></li>
			</ul>
		</div>
		<!-- end #menu -->
	</div>
	<!-- end #header -->
	<!-- end #header-wrapper -->
	<div id="page">
	
		<div id="content">
        
              <c:forEach items="${requestScope.blogs}" var="b">
               
                <div class="font"><c:out value="${b.lcontent }"></c:out> </div>
                 <p></p>
             <div class="news"> <c:out value="${b.lname }"></c:out>
                 <c:out value="${b.ldate }"></c:out>
              
                 <p></p>
                 <c:choose>
                 	<c:when test="${user}">
                  <a href="#">评论</a>&nbsp;&nbsp;<a href="#">删除</a>
                  	</c:when>
                  	<c:otherwise>
                  	 <a href="/blog233/logon.jsp">评论</a>&nbsp;&nbsp;<a href="#">删除</a>
                  	</c:otherwise>
                  </c:choose>
               <p></p>
               </div>
        	</c:forEach>
             
 		
		</div><!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<h2>驿&nbsp;站&nbsp;寄&nbsp;语</h2>
					<h4><em><a href ="http://420763480.qzone.qq.com">&nbsp;&nbsp;&nbsp;&nbsp;心中有一个梦想，当它会幻化成飞絮在空中游荡，找寻着能寄居它的地方，找到了梦就圆了...</a></em></h4>
				</li>
				<li>
					<h2>心&nbsp;灵&nbsp;点&nbsp;睛</h2>
					<ul>
						<li><a href="/blog233/logon.jsp">查看心语</a></li>
						<li><a href="/blog233/logon.jsp">留下心语</a></li>
						<li><a href="#">个人信息</a></li>
						<li><a href="#">待添加</a></li>
						<li><a href="#">待添加</a></li>
					</ul>
				</li>
				<li>
					<h2>梦&nbsp;之&nbsp;摇&nbsp;篮</h2>
					<ul>
						
						<li><a href="http://www.pudn.com/">程序员联合开发网</a></li>
						<li><a href="http://www.csdn.net/">CSDN.NET</a></li>
						<li><a href="http://www.oschina.net/">开源中国社区</a></li>
						<li><a href="http://linux.ubuntu.org.cn/">Linux网址大全</a></li>
						<li><a href="http://forum.ubuntu.org.cn/index.php">Linux中文论坛</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
	
	<!-- end #footer -->
</body>
</html>

