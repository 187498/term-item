package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.PageBean;
import com.scu03.bean.User;
import com.scu03.dao.ManagerDao;

import javafx.print.PageRange;

@WebServlet("/delete_user")
public class DeleteUser extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		ManagerDao managerDao = new ManagerDao();		
		String account = req.getParameter("u_account");
		try {
			managerDao.deleteUserAccount(account);
			req.getRequestDispatcher("all_user?pageNum=1").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
