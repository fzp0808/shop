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
    <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50" >
  <tr>
    <td width="30%">&nbsp;</td>
    <td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
    <td width="30%" align="right" valign="bottom">&nbsp;</td>
  </tr>
  <tr>
	<td colspan="3" align="left">欢迎您,XXX!</td>
  </tr>
</table>
<hr>
<h2 align="center">订单已生成！您的订单号是：20080220001。</h2>
<center><a href="list.jsp">请返回</a>
</center>
  </body>
</html>
