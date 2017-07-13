package com.loginservlettest.dao;

import com.loginservlettest.vo.Admin;

public interface IAdminDAO {
	
	/**
	 * 管理员登录
	 * 
	 * @param admin传入VO对象
	 * @return 返回管理员登录结果
	 * @throws Exception
	 */
	
	public boolean adminLogin(Admin admin)throws Exception;
}
