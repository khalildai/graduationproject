package com.loginservlettest.dao;

import com.loginservlettest.vo.News;

public interface INewsDAO {

	/**
	 * 
	 * @param 上传新闻操作
	 * @return 返回上传操作的结果
	 * @throws Exception
	 */
	
	public boolean UploadNews(News news) throws Exception;

	/**
	 * 
	 * @param 删除新闻操作
	 * @return 返回删除操作的结果
	 * @throws Exception
	 */
	
	public boolean DeleteNews(int newsid)throws Exception;
}
