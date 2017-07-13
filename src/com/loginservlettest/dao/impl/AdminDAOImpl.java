package com.loginservlettest.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.loginservlettest.dao.IAdminDAO;
import com.loginservlettest.vo.Admin;
import com.mysql.jdbc.PreparedStatement;

public class AdminDAOImpl implements IAdminDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public AdminDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	@Override
	public boolean adminLogin(Admin admin) throws Exception {
		boolean flag = false;
		try {
			String sql = "SELECT adminname FROM admin WHERE adminid=? AND adminpswd=?";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql); // ʵ��������
			this.pstmt.setString(1, admin.getAdminid()); // ����ID
			this.pstmt.setString(2, admin.getAdminpswd()); // ����password
			ResultSet rs = this.pstmt.executeQuery(); // ȡ�ò�ѯ���
			if (rs.next()) {
				admin.setAdminname(rs.getString(1)); // ȡ������
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

}
