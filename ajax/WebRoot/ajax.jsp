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
		var index=null;
		if(window.XMLHttpRequest){
			index=new XMLHttpRequest();
		}else{
			index=new ActiveXObject("Microsoft.XMLHttp");
		}
		return index;
	}
	function send(val) {
		var xhr=getXhr();
		var url="checkUsername.do?username="+val;
		xhr.open("get",url);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var msg=xhr.responseText;
					alert(msg);
				}else{
					alert("服务器异常！");
				}
			}
		}
		xhr.send(null);
	}
	function send1(){
		location.href="noajax.do";
	}
</script>
</head>
  <body>
    <form action="reg.do" method="post">
    	用户名：<input type="text" name="username" onblur="send(this.value)"/>
    	测试非ajax请求：<input type="text" name="username1" onblur="send1"/>
    	密码：<input type="password" name="password"/><br>
    	<input type="submit" value="登录" />
    </form>
  </body>
</html>
