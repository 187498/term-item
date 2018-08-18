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
import com.scu03.dao.ManagerDao;

@WebServlet("/n_query")
public class NewsQuery extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login...");
		String title = req.getParameter("n_title");
		ManagerDao managerDao = new ManagerDao();
		try {
			List<News> news = managerDao.NewsLikeSelect(title);
			int totalRecord= news.size();
	        String temp = req.getParameter("pageNum") ;
	        int pageNum;
	        if(temp == null){
	        	pageNum = 1;
	        }else{
	        	pageNum = Integer.parseInt(temp);
	        }

			int pageSize = 3;
			PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
			int startIndex = pb.getStartIndex();
			
			List<News> CurPage = new ArrayList<>();
			for(int i = startIndex;i<(startIndex + pageSize);i++){
				if(i<news.size())
				{			CurPage.add(news.get(i));}
			}
			
			pb.setList(CurPage);
			req.setAttribute("pageBean", pb);
			req.setAttribute("title", title);
			req.getRequestDispatcher("/NewsSearch.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}



