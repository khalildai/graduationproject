package com.loginservlettest.dao;

import com.loginservlettest.vo.User;

public interface IUserDAO {

	/**
	 * �û�ע��
	 * 
	 * @param uesr����VO����
	 * @return �����û�ע�����Ϣ�б�
	 * @throws Exception
	 */

	public boolean Register(User user) throws Exception;

	/**
	 * �û���¼��֤
	 * 
	 * @param user����VO����
	 * @return ��֤�Ĳ������
	 * @throws Exception
	 */

	public boolean findLogin(User user) throws Exception;
}
