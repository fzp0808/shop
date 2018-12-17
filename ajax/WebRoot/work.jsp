<%@ page language="java" import="java.util.*,ajax.day01.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">
	function check(val){
		$ajax({
			url:"work.do",
			type:"get",
			data:{},
			success:function(data){
				var str="";
				for(var i in data){
				str+="<tr>"+
					"<td>"+data[i].EMPNO+"</td>"+
					"<td>"+data[i].ENAME+"</td>"+
					"<td>"+data[i].JOB+"</td>"+
					"<td>"+data[i].MGR+"</td>"+
					"<td>"+data[i].HIREDATE+"</td>"+
					"<td>"+data[i].SAL+"</td>"+
					"<td>"+data[i].COMM+"</td>"+
					"<td>"+data[i].DEPTN+"</td>"+
					"<tr>"
				}
				tbody.innerHTML=str;
			},
			error:function(error){
				alert(error);
			}
		});
	}
</script>
</head>
  <body id="tbody">
  
  
  <input type="button" value="显示" onclick="check(this.value)"/>
 
  </body>
</html>
