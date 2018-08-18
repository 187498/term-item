package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.dao.UserDao;
import com.scu03.email.EmailSending;
@WebServlet("/modify_info")
public class Modify_UserServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("u_id");
		String phone = req.getParameter("phone_num");
		String address = req.getParameter("address");
		String email = req.getParameter("u_email");
		UserDao userdao = new UserDao();
		EmailSending em = new EmailSending();
		
		/*System.out.println(phone);
		System.out.println(address);*/
		try {
			userdao.modifyAddr(id, address);
			userdao.modifyPhone(id, phone);
			req.setAttribute("succmsg", "ÐÞ¸Ä³É¹¦");
			em.sendingemail(email);
			req.getRequestDispatcher("/ModiPerInfo.jsp").forward(req, resp);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
