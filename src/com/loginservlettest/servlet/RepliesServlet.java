package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginservlettest.factory.RepliesDAOFactory;
import com.loginservlettest.vo.Replies;

/**
 * Servlet implementation class RepliesServlet
 */

public class RepliesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RepliesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "1.jsp";
		String patherror = "replies.jsp";
		String article = request.getParameter("article");
		String rearticle = new String(article.getBytes("ISO-8859-1"), "utf-8");
		String author = request.getParameter("author");
		String reauthor = new String(author.getBytes("ISO-8859-1"), "utf-8");
		String date = request.getParameter("date");
		String redate = new String(date.getBytes("ISO-8859-1"), "utf-8");
		List<String> info1 = new ArrayList<String>();
		if (rearticle == null || "".equals(rearticle)) {
			info1.add("文章不能为空");
		}
		if (reauthor == null || "".equals(reauthor)) {
			info1.add("作者不能为空");
		}
		if (info1.size() == 0) {
			Replies replies = new Replies();
			replies.setAuthor(rearticle);
			replies.setArticle(reauthor);
			replies.setDate(redate);
			try {
				if (RepliesDAOFactory.getIRepliesInstance().PrintReplies(replies)) {
					info1.add("回复成功！");
					request.setAttribute("info1", info1);
					request.getRequestDispatcher(path).forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("info1", info1);
			request.getRequestDispatcher(patherror).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
