<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="images/beakGroud.jpg" ><div align="center"><div align="left">&nbsp;&nbsp;&nbsp; <br>&nbsp;&nbsp;&nbsp; 欢迎您加入我们！<br>&nbsp;&nbsp;&nbsp; <br>&nbsp;&nbsp;&nbsp; 请在下面认真填写好个人注册信息，以方便我们的管理维护，谢谢合作！<br></div>
  <font size="5"><br>注册个人信息</font><br><div align="left"><br></div><div align="left"><br><br><br><div align="center"> 
  </div></div>
	  <form action="/blog233/servlet/Login" method = "post" ><div align="center"> 
	  		  用户名：<input type ="text" name ="u" ><br> 
		  <br>密  码：<input type ="password" name ="p" ><br> 
		  <br>性  别：<input type=radio value="man" name="b" checked >男
				   <input type=radio value="weman" name="b" >女 <br> 
		  <br>姓  名：<input type ="text" name ="name" >&nbsp; <br><br>
		  出生日期：<input type ="text" name ="date" value="1988-07-12" ><br><br> 
		<br><br></div>
		<div align="center"><input type="submit" value="确定"><input type="reset" value="重设"> </div>
	</form></div>
<div align="right"><small><a href="/blog233/logon.jsp">已有用户名，返回登录</a></small></div>
  </body>
</html>
