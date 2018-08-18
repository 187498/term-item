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
import com.scu03.bean.News;
import com.scu03.dao.ManagerDao;

import javafx.print.PageRange;

@WebServlet("/n_delete")
public class DeleteNews extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ManagerDao managerDao = new ManagerDao();
		String title = req.getParameter("n_title");
		try {
			managerDao.deleteNews(title);
			req.getRequestDispatcher("NewsMPage?pageNum=1").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
