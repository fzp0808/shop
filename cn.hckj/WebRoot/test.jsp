<%@ page language="java" import="java.util.*,student.day02.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
  <body>
    <form action="" method="post">
    <%ArrayList<EMP> list=(ArrayList<EMP>)session.getAttribute("name"); %>
	<table class="center" border='1px' align='center' cellpadding="0px" cellspacing="0px">
	<%for(EMP e:list){ %>
		<tr>
			<td><%=e.getEMPNO()%></td>
			<td><%=e.getENAME()%></td>
			<td><%=e.getJOB()%></td>
			<td><%=e.getMGR()%></td>
			<td><%=e.getHIREDATE()%></td>
			<td><%=e.getSAL()%></td>
			<td><%=e.getCOMM()%></td>
			<td><%=e.getDEPTNO()%></td>
		</tr>
	<%} %>
</table>
 
    </form>
  </body>
</html>
