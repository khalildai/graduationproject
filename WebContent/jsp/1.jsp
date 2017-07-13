<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*" import="java.sql.*"%>
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

a {
	color: #000;
	text-decoration: none;
}

a:hover {
	color: gray;
}

table.table4news {
	font-family: verdana, arial, sans-serif;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
	background-color: #E7DFCA;
}

table.table4news th {
	font-size: 16px;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.table4news td {
	font-size: 15px;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #E7DFCA;
}
</style>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<h1>Welcome to NBA AREA!</h1>
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
	<div name="post1">
		<h3 align="left">POST：</h3>
		<input type="submit" name="replies" value="REPLIES"
			onclick="javascrtpt:window.location.href='replies.jsp'"
			style="height: 30px; width: 220px; float: right;"> <br>
		<p>
		<table border="1" width="80%" align="center" class="table4news">
			<%
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/test";
					Connection con = DriverManager.getConnection(url, "root", "root");
					Statement stmt = con.createStatement();
					String sql = "select title,article,author,date from nbaarea where postid=5";
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
			%>
			<tr>
				<td align="center"><%=rs.getObject(1)%></td>
				<td align="center"><%=rs.getObject(3)%>(楼主)</td>
				<td align="center"><%=rs.getObject(4)%></td>
			</tr>
			<tr>
				<td align="center" colspan="3"><%=rs.getObject(2)%></td>
			</tr>
			<%
				}
					rs.close();
					stmt.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</table>
	</div>

	<h3 align="left">REPLIES：</h3>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		List<String> info1 = (List<String>) request.getAttribute("info1");
		if (info1 != null) {
			Iterator<String> iter1 = info1.iterator(); //实例化Lterator
			while (iter1.hasNext()) {
	%>
	<p align="center"><%=iter1.next()%></p>
	<%
		}
		}
	%>
	<br>
	<table border="1" width="80%" align="center" class="table4news">
		<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/test";
				Connection con = DriverManager.getConnection(url, "root", "root");
				Statement stmt = con.createStatement();
				String sql = "select article,author,date from replies";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
		%>
		<tr>
			<td align="center" width="15%"><%=rs.getObject(2)%></td>
			<td align="center" width="70%"><%=rs.getObject(1)%></td>
			<td align="center" width="15%"><%=rs.getObject(3)%></td>
		</tr>
		<%
			}
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	
</body>
</html>










