package com.loginservlettest.dao;

import com.loginservlettest.vo.Post;

public interface IPostDAO {

	/**
	 * 
	 * @param post
	 * @return �����û���������Ϣ�б�
	 * @throws Exception
	 */

	public boolean StartPost(Post post,String sjk) throws Exception;

	/**
	 * @param ɾ��NBA���Ӳ���
	 * @return ����ɾ���������
	 * @throws exception
	 */

	public boolean DeleteNote(int postid,String sjk) throws Exception;
}
