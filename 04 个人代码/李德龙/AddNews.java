package com.scu03.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.News;
import com.scu03.bean.PageBean;
import com.scu03.bean.User;
import com.scu03.dao.ManagerDao;
import com.scu03.dao.UserDao;

import javafx.print.PageRange;

@WebServlet("/n_add")
public class AddNews extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ManagerDao managerDao = new ManagerDao();
		String title = req.getParameter("n_title");
		Date date = new Date(System.currentTimeMillis());
		String n_message = req.getParameter("n_message");
		News news = new News();
		news.setDate(date);
		news.setNews_title(title);
		news.setNews_content(n_message);
		try {
			managerDao.addNews(news);
			req.getRequestDispatcher("NewsMPage?pageNum=1").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
