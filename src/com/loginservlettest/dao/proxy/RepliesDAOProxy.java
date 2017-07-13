package com.loginservlettest.dao.proxy;

import com.loginservlettest.dao.IRepliesDAO;
import com.loginservlettest.dao.impl.RepliesDAOImpl;
import com.loginservlettest.jdbc.DatabaseConnection;
import com.loginservlettest.vo.Replies;

public class RepliesDAOProxy implements IRepliesDAO{
	private DatabaseConnection dbc = null;
	private IRepliesDAO dao = null;
	
	public RepliesDAOProxy(){
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new RepliesDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean PrintReplies(Replies replies) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.PrintReplies(replies);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
}
