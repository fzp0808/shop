<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$ajax({
			url:"count.do",
			type:"post",
			data:{},
			success:function(data){
				for(i in data){
					var p=$("<p></p>");
					p.text(data[i].tName+","+data[i].tPrice+","+data[i].tNum);
					$(".div").append(p);
				}
			},
			error:function(error){
				alert(error);
			}
		});
		setInterval(function(){
		$ajax({
			url:"count.do",
			type:"post",
			data:{},
			success:function(data){
				$(".div").empty();
				for(i in data){
					var p=$("<p></p>");
					p.text(data[i].tName+","+data[i].tPrice+","+data[i].Num);
				}
			},
			error:function(error){
				alert(error);
			}
		})	
		},10000)	
	});
</script>
</head>
  <body>
    <h1>当前热销商品</h1>
    <div class="div"></div>
  </body>
</html>
