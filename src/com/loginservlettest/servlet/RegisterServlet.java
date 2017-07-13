package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginservlettest.factory.UserDAOFactory;
import com.loginservlettest.vo.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "login.jsp";
		String userid = req.getParameter("userid");
		String username = req.getParameter("username");
		String userpass = req.getParameter("userpass");
		String confirm = req.getParameter("confrim");
		List<String> info = new ArrayList<String>();
		if (userid == null || "".equals(userid)) {
			info.add("用户id不能为空");
		}
		if (username == null || "".equals(username)) {
			info.add("用户名不能为空");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("密码不能为空");
		}
		if ("".equals(confirm)) {
			info.add("确认密码不能为空");
		}
		if (info.size() == 0) {
			User user = new User();
			user.setUserid(userid);
			user.setName(userid);
			user.setPassword(userpass);
			user.setConfirm(confirm);
			try {
				if (UserDAOFactory.getIUserDAOInstance().Register(user)) {
					info.add("用户注册成功请登录！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("info", info);
		req.getRequestDispatcher(path).forward(req, resp);
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
