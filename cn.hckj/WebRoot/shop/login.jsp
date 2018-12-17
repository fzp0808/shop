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
  <form action="login1.do" method="get"> 
  <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50" >
  <tr>
    <td width="30%">&nbsp;</td>
    <td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
    <td width="30%" align="right" valign="bottom">
	<a href="register.jsp"><span style="text-decoration:none">还没有账号，马上注册</span></a></td>
  </tr>
</table>
<hr>
<h2 align="center">
用户登录<br>
<form action="list.jsp" method="post">
用户名：<input type="text" name="username">
<span id="span" ><%=request.getAttribute("error_msg")==null?"":request.getAttribute("error_msg") %></span>
<br>
密&nbsp;&nbsp;码：<input type="password" name="password"><br>
<input type="submit" value="登录">
</form>
</h2>
</form>
  </body>
</html>
