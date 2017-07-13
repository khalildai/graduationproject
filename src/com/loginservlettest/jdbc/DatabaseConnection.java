package com.loginservlettest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	// 定义数据库驱动程序
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// 数据库链接地址
	private static final String DBURL = "jdbc:mysql://localhost:3306/test";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private Connection conn = null;

	public DatabaseConnection() throws Exception { // 在构造方法中进行数据库连接
		try {
			Class.forName(DBDRIVER); // 加载驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // 连接数据库
		} catch (Exception e) { // 此处为了简单直接抛出exception
			throw e;
		}
	}

	public Connection getConnection() { // 取得数据库连接
		return this.conn; // 取得数据库连接
	}

	public void close() throws Exception { // 数据库关闭操作
		if (this.conn != null) { // 避免NULLPOINTEREXCEPTION
			try {
				this.conn.close(); // 数据库关闭
			} catch (Exception e) { // 抛出异常
				throw e;
			}
		}
	}
}
