package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsPrintServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewsPrintServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "newsprint.jsp";
		String patherror = "homepage.jsp";
		String title = request.getParameter("title1");
		String retitle = new String(title.getBytes("ISO-8859-1"), "utf-8");
		List<String> info1 = new ArrayList<String>();
		if (info1.size() == 0) {
			info1.add(retitle);
			request.setAttribute("info1", info1);
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			info1.add("新闻提取失败，请重试!");
			request.setAttribute("info1", info1);
			request.getRequestDispatcher(patherror).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
