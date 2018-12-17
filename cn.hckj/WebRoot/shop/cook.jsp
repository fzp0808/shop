<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function checkStatus(){
		var ck=document.cookie;
		alert(ck);
		if(ck!=null&&ck!=""){
			var inputs=document.getElementsByTagName("input");
			inputs[0].value=ck.split("=")[0];
			inputs[1].value=ck.split("=")[1];
			inputs[2].checked="true";
		}
	}
</script>
</head>
  <body onload="checkStatus()">
  <from action="testlogin.do" method="get">
  	  用户名：<input type="text" name="username" /><br>
   	  密码：   <input type="text" name="password"/> <br>
   	 <input type="checkbox" name="remember"/>记住密码  <br>
   	 <input type="submit" value="登录"/>
  </from>  
  </body>
</html>
