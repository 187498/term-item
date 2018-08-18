package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.User;
import com.scu03.dao.UserDao;
import com.scu03.email.EmailSending;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理中文乱码
		req.setCharacterEncoding("UTF-8");
		String account = req.getParameter("u_account");
		String fund = req.getParameter("wit");
		String state = req.getParameter("u_state");
		String phone = req.getParameter("u_phone");
		String email = req.getParameter("u_email");
		String pw = req.getParameter("u_pw");
		double withdraw = Double.parseDouble(fund);
		UserDao userdao = new UserDao();
		EmailSending em = new EmailSending();
		try{
			int i = userdao.userWithdrawal(account, withdraw);
			User user = userdao.getUserByAccountAndPassword(account, pw);
			double currFund = user.getUser_fund();
			if(i==0)
			{

				String errmsg = "余额不足,当前余额为："+currFund;
				req.setAttribute("errmsg",errmsg );
				req.getRequestDispatcher("/Withdraw.jsp").forward(req, resp);
			}
			else{
//				Textsending text = new Textsending();
//				text.sending(phone);
				
				em.sendingemail(email);
				String succmsg = "取款成功,当前余额为："+currFund;
				req.setAttribute("succmsg",succmsg );			
				req.getRequestDispatcher("/Withdraw.jsp").forward(req, resp);
				
			}
			}catch(SQLException | ParseException e)
			{
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

}
