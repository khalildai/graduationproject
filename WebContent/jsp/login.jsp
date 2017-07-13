<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style>
body {
	background-color: #F1F1F1;
	text-align: center;
}

.daohang {
	border-radius: 5px;
	background-color: rgb(200, 200, 200);
	width: 1050px;
	height: 60px;
	line-height: 60px;
	margin: 0 auto;
}
</style>
</head>
<script language="JavaScript">
	function validate(f) {
		if (!(/^\w{5,15}$/.test(f.userid.value))) {
			alert("用户ID必须是5~15位！")
			f.userid.focus();
			return false;
		}
		if (!(/^\w{5,15}$/.test(f.userpass.value))) {
			alert("密码必须是5~15位！")
			f.userpass.focus();
			return false;
		}
		return true;
	}
</script>

<body>
	<h1>Welcome to KD's forum!</h1>
	<div class="daohang">
		<input type="submit" name="homepage" value="HOMEPAGE"
			onclick="javascrtpt:window.location.href='homepage.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="nbanews" value="NBA AREA"
			onclick="javascrtpt:window.location.href='nbaforum.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="cbanews" value="CBA AREA"
			onclick="javascrtpt:window.location.href='cbaforum.jsp'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="warriorsnews" value="Warriors AREA"
			onclick="javascrtpt:window.location.href='warriorsforum.jsp'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="cavaliersnews" value="Cavaliers AREA"
			onclick="javascrtpt:window.location.href='cavaliersforum.jsp'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="othernews" value="Other AREA"
			onclick="javascrtpt:window.location.href='otherforum.jsp'">
	</div>
	<div style="height: 60px;"></div>
	<div
		style="border-radius: 30px; background-color: white; height: 420px; width: 500px; display: block; margin: 0 auto;">
		<form
			style="border-radius: 30px; background-color: white; height: 250px; width: 500px; display: block; margin: 0 auto;"
			action="LoginServlet" method="post" onSubmit="return validate(this)">
			<br>
			<!-- <h2>用户登录</h2> -->
			<%
				request.setCharacterEncoding("UTF-8");
			%>
			<%
				List<String> info = (List<String>) request.getAttribute("info");
				if (info != null) {
					Iterator<String> iter = info.iterator(); //实例化Lterator
					while (iter.hasNext()) {
			%>
			<h2 align="center"><%=iter.next()%></h2>
			<%
				}
				} else {
			%><h2 align="center">用户登录</h2>
			<%
				}
			%>
			<br> 用户ID ：<input type="text" name="userid">
			<p>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userpass">
			<p>
				<br> <input type="submit" value="登录"
					style="height: 30px; width: 220px;"><br> <br>
		</form>
		<input type="submit" name="register" value="注册"
			style="height: 30px; width: 220px;"
			onclick="javascrtpt:window.location.href='register.jsp'"> <br>
		<br> <br> <br> 管理员登录，请点击 <a
			href="../adminjsp/adminlogin.jsp">这里</a>！
	</div>
</body>
</html>