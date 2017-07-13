package com.loginservlettest.dao.impl;

import java.sql.Connection;
import com.loginservlettest.dao.IRepliesDAO;
import com.loginservlettest.vo.Replies;
import com.mysql.jdbc.PreparedStatement;

public class RepliesDAOImpl implements IRepliesDAO {
	private Connection conn = null; // 定义数据库连接对象
	private PreparedStatement pstmt = null;

	public RepliesDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	@Override
	public boolean PrintReplies(Replies replies) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO replies (article,author,date) values(?,?,?)";
			this.pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			this.pstmt.setString(1, replies.getArticle());
			this.pstmt.setString(2, replies.getAuthor());
			this.pstmt.setString(3, replies.getDate());

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
