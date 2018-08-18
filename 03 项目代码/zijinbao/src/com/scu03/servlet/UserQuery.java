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

import com.scu03.bean.News;
import com.scu03.bean.PageBean;
import com.scu03.bean.User;
import com.scu03.dao.ManagerDao;
import com.scu03.dao.UserDao;

import javafx.print.PageRange;

@WebServlet("/query_user")
public class UserQuery extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ManagerDao managerDao = new ManagerDao();
		List<User> CurrUser = null;
		String name = req.getParameter("u_name");
		String account = req.getParameter("u_account");
		String id = req.getParameter("u_id");
	
		try {
			CurrUser = managerDao.UserLikeSelect(name, account, id);
			List<User> temp2 = CurrUser;
//			for(User n : temp2){
//				System.out.println("all: "+ n.getUser_name());
//			}
			int totalRecord= CurrUser.size();
	        String temp = req.getParameter("pageNum") ;
	        int pageNum;
	        if(temp == null){
	        	pageNum = 1;
	        }else{
	        	pageNum = Integer.parseInt(temp);
	        }
			int pageSize = 5;
			PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
			int startIndex = pb.getStartIndex();		
			List<User> CurPage = new ArrayList<>();
			for(int i = startIndex;i<(startIndex + pageSize);i++){
				if(i<CurrUser.size())
				{			CurPage.add(CurrUser.get(i));}
			}
			pb.setList(CurPage);
			System.out.println(id);
			req.setAttribute("pageBean", pb);
			req.setAttribute("name", name);
			req.setAttribute("account", account);
			req.setAttribute("id", id);
			req.getRequestDispatcher("/AllUserInfoQuery.jsp").forward(req, resp);
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
