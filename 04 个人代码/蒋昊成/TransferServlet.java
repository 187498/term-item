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
@WebServlet("/trans")
public class TransferServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//处理中文乱码
			req.setCharacterEncoding("UTF-8");
			String from_account = req.getParameter("u_account");
			String to_account = req.getParameter("account");
			String fund = req.getParameter("amount");
			String email = req.getParameter("u_email");
			String account = req.getParameter("u_account");
			String pw = req.getParameter("u_pw");
			double amount = Double.parseDouble(fund);
			UserDao userdao = new UserDao();
			EmailSending em = new EmailSending();
			
			try{
				
				User user1 = userdao.getByAccount(to_account);
				if(user1 != null){
				int i = userdao.userTransfer(from_account, to_account, amount);
				User user = userdao.getUserByAccountAndPassword(account, pw);
				double currFund = user.getUser_fund();
				if(i==0){
					String errmsg = "余额不足,当前余额为："+currFund;
					req.setAttribute("errmsg",errmsg );
								
					req.getRequestDispatcher("/Transfer.jsp").forward(req, resp);
				}
				else{
					String succmsg = "转账成功,当前余额为："+currFund;
					req.setAttribute("succmsg",succmsg );			
					
					req.getRequestDispatcher("/Transfer.jsp").forward(req, resp);
					em.sendingemail(email);
				}}else{
					String errmsg = "对方用户不存在";
					req.setAttribute("errmsg",errmsg );
								
					req.getRequestDispatcher("/Transfer.jsp").forward(req, resp);
				}
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				
			}
		
}
