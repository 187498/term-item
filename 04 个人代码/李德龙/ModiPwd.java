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
		//������������
		req.setCharacterEncoding("UTF-8");
		//���ձ��ύ�Ĳ���
		String u_oldPwd = req.getParameter("oldPwd");
		String u_newPwd = req.getParameter("newPwd");
		String u_newPwd2=req.getParameter("newPwd2");
		String u_account = req.getParameter("u_account");
		String email = req.getParameter("u_email");
		
		
		if(u_newPwd.equals(u_newPwd2)){
			//ʹ��DAO�������ݿ�
			UserDao u_dao = new UserDao();
			EmailSending em = new EmailSending();
			try {
				User u=u_dao.getUserByAccountAndPassword(u_account, u_oldPwd);
				
				if(u==null){
					req.setAttribute("errMessage", "ԭ�����������");
					req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//�����޸�������ҳ��
					return;
				}
				
				u_dao.modifyPassword(u_account,u_newPwd);
				
				req.setAttribute("success", "�޸�����ɹ�");
				em.sendingemail(email);
				req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//���ع���Ա������
				return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//�����޸�������ҳ��
			}
			else{
				req.setAttribute("errMessage", "�������벻һ��");
				req.getRequestDispatcher("/ModiPwd.jsp").forward(req, resp);//�����޸�������ҳ��
			}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
