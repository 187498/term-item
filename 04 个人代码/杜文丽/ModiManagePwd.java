package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.Manager;
import com.scu03.dao.ManagerDao;

@WebServlet("/ModiManagePwd")
public class ModiManagePwd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������������
		req.setCharacterEncoding("UTF-8");
		//���ձ��ύ�Ĳ���
		String m_oldPwd = req.getParameter("oldPwd");
		String m_newPwd = req.getParameter("newPwd");
		String m_newPwd2=req.getParameter("newPwd2");
		String m_account = req.getParameter("m_account");
		if(m_newPwd.equals(m_newPwd2)){//�������������������ͬ���������һ���޸�
		//ʹ��DAO�������ݿ�
		ManagerDao m_dao = new ManagerDao();
		try {
			
			Manager m = m_dao.getManagerByAccountAndPassword(m_account, m_oldPwd);
			if(m==null){
				req.setAttribute("errMessage", "ԭ�����������");
				req.setAttribute("success", null);
				req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//�����޸�������ҳ��
				return;
			}
			
			m_dao.UpdateManagePwd(m_account, m_oldPwd, m_newPwd);
			req.setAttribute("success", "�޸�����ɹ�");
			req.setAttribute("errMessage", null);
			req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//���ع���Ա������
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("errMessage", "ԭ�����������");
		req.setAttribute("success", null);
		req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//�����޸�������ҳ��
		}
		
		
		
		
		else{
			
			req.setAttribute("errMessage", "�������벻һ��");
			req.setAttribute("success", null);
			req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//�����޸�������ҳ��
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
