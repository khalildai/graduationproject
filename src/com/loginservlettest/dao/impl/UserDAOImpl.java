package com.loginservlettest.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import com.loginservlettest.dao.IUserDAO;
import com.loginservlettest.vo.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDAOImpl implements IUserDAO {
	private Connection conn = null; // �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;

	public UserDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "SELECT name FROM user WHERE userid=? AND password=?";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql); // ʵ��������
			this.pstmt.setString(1, user.getUserid()); // ����ID
			this.pstmt.setString(2, user.getPassword()); // ����password
			ResultSet rs = this.pstmt.executeQuery(); // ȡ�ò�ѯ���
			if (rs.next()) {
				user.setName(rs.getString(1)); // ȡ������
				flag = true; // ��½�ɹ�
			}
		} catch (Exception e) {
			throw e; // �����׳��쳣
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close(); // �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean Register(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO user (userid,name,password) values(?,?,?)";
			this.pstmt = (PreparedStatement) conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getUserid());
			this.pstmt.setString(2, user.getName()); // ��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
			this.pstmt.setString(3, user.getPassword());

			int i = this.pstmt.executeUpdate();
			if (i == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close(); // �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
