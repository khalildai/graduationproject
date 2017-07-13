package com.loginservlettest.dao;

import com.loginservlettest.vo.News;

public interface INewsDAO {

	/**
	 * 
	 * @param �ϴ����Ų���
	 * @return �����ϴ������Ľ��
	 * @throws Exception
	 */
	
	public boolean UploadNews(News news) throws Exception;

	/**
	 * 
	 * @param ɾ�����Ų���
	 * @return ����ɾ�������Ľ��
	 * @throws Exception
	 */
	
	public boolean DeleteNews(int newsid)throws Exception;
}
