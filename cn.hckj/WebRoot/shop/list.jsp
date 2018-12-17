<%@ page language="java" import="java.util.*,cn.hckj.servlet.day03.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">

</script>
<style type="text/css">

.center tr td{
	width: 120px;
	text-align: center;
}

</style>
</head>
  <body>
  <form action="cart.do" method="get">
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

<H1 align="center">本系统的所<hr>有商品列表如下： <BR><BR>
<%ArrayList<PRODUCT> list=(ArrayList<PRODUCT>)session.getAttribute("name"); %>
<table class="center" border='1px' align='center' cellpadding="0px" cellspacing="0px">
<%for(PRODUCT e:list){ %>
	<tr>
		<td><%=e.getId()%></td>
		<td><%=e.getP_name()%></td>
		<td><%=e.getDescription()%></td>
		<td><%=e.getPrice()%></td>
		<td><img src="images/<%=e.getP_pic()%>"></td>
		<td><a href="cart.jsp"  onclick="add('<%=e.getP_name()%>')"> 添加到购物车</a></td>
	</tr>
<%} %>
</table>
<BR>
<a href="cart.jsp">查看购物车</a>
</H1>
</form>
  </body>
</html>
