<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
  <body>
    <table align="center">
    	<tr>
    		<td><h3>这是第一个页面的内容</h3></td>
    		<td></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><%@include file="Included.jsp" %></td>
    	</tr>
    </table>
    
  </body>
</html>
