package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.User;
import com.scu03.dao.UserDao;
import com.scu03.email.EmailSending;
@WebServlet("/deposite")
public class DepositeServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//处理中文乱码
			req.setCharacterEncoding("UTF-8");
			String account = req.getParameter("u_account");
			String fund = req.getParameter("amount");
			String email = req.getParameter("u_email");
			String pw = req.getParameter("u_pw");
			UserDao userdao = new UserDao();
			double amount = Double.parseDouble(fund);
			EmailSending em = new EmailSending();
			
//			System.out.println(fund);
			try{
				userdao.userEeposit(account, amount);
				User user = userdao.getUserByAccountAndPassword(account, pw);
				double currFund = user.getUser_fund();
				String succmsg = "存款成功,当前余额为："+currFund;
				req.setAttribute("succmsg",succmsg );			
				em.sendingemail(email);
				System.out.println(fund);
				req.getRequestDispatcher("/Deposit.jsp").forward(req, resp);
				
				
			}catch(SQLException e){
				e.printStackTrace();
			}
//			req.setAttribute("errmsg", "存款失败");
//			req.getRequestDispatcher("/Deposit.jsp").forward(req, resp);
		}
}
