package com.scu03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.text.TextSending;

@WebServlet("/p_code")
public class PhoneCode extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		TextSending tx = new TextSending();
		String phone = req.getParameter("phone");
		String code = tx.sending(phone);
		System.out.println(code);
		req.getSession().setAttribute("code", code);
		req.getRequestDispatcher("/ModiPerInfo.jsp").forward(req, resp);
		
	}
}
