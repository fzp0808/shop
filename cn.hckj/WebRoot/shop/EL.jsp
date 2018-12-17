<%@ page language="java" import="java.util.*,cn.hckj.servlet.day03.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
  <body>
    EL:${1+1}<br>
   <%--  <h2>empty运算符</h2>
    <%
    	ArrayList<User> list =new ArrayList<User>();
    	User user=new User();
    	user.setUsername("yang");
    	user.setPassword("12300");
    	String str=null;
    	String str1="";
    	String str2="abc";
    	request.setAttribute("user", user);
     %>
     ${empty list}<br>
     ${empty str}<br>
     ${empty str1 }<br>
     ${empty user }<br>
     <h1>条件表达式</h1>
     <%session.setAttribute("aaa", "aa"); %>
     ${"aa" eq aaa }<br>
     <h2>获取请求参数</h2>
     ${param.name }<br>
     <h1>EL表达式</h1>
  	<hr> --%>
  	<%
  		ArrayList<User> list = new ArrayList<User>();
  		User u = new User();
  		u.setUid(1001);
  		u.setUsername("zhangsan");
  		u.setPassword("123");
  		list.add(u);
  		User u1 = new User();
  		u1.setUid(1002);
  		u1.setUsername("lisi");
  		u1.setPassword("1234");
  		list.add(u1);
  		User u2 = new User();
  		u2.setUid(1003);
  		u2.setUsername("wangwu");
  		u2.setPassword("4321");
  		list.add(u2);
  		String str = "abc";
  		request.setAttribute("s", str);
  		request.setAttribute("list1", list);
  	 %>
  	 <h1>JSTL</h1>
  <%-- 	 <c:if test="${param.age<18 }" var="flag">
  	 	<c:out value="你的年龄太小了"></c:out>
  	 </c:if>
  	 <c:if test="${!flag}">
  	 	<c:out value="你没钱了"></c:out>
  	 </c:if> --%>
  	 <br>
  	 <c:choose>
  	 	<c:when test="${param.age<=6} ">你还没有断奶！</c:when>
  	 	<c:when test="${param.age<12&&param.age>6} ">你也就刚刚断奶</c:when>
  	 	<c:when test="${param.age<18&&param.age>=12} ">你要好好学习</c:when>
  	 	<c:when test="${param.age<28&&param.age>=18} ">你要好好工作</c:when>
  	 	<c:otherwise>自己想想你该干嘛</c:otherwise>
  	 </c:choose> 
  </body>
</html>
