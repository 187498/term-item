package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.PageBean;
import com.scu03.bean.User;
import com.scu03.dao.UserDao;

import javafx.print.PageRange;

@WebServlet("/f_user")
public class FreezeUser extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		UserDao userDao = new UserDao();
		List<User> allUser = null;
		
		try {
			allUser = userDao.getAllUser();
			
			List<User> User = new ArrayList<>();
			for(int i=0;i<allUser.size();i++){
				if(allUser.get(i).getUser_state() == 0)
				{	User.add(allUser.get(i));}
			}
			
			int totalRecord= User.size();
	         String temp = req.getParameter("pageNum");
	         int pageNum = Integer.parseInt(temp);
			int pageSize = 2;
			PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
			int startIndex = pb.getStartIndex();
			
			
			List<User> CurPage = new ArrayList<>();
			for(int i = startIndex;i<(startIndex + pageSize);i++){
				if(i<User.size())
				{			CurPage.add(User.get(i));}
			}
			pb.setList(CurPage);
//			System.out.println(CurPage.get(0).getUser_addr());
			req.setAttribute("pageBean", pb);
			req.getRequestDispatcher("/FreezeUser.jsp").forward(req, resp);
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
