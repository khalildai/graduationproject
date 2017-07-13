package com.loginservlettest.dao.proxy;

import com.loginservlettest.dao.INewsDAO;
import com.loginservlettest.dao.impl.NewsDAOImpl;
import com.loginservlettest.jdbc.DatabaseConnection;
import com.loginservlettest.vo.News;

public class NewsDAOProxy implements INewsDAO {
	private DatabaseConnection dbc = null;
	private INewsDAO dao = null;
	
	public NewsDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new NewsDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean UploadNews(News news) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.UploadNews(news);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean DeleteNews(int newsid) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.DeleteNews(newsid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
	
	
}
