package com.loginservlettest.dao.impl;

import java.sql.Connection;

import com.loginservlettest.dao.IPostDAO;
import com.loginservlettest.vo.Post;
import com.mysql.jdbc.PreparedStatement;

public class PostDAOImpl implements IPostDAO {

	private Connection conn = null; // 定义数据库连接对象
	private PreparedStatement pstmt = null;

	public PostDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	@Override
	public boolean StartPost(Post post, String sjk) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO " + sjk + " (title,article,author,date) values(?,?,?,?)";
			this.pstmt = (PreparedStatement) conn.prepareStatement(sql);
			this.pstmt.setString(1, post.getTitle()); // 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
			this.pstmt.setString(2, post.getArticle());
			this.pstmt.setString(3, post.getAuthor());
			this.pstmt.setString(4, post.getDate());

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

	@Override
	public boolean DeleteNote(int postid, String sjk) throws Exception {
		boolean flag = false;
		try {
			String sql = "delete from " + sjk + " WHERE postid=" + postid;
			this.pstmt = (PreparedStatement) conn.prepareStatement(sql);
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
					this.pstmt.close();// 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
