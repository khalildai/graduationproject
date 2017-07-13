<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	text-align: center;
	background-color: #F1F1F1;
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

<body>
	<h1>POST IN NBA AREA!</h1>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		List<String> info = (List<String>) request.getAttribute("info");
		if (info != null) {
			Iterator<String> iter = info.iterator(); //实例化Lterator
			while (iter.hasNext()) {
	%>
	<h4><%=iter.next()%></h4>
	<%
		}
		}
	%>
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
	<p>
		<br>
		<%
			request.setCharacterEncoding("UTF-8");
		%>
		<%
			List<String> infopost = (List<String>) request.getAttribute("infopost");
			if (infopost != null) {
				Iterator<String> iter = infopost.iterator(); //实例化Lterator
				while (iter.hasNext()) {
		%>

		<p align="center"><%=iter.next()%></p>
	<%
		}
		}
	%><br>
	<form action="PostServlet" method="post">
		<p>
			Title:<input type="text" name="title" placeholder="请输入标题"
				style="height: 20px; width: 500px"><br>
		<p>
			<span id="fenlei">分类：</span><select name="fenlei"
				style="height: 20px; width: 500px" id="fenlei">
				<option value="nbaarea" name="nbaarea">nbaarea</option>
				<option value="cbaarea" name="cbaarea">cbaarea</option>
				<option value="warriorsarea" name="warriorsarea">warriorsarea</option>
				<option value="cavaliersarea" name="cavaliersarea">cavaliersarea</option>
				<option value="otherarea" name="otherarea">otherarea</option>
			</select>
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










