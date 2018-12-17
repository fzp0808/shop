<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
span{
color:red;
}
</style>
<script type="text/javascript">
var password;
			var usernameFlag;
			var passwordFlag;
			var rePasswordFlag;
				function checkUsername(val,spanObject){
				var reg = /[\w-]+(\.[\w-])*@[\w-]+(\.[\w-])*/;
				if(val!=null&&val!=""){
					var flag = reg.test(val);
					if(!flag){
						spanObject.innerText = "用户名格式不正确！"
					}
				}
				usernameFlag = flag;
			}
			function checkPassword(val,spanObject){
				if(val!=null&&val!=""){
					this.password = val;
					var flag = val.length==6;
					if(!flag){
						spanObject.innerText = "密码长度不正确！"
					}
				}
				passwordFlag = flag;
			}
			function checkRepassword(val,spanObject){
				if(val!=null&&val!=""){
					var flag = password==val;
					if(!flag){
						spanObject.innerText = "两次密码不正确"
					}
				}
				rePasswordFlag = flag;
			}
			function clear1(spanObject) {
				spanObject.innerText = "";
			}
			function checkAll(){
				if(usernameFlag&&passwordFlag&&rePasswordFlag){
					return true;
				}else{
					return false;
				}
			}
</script>
</head>
  <body>
    <center>
 <h2>用户注册</h2>
 <hr/>
  <form action="register.do" method="get" onsubmit="return checkAll()">
			用户名:<input type="text" name="username" placeholder="请输入email作为用户名" 
				onblur="checkUsername(this.value,this.nextElementSibling)" onfocus="clear1(this.nextElementSibling)"/>
			<span></span>
			<br />
			密码:<input type="password" name="password" placeholder="请输入长度为6的密码" onblur="checkPassword(this.value,this.nextElementSibling)" 
				onfocus="clear1(this.nextElementSibling)"/>
			<span></span><br />
			确认密码:<input type="password" name="repassword" placeholder="请重新输入密码" onblur="checkRepassword(this.value,this.nextElementSibling)" 
				onfocus="clear1(this.nextElementSibling)"/>
			<span></span><br />
			<input type="submit" value="注册"/>
		</form>
 </center>
  </body>
</html>
