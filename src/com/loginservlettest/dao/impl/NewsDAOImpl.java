package com.loginservlettest.dao.impl;

import java.sql.Connection;
import com.loginservlettest.dao.INewsDAO;
import com.loginservlettest.vo.News;
import com.mysql.jdbc.PreparedStatement;

public class NewsDAOImpl implements INewsDAO {
	private Connection conn = null; // �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;

	public NewsDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	@Override
	public boolean UploadNews(News news) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO nbanews (title,article,author,date) values(?,?,?,?)";
			this.pstmt = (PreparedStatement) conn.prepareStatement(sql);
			this.pstmt.setString(1, news.getTitle());
			this.pstmt.setString(2, news.getArticle());
			this.pstmt.setString(3, news.getAuthor());
			this.pstmt.setString(4, news.getDate());
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
					this.pstmt.close();// �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	@Override
	public boolean DeleteNews(int newsid) throws Exception {
		boolean flag = false;
		try {
			String sql = "delete from nbanews WHERE id=" + newsid;
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
					this.pstmt.close();// �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
