package com.loginservlettest.factory;

import com.loginservlettest.dao.IUserDAO;
import com.loginservlettest.dao.proxy.UserDAOProxy;

public class UserDAOFactory {
	public static IUserDAO getIUserDAOInstance() { // 取得DAO实例
		return new UserDAOProxy(); // 返回代理实例
	}
}
