package com.loginservlettest.dao.impl;

import java.sql.Connection;

import com.loginservlettest.dao.IPostDAO;
import com.loginservlettest.vo.Post;
import com.mysql.jdbc.PreparedStatement;

public class PostDAOImpl implements IPostDAO {

	private Connection conn = null; // �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;

	public PostDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	@Override
	public boolean StartPost(Post post, String sjk) throws Exception {
		boolean flag = false;
		try {
			String sql = "INSERT INTO " + sjk + " (title,article,author,date) values(?,?,?,?)";
			this.pstmt = (PreparedStatement) conn.prepareStatement(sql);
			this.pstmt.setString(1, post.getTitle()); // ��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
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
					this.pstmt.close(); // �رղ���
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
					this.pstmt.close();// �رղ���
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}
