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
 * 处理用户登陆界面提交的表单
 * @author 18749
 *
 */
public class LoginServletManager extends HttpServlet{
	/**
	 * 检查账户密码是否匹配再决定是否跳转到主页
	 * form method="post"
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理中文乱码
		req.setCharacterEncoding("UTF-8");
		//接收表单提交的参数
		String m_account = req.getParameter("account");
		String m_pwd = req.getParameter("pwd");
		String ck = req.getParameter("ck");
		req.setAttribute("errmsg", "");
		//使用DAO访问数据库
		ManagerDao managerDao = new ManagerDao();
		Manager manager=null;
		try {
			manager = managerDao.getManagerByAccountAndPassword(m_account,m_pwd);
			if(manager != null){//登陆成功
				 if("on".equals(ck)){
				        //构造Cookie对象
				        //添加到Cookie中
				        Cookie c=new Cookie("users", m_account+"-"+m_pwd);
				        
				        //设置过期时间
				        c.setMaxAge(600);
				        
				        
				        //存储
				       resp.addCookie(c);
			        }
				req.getSession().setAttribute("manager",manager);
				req.getRequestDispatcher("/AdminMainUI.jsp").forward(req, resp);//跳转到管理员主页
				return;
			}else{
				req.setAttribute("errmsg", "账户名或口令错误");
				req.getRequestDispatcher("/loginManager.jsp").forward(req, resp);//其他任何情况，返回管理员登陆页面，登陆失败
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
//		System.out.println("account = " + account);
//		System.out.println("pwd = " + pwd);
//		//将登陆账号以"acc"为名保存到request中
//		req.setAttribute("acc", account);
//		req.setAttribute("acc1", "hello world");
//		Student student = new Student();
//		student.setName("张三");
//		student.setNumber("1000000001");
//		req.setAttribute("stu", student);
//		// 跳转到主页
//		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

}
