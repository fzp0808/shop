<%@ page language="java" import="java.util.*,cn.hckj.servlet.day03.*" pageEncoding="UTF-8"%>
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
	<td colspan="3" align="right"><a href="login.jsp">登录</a></td>
  </tr>
</table>
<hr>
<H1 align="center">购物车 </H1>
<FORM name="cartForm" action="cart.do" method="post">
<%ArrayList<Shop> list=(ArrayList<Shop>)session.getAttribute("p_name"); %>
<table align="center" border="0" cellpadding="0" cellspacing="0">
	<%for(Shop s:list) { %>
	<tr>
		<td><%=s.getId() %></td>
		<td><%=s.getP_name() %></td>
		<td><%=s.getPrice() %></td>
	</tr>
	<%} %>
</table>
<BR>
<BR>
<TABLE cellSpacing="0" cellPadding="0" width="450" align="center" border="0">
   <TR align="center">
    <TD width="26%"><INPUT onClick="clearCart()" type="submit" value="清空购物车" name="submit"></TD>
    <TD width="12%"><INPUT type="submit" value="结账" name="submit"></TD>
    <TD width="20%"><INPUT onClick="javascript:location.href='list.jsp'" type="button" value="继续购物"></TD></TR>
</TABLE>
  </body>
</html>
