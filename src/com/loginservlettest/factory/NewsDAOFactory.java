package com.loginservlettest.factory;

import com.loginservlettest.dao.INewsDAO;
import com.loginservlettest.dao.proxy.NewsDAOProxy;

public class NewsDAOFactory {
	public static INewsDAO getINewsDAOInstance() { // ȡ��DAOʵ��
		return new NewsDAOProxy(); // ���ش���ʵ��
	}
}
