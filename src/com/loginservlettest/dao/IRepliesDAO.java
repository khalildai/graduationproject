package com.loginservlettest.dao;

import com.loginservlettest.vo.Replies;

public interface IRepliesDAO {
	/**
	 * 
	 * @param replies
	 * @return ���ػ�����Ϣ�б�
	 * @throws Exception
	 */
	public boolean PrintReplies(Replies replies)throws Exception;
}
