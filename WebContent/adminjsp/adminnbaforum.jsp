<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理NBA分区论坛</title>
<style>
body {
	text-align: center;
	background-color: #F1F1F1;
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
	width: 1300px;
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
	<div name="deletenote">
		<h3 align="left">NBA专区帖子管理：</h3>
		<form action="NBANoteDeleteServlet" method="post">
			NBA专区帖子管理：<input type="text" name="postid"> <input
				type="submit" value="删除">
		</form>
	</div>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		List<String> info1 = (List<String>) request.getAttribute("info1");
		if (info1 != null) {
			Iterator<String> iter1 = info1.iterator(); //实例化Lterator
			while (iter1.hasNext()) {
	%>
	<h4 align="center"><%=iter1.next()%></h4>
	<%
		}
		}
	%>
	<br>
	<table border="1" width="80%" class="table4news" align="center">
		<tr>
			<th width=20%>帖子序号</th>
			<th width=40%>帖子标题</th>
			<th width=20%>帖子作者</th>
			<th width=20%>发帖日期</th>
		</tr>
		<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/test";
				Connection con = DriverManager.getConnection(url, "root", "root");
				Statement stmt = con.createStatement();
				String sql = "select postid,title,author,date from nbaarea";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
		%>
		<tr>
			<td align="center" width=20% name="number"><%=rs.getObject(1)%></td>
			<td align="center" width=40%><%=rs.getObject(2)%></td>
			<td align="center" width=20%><%=rs.getObject(3)%></td>
			<td align="center" width=20%><%=rs.getObject(4)%></td>
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
</body>
</html>