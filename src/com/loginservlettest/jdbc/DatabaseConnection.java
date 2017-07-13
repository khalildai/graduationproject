package com.loginservlettest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	// �������ݿ���������
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// ���ݿ����ӵ�ַ
	private static final String DBURL = "jdbc:mysql://localhost:3306/test";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private Connection conn = null;

	public DatabaseConnection() throws Exception { // �ڹ��췽���н������ݿ�����
		try {
			Class.forName(DBDRIVER); // ������������
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // �������ݿ�
		} catch (Exception e) { // �˴�Ϊ�˼�ֱ���׳�exception
			throw e;
		}
	}

	public Connection getConnection() { // ȡ�����ݿ�����
		return this.conn; // ȡ�����ݿ�����
	}

	public void close() throws Exception { // ���ݿ�رղ���
		if (this.conn != null) { // ����NULLPOINTEREXCEPTION
			try {
				this.conn.close(); // ���ݿ�ر�
			} catch (Exception e) { // �׳��쳣
				throw e;
			}
		}
	}
}
