package com.loginservlettest.factory;

import com.loginservlettest.dao.IAdminDAO;
import com.loginservlettest.dao.proxy.AdminDAOProxy;

public class AdminDAOFactory {
	public static IAdminDAO getIAdminDAOInstance(){
		return new AdminDAOProxy();
	}
}
