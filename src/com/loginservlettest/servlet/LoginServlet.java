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
			info.add("�û�id����Ϊ��");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("���벻��Ϊ��");
		}
		if (info.size() == 0) {
			User user = new User();
			user.setUserid(userid);
			user.setPassword(userpass);
			try {
				if (UserDAOFactory.getIUserDAOInstance().findLogin(user)) {
					info.add("�û���¼�ɹ�����ӭ" + user.getName() + "����!");
					req.setAttribute("info", info);
					req.getRequestDispatcher(path1).forward(req, resp);
				} else {
					info.add("�û���¼ʧ�ܣ�������û���������!");
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
