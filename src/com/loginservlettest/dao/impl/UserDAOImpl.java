package com.loginservlettest.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import com.loginservlettest.dao.IUserDAO;
import com.loginservlettest.vo.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDAOImpl implements IUserDAO {
	private Connection conn = null; // 定义数据库连接对象
	private PreparedStatement pstmt = null;

	public UserDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "SELECT name FROM user WHERE userid=? AND password=?";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql); // 实例化操作
			this.pstmt.setString(1, user.getUserid()); // 设置ID
			this.pstmt.setString(2, user.getPassword()); // 设置password
			ResultSet rs = this.pstmt.executeQuery(); // 取得查询结果
			if (rs.next()) {
				user.setName(rs.getString(1)); // 取得姓名
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

	@Override
	public boolean Register(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO user (userid,name,password) values(?,?,?)";
			this.pstmt = (PreparedStatement) conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getUserid());
			this.pstmt.setString(2, user.getName()); // 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
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
					this.pstmt.close(); // 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
