package com.scu03.servlet;

import java.io.IOException;
import com.scu03.bean.*;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.User;

import com.scu03.dao.UserDao;

@WebServlet("/Display")
public class DisplayUserinfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		Date user_birth;
		String user_name;
		String user_gender;
		String user_addr;
		String user_phone;
		String user_id;
		
		UserDao userdao = new UserDao();
		User currentuser = null;
		
		try {
			 currentuser = userdao.getUserByAccountAndPassword(req.getParameter("account"), req.getParameter("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   user_id = currentuser.getUser_id();
	   user_name = currentuser.getUser_name();
	   user_addr = currentuser.getUser_addr();
	   user_phone = currentuser.getUser_phone();
	   user_gender = currentuser.getUser_gender();
	   user_birth = currentuser.getUser_birth();
	   
	   req.setAttribute("user_name", user_name);
	   req.setAttribute("user_id", user_id);
	   req.setAttribute("user_addr", user_addr);
	   req.setAttribute("user_phone", user_phone);
	   req.setAttribute("user_birth", user_birth);
	   req.setAttribute("user_gender", user_gender);
	   
	   
	   req.getRequestDispatcher("/PersonalInfo.jsp").forward(req, resp);
		
	}
}
