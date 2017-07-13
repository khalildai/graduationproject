package com.loginservlettest.factory;

import com.loginservlettest.dao.IRepliesDAO;
import com.loginservlettest.dao.proxy.RepliesDAOProxy;

public class RepliesDAOFactory {
	public static IRepliesDAO getIRepliesInstance(){
		return new RepliesDAOProxy();
	}
}
