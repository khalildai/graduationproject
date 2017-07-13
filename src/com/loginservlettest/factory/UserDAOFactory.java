package com.loginservlettest.factory;

import com.loginservlettest.dao.IUserDAO;
import com.loginservlettest.dao.proxy.UserDAOProxy;

public class UserDAOFactory {
	public static IUserDAO getIUserDAOInstance() { // ȡ��DAOʵ��
		return new UserDAOProxy(); // ���ش���ʵ��
	}
}
