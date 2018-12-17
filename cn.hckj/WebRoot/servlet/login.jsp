<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
	span{
		color:red;
		text-align: right;
	}
</style>
</head>
  <body bgcolor="#ffffff">
<h2 align="center">
用户登录<br>
<form action="session1.do" method="post">
用户名：<input type="text" name="username">
<br>
密&nbsp;&nbsp;码：<input type="password" name="password"><br>
<input type="submit" value="登录">
</form>
</h2>
</form>
  </body>
</html>
