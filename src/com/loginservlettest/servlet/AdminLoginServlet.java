package com.loginservlettest.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.loginservlettest.factory.AdminDAOFactory;
import com.loginservlettest.vo.Admin;

public class AdminLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathright = "adminhomepage.jsp";
		String patherror = "adminlogin.jsp";
		String adminid = req.getParameter("adminid");
		String adminpswd = req.getParameter("adminpswd");
		List<String> info = new ArrayList<String>();
		if (adminid == null || "".equals(adminid)) {
			info.add("����Աid����Ϊ��");
		}
		if (adminpswd == null || "".equals(adminpswd)) {
			info.add("���벻��Ϊ��");
		}
		if (info.size() == 0) {
			Admin admin = new Admin();
			admin.setAdminid(adminid);
			admin.setAdminpswd(adminpswd);
			try {
				if (AdminDAOFactory.getIAdminDAOInstance().adminLogin(admin)) {
					info.add("����Ա��¼�ɹ�����ӭ" + admin.getAdminname() + "��¼!");
					req.setAttribute("info", info);
					req.getRequestDispatcher(pathright).forward(req, resp);
				} else {
					info.add("����Ա��¼ʧ�ܣ�������û���������!");
					req.setAttribute("info", info);
					req.getRequestDispatcher(patherror).forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
