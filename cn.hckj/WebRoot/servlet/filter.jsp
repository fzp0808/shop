<%@page import="java.io.PrintWriter"%>
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
  <%String input=(String) request.getAttribute("text1"); %>
  <%PrintWriter pw=response.getWriter();%>		
  <%=pw.print(input)%>		
  <form action="filter.do" method="post">
    <input type="text" name="text" /><input type="submit" value="提交"/>
  </form>
  </body>
</html>
