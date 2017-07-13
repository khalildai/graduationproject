<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
body {
	text-align: center;
	background-color: #f1f1f1;
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

.daohang {
	border-radius: 5px;
	background-color: rgb(200, 200, 200);
	width: 1050px;
	height: 60px;
	line-height: 60px;
	margin: 0 auto;
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
	%>
	<h4 align="right">
		<a href="login.jsp" style="color: #CC3341"
			style="text-decoration: none">Please Login！</a>
	</h4>
	<%
		}
	%>
	<h1 style="color: #0C0C0C">Welcome to KD's forum!</h1>
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
	<div name="nbanews">
		<h3 align="left" style="color: #0C0C0C; padding-left: 368px">NBAnews：</h3>
		<table border="1" cellspacing="0" width="60%" align="center"
			class="table4news">
			<tr>
				<th width=60%>Title</th>
				<th width=20%>Author</th>
				<th width=20%>Date</th>
			</tr>
			<%
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/test";
					Connection con = DriverManager.getConnection(url, "root", "root");
					Statement stmt = con.createStatement();
					String sql = "select title,author,date from nbanews";
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
			%>
			<tr>
				<td align="center" width=60%><a href="newsprint.jsp"><%=rs.getObject(1)%></a></td>
				<td align="center" width=20%><%=rs.getObject(2)%></td>
				<td align="center" width=20%><%=rs.getObject(3)%></td>
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
</body>
</html>









