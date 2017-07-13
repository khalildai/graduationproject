package com.loginservlettest.dao.proxy;

import com.loginservlettest.dao.IAdminDAO;
import com.loginservlettest.dao.impl.AdminDAOImpl;
import com.loginservlettest.jdbc.DatabaseConnection;
import com.loginservlettest.vo.Admin;

public class AdminDAOProxy implements IAdminDAO {
	private DatabaseConnection dbc = null;
	private IAdminDAO dao = null;
	
	public AdminDAOProxy() {
		try{
			this.dbc = new DatabaseConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new AdminDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean adminLogin(Admin admin) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.adminLogin(admin);
		}catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

}
