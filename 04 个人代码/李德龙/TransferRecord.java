package com.scu03.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scu03.bean.News;
import com.scu03.bean.PageBean;
import com.scu03.bean.Transfer;
import com.scu03.bean.User;
import com.scu03.dao.ManagerDao;
import com.scu03.dao.UserDao;

import javafx.print.PageRange;

@WebServlet("/t_r")
public class TransferRecord extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String account = req.getParameter("user_account");
		UserDao userDao = new UserDao();
		List<Transfer> transfer = null;
		
		try {
			transfer = userDao.getTransferByAccount(account);
			if(transfer.size()==0){
				req.getRequestDispatcher("/SearchTradeRecord.jsp").forward(req, resp);
			}
			int totalRecord= transfer.size();
	        String temp = req.getParameter("pageNum");
	        int pageNum = Integer.parseInt(temp);
			int pageSize = 3;
			PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
			int startIndex = pb.getStartIndex();
				
			List<Transfer> CurPage = new ArrayList<>();
			for(int i = startIndex;i<(startIndex + pageSize);i++){
				if(i<transfer.size()){			
					CurPage.add(transfer.get(i));
				}
			}
			pb.setList(CurPage);
			req.setAttribute("pageBean", pb);
			req.getRequestDispatcher("/SearchTradeRecord.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
