<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员添加新闻</title>
<style>
body {
	background-color: #F1F1F1;
	text-align: center
}

a {
	color: #000;
}

a:hover {
	color: gray;
}

.daohang {
	border-radius: 5px;
	background-color: rgb(200, 200, 200);
	width: 1300px;
	height: 60px;
	line-height: 60px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		List<String> info = (List<String>) request.getAttribute("info");
		if (info != null) {
			Iterator<String> iter = info.iterator(); //实例化Lterator
			while (iter.hasNext()) {
	%>
	<h4 align="right"><%=iter.next()%></h4>
	<%
		}
		} else {
	%><h4 align="right">管理员登录成功，欢迎admin登录!</h4>
	<%
		}
	%>
	<h1>Welcome to KD's forum!</h1>
	<div class="daohang">
		<input type="submit" name="news" value="NEWS for admin"
			onclick="javascrtpt:window.location.href='adminhomepage.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="nbanews" value="NBA AREA for admin"
			onclick="javascrtpt:window.location.href='adminnbaforum.jsp'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="cbanews" value="CBA AREA for admin"
			onclick="javascrtpt:window.location.href='admincbaforum.jsp'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="warriorsnews" value="Warriors AREA for admin"
			onclick="javascrtpt:window.location.href='adminwarriorsforum.jsp'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="cavaliersnews" value="Cavaliers AREA for admin"
			onclick="javascrtpt:window.location.href='admincavaliersforum.jsp'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="othernews" value="Other AREA for admin"
			onclick="javascrtpt:window.location.href='adminotherforum.jsp'">
	</div>
	<div name="adminaddnews">
		<h3 align="left">新闻信息管理：</h3>
		删除新闻，请点击<a href="adminhomepage.jsp">这里</a>！ <br> <br>
		<h3 align="center">添加新闻</h3>
		<%
			List<String> info2 = (List<String>) request.getAttribute("info2");
			if (info2 != null) {
				Iterator<String> iter2 = info2.iterator(); //实例化Lterator
				while (iter2.hasNext()) {
		%>
		<h4 align="center"><%=iter2.next()%></h4>
		<%
			}
			}
		%>
		<form action="AdminAddnewsServlet" method="post">
			<p>
				Title:<input type="text" name="title" placeholder="请输入标题"
					style="height: 20px; width: 500px"><br>
			<p>
				Article:<input type="text" name="article" placeholder="请输入内容"
					style="height: 200px; width: 500px"><br>
			<p>
				Author: <input type="text" name="author" placeholder="请输入作者"
					style="height: 20px; width: 500px"><br>
			<p>
				Date: <input type="text" class="TIME" name="date" placeholder="请输入时间"
					style="height: 20px; width: 500px"><br>
			<p>
			<p>
			<p>
				<input type="submit" value="POST">
		</form>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			function shijian() {
				var TIME = document.getElementsByClassName('TIME')[0];
				var time = new Date();
				var year = time.getFullYear();
				var month = time.getMonth();
				var date = time.getDate();
				TIME.value = year + '-' + (month + 1) + '-' + date;
			}
			shijian();
			setInterval(shijian, 1000);
		}
	</script>
</body>
</html>