package com.loginservlettest.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.loginservlettest.dao.IAdminDAO;
import com.loginservlettest.vo.Admin;
import com.mysql.jdbc.PreparedStatement;

public class AdminDAOImpl implements IAdminDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public AdminDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	@Override
	public boolean adminLogin(Admin admin) throws Exception {
		boolean flag = false;
		try {
			String sql = "SELECT adminname FROM admin WHERE adminid=? AND adminpswd=?";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql); // 实例化操作
			this.pstmt.setString(1, admin.getAdminid()); // 设置ID
			this.pstmt.setString(2, admin.getAdminpswd()); // 设置password
			ResultSet rs = this.pstmt.executeQuery(); // 取得查询结果
			if (rs.next()) {
				admin.setAdminname(rs.getString(1)); // 取得姓名
				flag = true; // 登陆成功
			}
		} catch (Exception e) {
			throw e; // 向上抛出异常
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close(); // 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

}
