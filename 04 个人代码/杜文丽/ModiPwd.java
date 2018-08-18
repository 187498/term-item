package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.Manager;
import com.scu03.bean.User;
import com.scu03.dao.ManagerDao;
import com.scu03.dao.UserDao;
import com.scu03.email.EmailSending;

@WebServlet("/ModiPwd")
public class ModiPwd extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理中文乱码
		req.setCharacterEncoding("UTF-8");
		//接收表单提交的参数
		String u_oldPwd = req.getParameter("oldPwd");
		String u_newPwd = req.getParameter("newPwd");
		String u_newPwd2=req.getParameter("newPwd2");
		String u_account = req.getParameter("u_account");
		String email = req.getParameter("u_email");
		
		
		if(u_newPwd.equals(u_newPwd2)){
			//使用DAO访问数据库
			UserDao u_dao = new UserDao();
			EmailSending em = new EmailSending();
			try {
				User u=u_dao.getUserByAccountAndPassword(u_account, u_oldPwd);
				
				if(u==null){
					req.setAttribute("errMessage", "原密码输入错误");
					req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//返回修改密码主页面
					return;
				}
				
				u_dao.modifyPassword(u_account,u_newPwd);
				
				req.setAttribute("success", "修改密码成功");
				em.sendingemail(email);
				req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//跳回管理员主界面
				return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//返回修改密码主页面
			}
			else{
				req.setAttribute("errMessage", "两次密码不一致");
				req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//返回修改密码主页面
			}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
