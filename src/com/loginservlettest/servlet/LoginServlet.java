package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginservlettest.factory.UserDAOFactory;
import com.loginservlettest.vo.User;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "login.jsp";
		String path1 = "homepage.jsp";
		String userid = req.getParameter("userid");
		String userpass = req.getParameter("userpass");
		List<String> info = new ArrayList<String>();
		if (userid == null || "".equals(userid)) {
			info.add("用户id不能为空");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("密码不能为空");
		}
		if (info.size() == 0) {
			User user = new User();
			user.setUserid(userid);
			user.setPassword(userpass);
			try {
				if (UserDAOFactory.getIUserDAOInstance().findLogin(user)) {
					info.add("用户登录成功，欢迎" + user.getName() + "光临!");
					req.setAttribute("info", info);
					req.getRequestDispatcher(path1).forward(req, resp);
				} else {
					info.add("用户登录失败，错误的用户名和密码!");
					req.setAttribute("info", info);
					req.getRequestDispatcher(path).forward(req, resp);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
