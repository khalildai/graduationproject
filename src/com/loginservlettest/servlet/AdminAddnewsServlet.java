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

public class AdminAddnewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminAddnewsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "adminhomepage.jsp";
		String path1 = "adminaddnews.jsp";
		String title = request.getParameter("title");
		String retitle = new String(title.getBytes("ISO-8859-1"), "utf-8");
		String article = request.getParameter("article");
		String rearticle = new String(article.getBytes("ISO-8859-1"), "utf-8");
		String author = request.getParameter("author");
		String reauthor = new String(author.getBytes("ISO-8859-1"), "utf-8");
		String date = request.getParameter("date");
		List<String> info2 = new ArrayList<String>();
		if (retitle == null || "".equals(retitle)) {
			info2.add("���ⲻ��Ϊ��,���������룡");
			request.setAttribute("info2", info2);
			request.getRequestDispatcher(path1).forward(request, response);
		}
		if (rearticle == null || "".equals(rearticle)) {
			info2.add("���²���Ϊ�գ����������룡");
			request.setAttribute("info2", info2);
			request.getRequestDispatcher(path1).forward(request, response);
		}
		if (reauthor == null || "".equals(reauthor)) {
			info2.add("���߲���Ϊ�գ����������룡");
			request.setAttribute("info2", info2);
			request.getRequestDispatcher(path1).forward(request, response);
		}
		if (date == null || "".equals(date)) {
			info2.add("ʱ�䲻��Ϊ�գ����������룡");
			request.setAttribute("info2", info2);
			request.getRequestDispatcher(path1).forward(request, response);
		}
		if (info2.size() == 0) {
			News news = new News();
			news.setTitle(retitle);
			news.setArticle(rearticle);
			news.setAuthor(reauthor);
			news.setDate(date);
			try {
				if (NewsDAOFactory.getINewsDAOInstance().UploadNews(news)) {
					info2.add("���ŷ����ɹ���");
					request.setAttribute("info2", info2);
					request.getRequestDispatcher(path).forward(request, response);
				} else {
					info2.add("���ŷ���ʧ�ܣ������·�����");
					request.setAttribute("info2", info2);
					request.getRequestDispatcher(path1).forward(request, response);
				}
			} catch (Exception e) {
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
