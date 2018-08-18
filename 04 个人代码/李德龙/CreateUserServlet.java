package com.scu03.servlet;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������
		req.setCharacterEncoding("UTF-8");
		//���ձ��ύ�Ĳ���
		
		String u_Pwd1 = req.getParameter("pwd1");
		String u_Pwd2=req.getParameter("pwd2");
		String u_account = req.getParameter("account");
		
		
		String money= req.getParameter("money");
		String date = req.getParameter("u_birth");
		Double u_money;
		Date u_birth;
		if(date.length()<=0||money.length()<=0){
			req.setAttribute("fail", "����д������Ϣ");
			req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);//���ؿ�������
			return;
		}
		
		else{
			u_money =  Double.valueOf(money);
			u_birth=Date.valueOf(date) ;
		}
		 
		String u_name = req.getParameter("name");
		String u_addr = req.getParameter("address");
		String u_phone = req.getParameter("phone");
		String u_id = req.getParameter("user_id");
		String u_email = req.getParameter("email");
		String u_gender = req.getParameter("gender");
		
		
		
		User u=new User();
		
		
		if(u_Pwd1==null || u_Pwd2==null || u_account==null || u_money==null || u_name==null || u_addr==null || u_phone ==null || u_id==null || u_email==null || u_gender==null || u_birth==null )
		{
			req.setAttribute("fail", "����д������Ϣ");
			req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);//���ؿ�������
			return;
		}
		else if(u_Pwd1.equals(u_Pwd2)){
			//�����ݵ�user����
			u.setPassword(u_Pwd1);
			u.setUser_account(u_account);
			u.setRecord_money(u_money);
			u.setUser_name(u_name);
			u.setUser_addr(u_addr);
			u.setUser_phone(u_phone);
			u.setUser_id(u_id);
			u.setUser_gender(u_gender);
			u.setUser_birth(u_birth);
			u.setUser_email(u_email);
			u.setUser_state(1);
			//ʹ��DAO�������ݿ�
			
			ManagerDao m_dao = new ManagerDao();
			try {
				m_dao.insertUserInfo(u);
				req.setAttribute("success", "�����ɹ�");
				req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);//���ؿ�������
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("fail", "����ʧ��");
			req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);//���ؿ�������
		}
		else
		{
			req.setAttribute("fail", "�������벻һ��");
			req.getRequestDispatcher("/CreateUser.jsp").forward(req, resp);//���ؿ�������
			return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
