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
		//处理中文乱码
		req.setCharacterEncoding("UTF-8");
		//接收表单提交的参数
		String m_oldPwd = req.getParameter("oldPwd");
		String m_newPwd = req.getParameter("newPwd");
		String m_newPwd2=req.getParameter("newPwd2");
		String m_account = req.getParameter("m_account");
		if(m_newPwd.equals(m_newPwd2)){//如果两次输入新密码相同，则进入下一步修改
		//使用DAO访问数据库
		ManagerDao m_dao = new ManagerDao();
		try {
			
			Manager m = m_dao.getManagerByAccountAndPassword(m_account, m_oldPwd);
			if(m==null){
				req.setAttribute("errMessage", "原密码输入错误");
				req.setAttribute("success", null);
				req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//返回修改密码主页面
				return;
			}
			
			m_dao.UpdateManagePwd(m_account, m_oldPwd, m_newPwd);
			req.setAttribute("success", "修改密码成功");
			req.setAttribute("errMessage", null);
			req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//跳回管理员主界面
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("errMessage", "原密码输入错误");
		req.setAttribute("success", null);
		req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//返回修改密码主页面
		}
		
		
		
		
		else{
			
			req.setAttribute("errMessage", "两次密码不一致");
			req.setAttribute("success", null);
			req.getRequestDispatcher("/ModiManagePwd.jsp").forward(req, resp);//返回修改密码主页面
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
