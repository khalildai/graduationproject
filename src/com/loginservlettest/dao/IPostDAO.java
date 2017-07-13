package com.loginservlettest.dao;

import com.loginservlettest.vo.Post;

public interface IPostDAO {

	/**
	 * 
	 * @param post
	 * @return 返回用户发帖的信息列表
	 * @throws Exception
	 */

	public boolean StartPost(Post post,String sjk) throws Exception;

	/**
	 * @param 删除NBA帖子操作
	 * @return 返回删除操作结果
	 * @throws exception
	 */

	public boolean DeleteNote(int postid,String sjk) throws Exception;
}
