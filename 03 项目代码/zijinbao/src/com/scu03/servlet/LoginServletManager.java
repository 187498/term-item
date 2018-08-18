package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.scu03.bean.Manager;
import com.scu03.dao.ManagerDao;


@WebServlet("/loginManager")
/**
 * �����û���½�����ύ�ı�
 * @author 18749
 *
 */
public class LoginServletManager extends HttpServlet{
	/**
	 * ����˻������Ƿ�ƥ���پ����Ƿ���ת����ҳ
	 * form method="post"
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������
		req.setCharacterEncoding("UTF-8");
		//���ձ��ύ�Ĳ���
		String m_account = req.getParameter("account");
		String m_pwd = req.getParameter("pwd");
		String ck = req.getParameter("ck");
		req.setAttribute("errmsg", "");
		//ʹ��DAO�������ݿ�
		ManagerDao managerDao = new ManagerDao();
		Manager manager=null;
		try {
			manager = managerDao.getManagerByAccountAndPassword(m_account,m_pwd);
			if(manager != null){//��½�ɹ�
				 if("on".equals(ck)){
				        //����Cookie����
				        //��ӵ�Cookie��
				        Cookie c=new Cookie("users", m_account+"-"+m_pwd);
				        
				        //���ù���ʱ��
				        c.setMaxAge(600);
				        
				        
				        //�洢
				       resp.addCookie(c);
			        }
				req.getSession().setAttribute("manager",manager);
				req.getRequestDispatcher("/AdminMainUI.jsp").forward(req, resp);//��ת������Ա��ҳ
				return;
			}else{
				req.setAttribute("errmsg", "�˻�����������");
				req.getRequestDispatcher("/loginManager.jsp").forward(req, resp);//�����κ���������ع���Ա��½ҳ�棬��½ʧ��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
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
