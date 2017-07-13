package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginservlettest.factory.NewsDAOFactory;
import com.loginservlettest.vo.News;

public class NewsDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewsDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "adminhomepage.jsp";
		Integer newsid = Integer.valueOf(request.getParameter("newid"));
		List<String> info1 = new ArrayList<String>();
		if (info1.size() == 0) {
			News news = new News();
			news.setNewsid(newsid);
			try {
				if (NewsDAOFactory.getINewsDAOInstance().DeleteNews(newsid)) {
					info1.add("删除成功！");
					request.setAttribute("info1", info1);
					request.getRequestDispatcher(path).forward(request, response);
				} else {
					info1.add("删除失败，为找到指定新闻信息！");
					request.setAttribute("info1", info1);
					request.getRequestDispatcher(path).forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
