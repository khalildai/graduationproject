package com.loginservlettest.factory;

import com.loginservlettest.dao.INewsDAO;
import com.loginservlettest.dao.proxy.NewsDAOProxy;

public class NewsDAOFactory {
	public static INewsDAO getINewsDAOInstance() { // 取得DAO实例
		return new NewsDAOProxy(); // 返回代理实例
	}
}
