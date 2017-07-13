package com.loginservlettest.dao;

import com.loginservlettest.vo.User;

public interface IUserDAO {

	/**
	 * 用户注册
	 * 
	 * @param uesr传入VO对象
	 * @return 返回用户注册的信息列表
	 * @throws Exception
	 */

	public boolean Register(User user) throws Exception;

	/**
	 * 用户登录验证
	 * 
	 * @param user传入VO对象
	 * @return 验证的操作结果
	 * @throws Exception
	 */

	public boolean findLogin(User user) throws Exception;
}
