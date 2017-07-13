package com.loginservlettest.dao.proxy;

import com.loginservlettest.dao.IPostDAO;
import com.loginservlettest.dao.impl.PostDAOImpl;
import com.loginservlettest.jdbc.DatabaseConnection;
import com.loginservlettest.vo.Post;

public class PostDAOProxy implements IPostDAO {
	private DatabaseConnection dbc = null;
	private IPostDAO dao = null;
	
	public PostDAOProxy(){
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new PostDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean StartPost(Post post,String sjk) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.StartPost(post,sjk);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean DeleteNote(int postid, String sjk) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.DeleteNote(postid, sjk);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
}
