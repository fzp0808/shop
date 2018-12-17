<%@ page language="java" import="java.util.*,student.day02.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="ajax.js"></script>
<script>
function check(val){
 var tbody=document.getElementById("tbody");
	$ajax({
		url:"test.action",
		data:{ 
				name:"xianshi"
		   },
			success:function(data){
				var str="";
				for(var i in data){
				str+="<tr>"+
					"<td>"+data[i].eMPNO+"</td>"+
					"<td>"+data[i].eNAME+"</td>"+
					"<td>"+data[i].jOB+"</td>"+
					"<td>"+data[i].mGR+"</td>"+
					"<td>"+data[i].hIREDATE+"</td>"+
					"<td>"+data[i].sAL+"</td>"+
					"<td>"+data[i].cOMM+"</td>"+
					"<td>"+data[i].dEPTN+"</td>"+
					"<tr>"
				}
				tbody.innerHTML=str;
			},
			error:function(error){
				alert(error);
			}
	});
}
function  ck() {
		var tbody=document.getElementById("tbody");
	$ajax({
		url:"test.action",
		data:{
		  name:"paixu"
		},
			success:function(data){
				var str="";
				for(var i in data){
				str+="<tr>"+
					"<td>"+data[i].eMPNO+"</td>"+
					"<td>"+data[i].eNAME+"</td>"+
					"<td>"+data[i].jOB+"</td>"+
					"<td>"+data[i].mGR+"</td>"+
					"<td>"+data[i].hIREDATE+"</td>"+
					"<td>"+data[i].sAL+"</td>"+
					"<td>"+data[i].cOMM+"</td>"+
					"<td>"+data[i].dEPTN+"</td>"+
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
  <body>
  <input type="button" value="显示" onclick="check(this.value)" />
  <table  align="center" border="1px" cellpadding="0px" cellspacing="0px">
  <tr >
  <td onclick="ck()"> 员工号</td>
  <td> 员工姓名</td>
  <td> 工作</td>
  <td> 上司编号</td>
  <td> 工作时间</td>
  <td> 工资</td>
  <td> 奖金</td>
  <td> 部门号</td>
  </tr>
  </table>
  <table id="tbody" align="center" border="1px" cellpadding="0px" cellspacing="0px">
  </table>
  </body>
</html>
