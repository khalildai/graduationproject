package com.loginservlettest.dao;

import com.loginservlettest.vo.Admin;

public interface IAdminDAO {
	
	/**
	 * ����Ա��¼
	 * 
	 * @param admin����VO����
	 * @return ���ع���Ա��¼���
	 * @throws Exception
	 */
	
	public boolean adminLogin(Admin admin)throws Exception;
}
