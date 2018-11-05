<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.nianyuan.blogs.PO.*" %>
<%@ page import="com.nianyuan.blogs.VO.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>博客驿站</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/blog233/index/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div id="logo">
		<h1><a href="/blog233/index/index.jsp">博客驿站 </a></h1>
		
	</div>
	<hr />
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="/blog233/index/index.jsp" class="first">驿站首页</a></li>
				<li class="current_page_item"><a href="/blog233/servlet/ListTalk">查看心语</a></li>
				<li><a href="/blog233/index/add.jsp">留下心语</a></li>
				<li><a href="#">关于我们</a></li>
				<li><a href="/blog233/index/manager.jsp">后台管理</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="search">
			<form method="post" action="/blog233/index/servlet/List">
				<fieldset>
				<input type="text" name="s" id="search-text" size="15" value="请入要查询内容" />
				<input type="submit" id="search-submit" value="GO" />
				</fieldset>
			</form>
		</div>
		<!-- end #search -->
	</div>
	<!-- end #header -->
	<!-- end #header-wrapper -->
	<div id="page">
		<div id="content">
		<%
			BreakPage b = (BreakPage)request.getAttribute("p");
			ArrayList al =(ArrayList)request.getAttribute("list");
			for(int index=0; index<al.size(); index++)
			{
				Bogo bp = (Bogo)al.get(index);
		%>
			<div class="post">
				<div class="content-title"><h2><p><%=bp.getLtitle()%></p></h2></div>
				<div class="content-content"> <p><%=bp.getLcontent() %>&nbsp;&nbsp;|&nbsp;【&nbsp;写于<%=bp.getLdate() %>&nbsp;】</p></div>
				<div class = "content-bottom">留言者：<em><%=bp.getLname() %>  </em> &nbsp;&nbsp;邮箱：<%=bp.getLemail() %>&nbsp;|&nbsp;
				<a href ="/blog233/servlet/EditTalk?nid=<%=bp.getLid()%>">编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href ="/blog233/servlet/DeleteTalk?nid=<%=bp.getLid()%>">删除</a></div>
			</div>
		<%	
			}		
		%>
		<p>	页码：<%=b.getCurrentPage() %>/<%=b.getTotalPage() %>&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href = "/blog233/servlet/ListTalk?page=shou&currentPage=<%=b.getCurrentPage() %>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href = "/blog233/servlet/ListTalk?page=shang&currentPage=<%=b.getCurrentPage() %>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href = "/blog233/servlet/ListTalk?page=xia&currentPage=<%=b.getCurrentPage() %>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href = "/blog233/servlet/ListTalk?page=wei&currentPage=<%=b.getCurrentPage() %>">尾页</a>
		</div><!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<h2><em>寄语</em></h2>
					<h3><p><em><a href ="http://420763480.qzone.qq.com">我心中有一个梦想，它会幻化成飞絮在空中游荡，找寻着能寄居它的地方，找到了梦就圆了...</a></em></p><h3>
				</li>
				<li>
					<h2>日常操作</h2>
					<ul>
						<li><a href="/blog233/servlet/ListTalk">查看心语</a></li>
						<li><a href="/blog233/index/add.jsp">留下心语</a></li>
						<li><a href="#">待添加</a></li>
						<li><a href="#">待添加</a></li>
						<li><a href="#">待添加</a></li>
						<li><a href="#">待添加</a></li>
					</ul>
				</li>
				<li>
					<h2>个人收藏</h2>
					<ul>
						<li><a href="http://jwc.whut.edu.cn/">武汉理工大学教务处</a></li>
						<li><a href="http://www1.anshouji.com/html/class-1-1-1.html">安机资源网</a></li>
						<li><a href="http://iask.sina.com.cn/">新浪知识达人</a></li>
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