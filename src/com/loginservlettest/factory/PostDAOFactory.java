package com.loginservlettest.factory;

import com.loginservlettest.dao.IPostDAO;
import com.loginservlettest.dao.proxy.PostDAOProxy;

public class PostDAOFactory {
	public static IPostDAO getIPostDAOInstance() {
		return new PostDAOProxy();
	}
}
