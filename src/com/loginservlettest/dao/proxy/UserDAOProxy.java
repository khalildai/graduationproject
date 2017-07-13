package com.loginservlettest.dao.proxy;

import com.loginservlettest.dao.IUserDAO;
import com.loginservlettest.dao.impl.UserDAOImpl;
import com.loginservlettest.jdbc.DatabaseConnection;
import com.loginservlettest.vo.User;

public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null;
	private IUserDAO dao = null;

	public UserDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(user);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean Register(User user) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.Register(user);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
}
