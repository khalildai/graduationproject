package com.loginservlettest.dao;

import com.loginservlettest.vo.Replies;

public interface IRepliesDAO {
	/**
	 * 
	 * @param replies
	 * @return 返回回帖信息列表
	 * @throws Exception
	 */
	public boolean PrintReplies(Replies replies)throws Exception;
}
