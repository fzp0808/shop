<%@ page language="java" import="java.util.*,cn.hckj.servlet.day01.work.*"  pageEncoding="UTF-8"
errorPage="test1.jsp"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
  <body>
   <%ArrayList<EMP> list =(ArrayList<EMP>)request.getAttribute("name");%>
   <table border="1px" width="600px" cellpadding="0px" align="center" cellspacing="0px">
   <%for(EMP emp:list){%>
   <tr>
   <td><%=emp.getEMPNO() %></td>
   <td><%=emp.getENAME() %></td>
   <td><%=emp.getMGR() %></td>
   <td><%=emp.getJOB() %></td>
   <td><%=emp.getSAL() %></td>
   <td><%=emp.getCOMM() %></td>
   <td><%=emp.getHIREDATE() %></td>
   <td><%=emp.getDEPTNO() %></td>
   <%} %>
   </tr>
   </table>
  </body>
</html>
