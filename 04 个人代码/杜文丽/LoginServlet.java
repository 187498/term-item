package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.User;
import com.scu03.dao.UserDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	/**
	 * ����˻������Ƿ�ƥ���پ����Ƿ���ת����ҳ
	 * form method="post"
	 * �����ڵ�ַ����ʾ�û��������Ϣ
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������
		req.setCharacterEncoding("UTF-8");
		//���ձ��ύ�Ĳ���
		String u_account = req.getParameter("account");
		String u_pwd = req.getParameter("pwd");
		String ck = req.getParameter("ck");
		//ʹ��DAO�������ݿ�
		UserDao userDao = new UserDao();
		User user=null;
		try {
			user = userDao.getUserByAccountAndPassword(u_account, u_pwd);
			if(user != null){//��½�ɹ�
		        if("on".equals(ck)){
			        //����Cookie����
			        //��ӵ�Cookie��
			        Cookie c=new Cookie("users", u_account+"-"+u_pwd);
			        
			        //���ù���ʱ��
			        c.setMaxAge(600);
			        
			        
			        //�洢
			       resp.addCookie(c);
		        }

				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/MainUI.jsp").forward(req, resp);//��ת����ҳ
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("errmsg", "�˻�����������");
		
		req.getRequestDispatcher("/loginUser.jsp").forward(req, resp);//�����κ���������ص�½ҳ�棬��½ʧ��
		
		
//		System.out.println("account = " + account);
//		System.out.println("pwd = " + pwd);
//		//����½�˺���"acc"Ϊ�����浽request��
//		req.setAttribute("acc", account);
//		req.setAttribute("acc1", "hello world");
//		Student student = new Student();
//		student.setName("����");
//		student.setNumber("1000000001");
//		req.setAttribute("stu", student);
//		// ��ת����ҳ
//		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}
}
