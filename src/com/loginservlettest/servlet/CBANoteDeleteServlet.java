package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginservlettest.factory.PostDAOFactory;
import com.loginservlettest.vo.Post;

public class CBANoteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CBANoteDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "admincbaforum.jsp";
		String sjk = "cbaarea";
		Integer postid = Integer.valueOf(request.getParameter("postid"));
		List<String> info1 = new ArrayList<String>();
		if (info1.size() == 0) {
			Post post = new Post();
			post.setPostid(postid);
			try {
				if (PostDAOFactory.getIPostDAOInstance().DeleteNote(postid, sjk)) {
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
