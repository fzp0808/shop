<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function getXhr() {
		var xhr=null;
		if(window.XMLHttpRequest){
			xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject("Microsoft.XMLHttp");
		}
		return xhr;
	}
	
</script>
</head>
  <body>
    <from action="login.do" method="post">
    	用户名：<input type="text" name="username" onfocus="check()" />
    	<span id="span"><%=request.getAttribute("error_msg")==null?"":request.getAttribute("error_msg") %></span>
    	</br>
    	密码：<input type="password" name="password" /><br/>
    	<input type="submit" value="登录"/>
    </from>
  </body>
</html>
