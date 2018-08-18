package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/NewsMPage")
public class NewsManagerPageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ManagerDao managerDao = new ManagerDao();
		List<News> allNews = null;
		
		try {
			allNews = managerDao.getAllNews();
			int totalRecord= allNews.size();
	        String temp = req.getParameter("pageNum");
	        int pageNum = Integer.parseInt(temp);
			int pageSize = 3;
			PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
			int startIndex = pb.getStartIndex();
			pb.setList(managerDao.findAllNews(startIndex, pageSize));
			
			req.setAttribute("pageBean", pb);
			req.getRequestDispatcher("/NewsManage.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		UserDao studentDao = new UserDao();
//		List<User> friends = null;
//		try {
//			friends = studentDao.getAllUser();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		req.setAttribute("fs", friends);
//		req.getRequestDispatcher("/test.jsp").forward(req, resp);

	}
}
