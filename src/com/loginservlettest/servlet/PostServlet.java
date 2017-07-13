package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginservlettest.factory.PostDAOFactory;
import com.loginservlettest.vo.Post;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = null;
		String path1 = "startpost.jsp";
		String sjk = request.getParameter("fenlei");
		if (sjk.equals("nbaarea")) {
			path = "nbaforum.jsp";
		} else if (sjk.equals("cbaarea")) {
			path = "cbaforum.jsp";
		} else if (sjk.equals("warriorsarea")) {
			path = "warriorsforum.jsp";
		} else if (sjk.equals("cavaliersarea")) {
			path = "cavaliersforum.jsp";
		} else if (sjk.equals("otherarea")) {
			path = "otherforum.jsp";
		}
		String title = request.getParameter("title");
		String retitle = new String(title.getBytes("ISO-8859-1"), "utf-8");
		String article = request.getParameter("article");
		String rearticle = new String(article.getBytes("ISO-8859-1"), "utf-8");
		String author = request.getParameter("author");
		String reauthor = new String(author.getBytes("ISO-8859-1"), "utf-8");
		String date = request.getParameter("date");
		List<String> infopost = new ArrayList<String>();
		if (retitle == null || "".equals(retitle)) {
			infopost.add("标题不能为空");
		}
		if (rearticle == null || "".equals(rearticle)) {
			infopost.add("文章不能为空");
		}
		if (reauthor == null || "".equals(reauthor)) {
			infopost.add("作者不能为空");
		}
		if (infopost.size() == 0) {
			Post post = new Post();
			post.setTitle(retitle);
			post.setArticle(rearticle);
			post.setAuthor(reauthor);
			post.setDate(date);
			try {
				if (PostDAOFactory.getIPostDAOInstance().StartPost(post, sjk)) {
					infopost.add("用户发帖成功！");
					request.setAttribute("infopost", infopost);
					request.getRequestDispatcher(path).forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("infopost", infopost);
			request.getRequestDispatcher(path1).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
