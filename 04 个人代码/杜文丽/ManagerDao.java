package com.scu03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//

import java.sql.Date;
//
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import com.scu03.bean.Manager;
import com.scu03.bean.News;
import com.scu03.bean.User;
import com.scu03.util.DBManager;

public class ManagerDao {
	/**
	 * 修改密码
	 * @throws SQLException 
	 */
	public void UpdateManagePwd(String account,String oldPwd,String newPwd) throws SQLException{
		String sql = "update manager set manager_password=? where manager_account=? and manager_password=?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, newPwd);
		pstm.setString(2, account);
		pstm.setString(3, oldPwd);
		
		
		pstm.executeUpdate();
		DBManager.close(con);
	}
	
	
	/**
	 *增加用户信息(所有信息版本)
	 */
	public void insertUserInfo(User user)throws SQLException{
		String sql1 = "insert into user(user_account,user_id,user_password,user_fund,user_name,user_state) "
				+ "values(?,?,?,?,?,?)";
		
		String sql2 = "insert into user_Info(user_id,user_name,user_addr,user_phone,user_email,user_gender,user_birth) "
				+ "values(?,?,?,?,?,?,?)";		
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql2);
		
		pstm.setString(1, user.getUser_id());
		pstm.setString(2, user.getUser_name());
		pstm.setString(3, user.getUser_addr());
		pstm.setString(4, user.getUser_phone());
		pstm.setString(5, user.getUser_email());
		pstm.setString(6, user.getUser_gender());
		pstm.setDate(7, user.getUser_birth());
		pstm.executeUpdate();
		DBManager.close(con);
			
		con = DBManager.getConnection();
		pstm = con.prepareStatement(sql1);
		pstm.setString(1, user.getUser_account());
		pstm.setString(2, user.getUser_id());
		pstm.setString(3, user.getPassword());
		pstm.setDouble(4, user.getUser_fund());
		pstm.setString(5, user.getUser_name());
		pstm.setInt(6, user.getUser_state());
		pstm.executeUpdate();
		DBManager.close(con);

		
}

	
	public void updateUsers(User user)throws SQLException{
		String sql = "update user set user_name=?,user_state=? where user_account=?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		 pstm.setString(1, user.getUser_name());
		 pstm.setInt(2,user.getUser_state());
		 pstm.setString(3, user.getUser_account());
		 pstm.executeUpdate();
		 DBManager.close(con);
		 
		 String sql2 = "update user_info set user_name=?,user_addr=?,user_phone=?,user_email=? where user_id=?";
		 con = DBManager.getConnection();
		 pstm = con.prepareStatement(sql2);
		 pstm.setString(1, user.getUser_name());
		 pstm.setString(2,user.getUser_addr());
		 pstm.setString(3, user.getUser_phone());
		 pstm.setString(4,user.getUser_email());
		 pstm.setString(5, user.getUser_id());
		 pstm.executeUpdate();
		 DBManager.close(con);
		 
	}
	
	
	/**
	 * 增加用户
	 */
	public void insertUser(User user)throws SQLException{
			String sql = "insert into user(user_account,user_id,user_password,user_fund,user_name,user_state) "
					+ "values(?,?,?,?,?,?)";
			Connection con = DBManager.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getUser_account());
			pstm.setString(2, user.getUser_id());
			pstm.setString(3, user.getPassword());
			pstm.setDouble(4, user.getUser_fund());
			pstm.setString(5, user.getUser_name());
			pstm.setInt(6, user.getUser_state());
			
			pstm.executeUpdate();
			DBManager.close(con);
	}
	/**
	 * 
	 * 根据用户的账户号删除用户的账户
	 */
	public void deleteUserAccount(String user_account)throws SQLException{
		
		//删除此账户的交易记录
		String sql2 = "delete from record where user_account = ?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql2);
		
		pstm.setString(1, user_account);
		pstm.executeUpdate();
		DBManager.close(con);
		
		//如果此账户所有人名下无账户，则删除持有者的个人信息
		String sql3 = "select user_id from user where user_account = ?";
		con = DBManager.getConnection();
		pstm = con.prepareStatement(sql3);	
		pstm.setString(1, user_account);
		ResultSet rs = pstm.executeQuery();
		
		
		//删除用户的账户
		String sql = "delete from user where user_account = ?";
//		con = DBManager.getConnection();
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, user_account);
		pstm.executeUpdate();
		
		
		String sql4 = "select * from user where user_id = ?";
//		con = DBManager.getConnection();
		pstm = con.prepareStatement(sql4);	
		rs.next();
		pstm.setString(1, rs.getString(1));
		ResultSet rs2 = pstm.executeQuery();
		
		if(rs2.next()){
			
		}else{
			String sql5 = "delete from user_info where user_id = ?";
			con = DBManager.getConnection();
			pstm = con.prepareStatement(sql5);
			
			pstm.setString(1, rs.getString(1));
			pstm.executeUpdate();
			DBManager.close(con);
		}
		DBManager.close(con);
	}
	/**
	 * 
	 * 根据新闻的标题删除新闻
	 */
	public void deleteNews(String title)throws SQLException{
		String sql = "delete from news where news_title = ?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, title);
		pstm.executeUpdate();
		DBManager.close(con);
	}
	/**
	 * 修改新闻
	 */
	public void updateNews(News news)throws SQLException{
		String sql = "update news set news_title=?,news_time=?,news_message=? where news_id=?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, news.getNews_title());
		pstm.setDate(2, (Date)news.getDate());
		pstm.setString(3, news.getNews_content());
		pstm.setString(4, news.getNews_id());
		
		pstm.executeUpdate();
		DBManager.close(con);
		
	}
	/**
	 * 添加新闻
	 */
	public void addNews(News news)throws SQLException{
		String sql = "insert into news(news_id,news_title,news_time,news_message)"+"values(?,?,?,?)";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, news.getNews_id());
		pstm.setString(2, news.getNews_title());
		pstm.setDate(3, (Date)news.getDate());
		pstm.setString(4, news.getNews_content());
		
		pstm.executeUpdate();
		DBManager.close(con);
		
	}
	
	/**
	 * 获取新闻列表
	 * 
	 */
	public List<News> getAllNews() throws SQLException{
		String sql="select * from news";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<News> newss = new ArrayList<>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String news_id = rs.getString(1);
			String news_title = rs.getString(2);
			Timestamp news_time = rs.getTimestamp(3);
			String news_message = rs.getString(4);
			
			News n = new News();
			n.setNews_id(news_id);
			n.setNews_title(news_title);
			n.setNews_content(news_message);
			n.setDate(news_time);
			newss.add(n);
			
		}
		DBManager.close(con);
		return newss;
	}
	
	/**
	 * 根据manager和password查询记录，返回单个manager
	 * @param manager
	 * @param password
	 * @return 返回一条记录，封装在manager对象中
	 * @throws SQLException 
	 */
	public Manager getManagerByAccountAndPassword(String manager_account,String manager_password) throws SQLException{
		String sql = "select * from manager where manager_account = ? and manager_password = ?";
		Connection con = DBManager.getConnection(); //获得连接
		PreparedStatement pstm = con.prepareStatement(sql); //预处理语句
		pstm.setString(1, manager_account); //第一个问号赋值为account
		pstm.setString(2, manager_password);//第二个问号赋值为password
		ResultSet rs = pstm.executeQuery();//执行查询结果，返回结果集到rs中
		if(rs.next()){//因为最多只有一条记录
			//先将返回的属性都存在String变量中
			String m_account = rs.getString(1);
			
			String m_password = rs.getString(2);
			
			String m_name = rs.getString(3);
			
			//再创建一个user然后把信息全部录入manager中
			Manager m=new Manager();
			m.setManager_account(manager_account);
			m.setManager_password(manager_password);
			m.setManager_name(m_name);
			DBManager.close(con);//关闭连接
			
			return m;//返回存好的Manager
		}else{
			DBManager.close(con);
			return null;//如果查询没有记录，则返回空
		}
	}
	
	
	/**
	 * 查询所有的user记录，封装到一个集合中，返回一个user的结果集
	 * 该结果集保存了用户的所有信息
	 * @return
	 * @throws SQLException 
	 */
	public static List<User> getAllUser() throws SQLException{
		String sql = "select * from user natural join user_info";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//要返回的list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String u_id = rs.getString(1);
			String u_name = rs.getString(2);
			String u_account = rs.getString(3);
			String u_password = rs.getString(4);
			float u_fund = rs.getFloat(5);
			int u_state = rs.getInt(6);
			String user_addr=rs.getString(7);
			String user_phone=rs.getString(8);
			String user_email=rs.getString(9);
			
			User u = new User();
			u.setUser_account(u_account);
			u.setPassword(u_password);
			u.setUser_fund(u_fund);
			u.setUser_id(u_id);
			u.setUser_state(u_state);
			u.setUser_name(u_name);
			u.setUser_email(user_email);
			u.setUser_addr(user_addr);
			u.setUser_phone(user_phone);
			
			
			users.add(u);
		}
		DBManager.close(con);
		
		return users;
	}
	
	
	/**
	 * 查看已启用的账户，保存到一个结果集中，返回这个结果集
	 * 该结果集保存了用户的所有信息
	 * @param args
	 * @throws SQLException
	 */
	
	public static List<User> getAllUserStateIsOn() throws SQLException{
		String sql = "select * from user natural join user_info where user_state = 1";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//要返回的list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//每一条记录封装到一个student对象中
			String u_id = rs.getString(1);
			String u_name = rs.getString(2);
			String u_account = rs.getString(3);
			String u_password = rs.getString(4);
			double u_fund = rs.getDouble(5);
			int u_state = rs.getInt(6);
			String user_addr=rs.getString(7);
			String user_phone=rs.getString(8);
			String user_email=rs.getString(9);
			
			User u = new User();
			u.setUser_account(u_account);
			u.setPassword(u_password);
			u.setUser_fund(u_fund);
			u.setUser_id(u_id);
			u.setUser_state(u_state);
			u.setUser_name(u_name);
			u.setUser_email(user_email);
			u.setUser_addr(user_addr);
			u.setUser_phone(user_phone);
			
			
			
			users.add(u);//每循环一次，向集合中添加一个Student对象
		}
		DBManager.close(con);
		return users;
	} 
	
	
	/**
	 * 查看已冻结的账户，保存到一个结果集中，返回这个结果集
	 * 该结果集保存了用户的所有信息
	 * @return
	 * @throws SQLException
	 */
	public static List<User> getAllUserStateIsOff() throws SQLException{
		String sql = "select * from user natural join user_info  where user_state = 0";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//要返回的list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//每一条记录封装到一个student对象中
			String u_id = rs.getString(1);
			String u_name = rs.getString(2);
			String u_account = rs.getString(3);
			String u_password = rs.getString(4);
			double u_fund = rs.getDouble(5);
			int u_state = rs.getInt(6);
			String user_addr=rs.getString(7);
			String user_phone=rs.getString(8);
			String user_email=rs.getString(9);
			
			User u = new User();
			u.setUser_account(u_account);
			u.setPassword(u_password);
			u.setUser_fund(u_fund);
			u.setUser_id(u_id);
			u.setUser_state(u_state);
			u.setUser_name(u_name);
			u.setUser_email(user_email);
			u.setUser_addr(user_addr);
			u.setUser_phone(user_phone);
			
			users.add(u);//每循环一次，向集合中添加一个Student对象
		}
		DBManager.close(con);
		return users;
	}
	
	/**
	 * 对用户账户的开启
	 * @param user_account
	 * @param user_password
	 * @throws SQLException
	 */
	public static void ChangeUserStateToOn(String user_account) throws SQLException{
		String sql = "update user set user_state=1  where user_account = ?";
		Connection con = DBManager.getConnection(); //获得连接
		PreparedStatement pstm = con.prepareStatement(sql); //预处理语句
		pstm.setString(1, user_account); //第一个问号赋值为account
//		pstm.setString(2, user_password);//第二个问号赋值为password
		pstm.execute();//执行查询结果，返回结果集到rs中
		
		DBManager.close(con);//关闭连接		
	}
	/**
	 * 
	 * @param user_account
	 * @param user_password
	 * @throws SQLException
	 */
	public static void ChangeUserStateToOff(String user_account) throws SQLException{
		String sql = "update user set user_state=0  where user_account = ? ";
		Connection con = DBManager.getConnection(); //获得连接
		PreparedStatement pstm = con.prepareStatement(sql); //预处理语句
		pstm.setString(1, user_account); //第一个问号赋值为account
//		pstm.setString(2, user_password);//第二个问号赋值为password
		pstm.execute();//执行查询
		
		DBManager.close(con);//关闭连接
	}
	
	
	public List<News> findAllNews(int startIndex, int pageSize)throws SQLException{
		String sql="select * from news";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<News> newss = new ArrayList<>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){
			String news_id = rs.getString(1);
			String news_title = rs.getString(2);
			Timestamp news_time = rs.getTimestamp(3);
			String news_message = rs.getString(4);
			
			News n = new News();
			n.setNews_id(news_id);
			n.setNews_title(news_title);
			n.setNews_content(news_message);
			n.setDate(news_time);
			newss.add(n);
			
		}
		DBManager.close(con);
		List<News> temp = new ArrayList<>();
		for(int i = startIndex;i<(startIndex + pageSize);i++){
			if(i<newss.size())
			{			temp.add(newss.get(i));}
		}
		return temp;
	}
	
	/**
	 * 新闻的模糊查询
	 */
	public List<News> NewsLikeSelect(String title) throws SQLException{
		String sql ="select * from news where news_title like '%"+title+"%' ";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<News> temp = new ArrayList<>();
		while(rs.next()){
			String news_id = rs.getString(1);
			String news_title = rs.getString(2);
			Timestamp news_time = rs.getTimestamp(3);
			String news_message = rs.getString(4);
			
			News n = new News();
			n.setNews_id(news_id);
			n.setNews_title(news_title);
			n.setNews_content(news_message);
			n.setDate(news_time);
			temp.add(n);
			
		}
		DBManager.close(con);
		return temp;
		
	}
	/**
	 * 用户信息的模糊查询
	 */
	public List<User> UserLikeSelect(String user_name,String user_account,String user_id) throws SQLException{
		String sql = "select * from user natural join user_info where 1=1 ";
		if(user_name != ""){
		     sql+= "and user_name like '%"+user_name+"%' ";
		}
		else if(user_account != ""){
		   sql+= "and user_account like '%"+user_account+"%' ";
		}
		else if(user_id != ""){
		   sql+= "and user_id like '%"+user_id+"%' ";
		}
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<User> temp = new ArrayList<>();
		while(rs.next()){
			String u_id = rs.getString(1);
			String u_name = rs.getString(2);
			String u_account = rs.getString(3);
			String u_password = rs.getString(4);
			float u_fund = rs.getFloat(5);
			int u_state = rs.getInt(6);
			String user_addr=rs.getString(7);
			String user_phone=rs.getString(8);
			String user_email=rs.getString(9);
			
			User u = new User();
			u.setUser_account(u_account);
			u.setPassword(u_password);
			u.setUser_fund(u_fund);
			u.setUser_id(u_id);
			u.setUser_state(u_state);
			u.setUser_name(u_name);
			u.setUser_email(user_email);
			u.setUser_addr(user_addr);
			u.setUser_phone(user_phone);
			
			
			temp.add(u);
		}
		DBManager.close(con);
		return temp;
		
	}
	public static void main(String[] args) throws SQLException {
		
		//获取新闻
//		ManagerDao managerdao = new ManagerDao();
//		List<News> news = managerdao.getAllNews();
//		for(News n : news){
//			System.out.println("all: "+ n.getNews_id()+n.getNews_title() + n.getNews_content()+n.getDate());
//		}
		
		
//		List<Student> students = studentDao.getAllStudents();
//		for(Student s : students){
//			System.out.println("s.name = " + s.getName());
//		}
		
		//添加用户
//		User user = new User();
//		user.setUser_account("111");
//		 user.setUser_id("20180726");
//		 user.setPassword("111");
//		 user.setUser_fund(0);
//		 user.setUser_name("小红");
//		 user.setUser_state(1);
//		 user.setUser_addr("青羊区");
//		 user.setUser_phone("168000");
//		 user.setUser_email("123@qq.com");
//		 
//		 ManagerDao managerdao = new ManagerDao();
//		 managerdao.insertUserInfo(user);
	//删除用户	 
		
		
		//模糊查询
//		 ManagerDao managerdao = new ManagerDao();
//		 
//		List<User> temp = managerdao.UserLikeSelect("", "","89");
//		for(User n : temp){
//			System.out.println("all: "+ n.getUser_name());
//		}
		
		UserDao userDao = new UserDao();
		List<User> allUser = null;
			allUser = userDao.getAllUser();
			
			List<User> User = new ArrayList<>();
			for(int i=0;i<allUser.size();i++){
				if(allUser.get(i).getUser_state() == 0)
				{	User u = allUser.get(i);
					User.add(u);}
			}
			List<User> temp = User;
			for(User n : temp){
				System.out.println("all: "+ n.getUser_name());
			}
		
//		增加新闻+修改新闻
//		News news = new News();
//		news.setNews_id("2");
//		news.setNews_title("zaoshanghao");
//		Date date = new Date(System.currentTimeMillis());
//		Timestamp time = new Timestamp(System.currentTimeMillis());    

//		System.out.println(time);
//		news.setDate(date);
//		news.setNews_content("test");
//		managerdao.addNews(news);
		
		
//		ManagerDao managerdao = new ManagerDao();
//		List<News> temp = managerdao.NewsLikeSelect("震惊");
//		for(News n : temp){
//		System.out.println("all: "+ n.getNews_id()+n.getNews_title() + n.getNews_content()+n.getDate());
//	}
		
		
//		User user = new AllUser();
//		user.setUser_account("111");
//		 user.setUser_id("20180726");
//		 user.setPassword("111");
//		 user.setUser_fund(0);
//		 user.setUser_name("小白");
//		 user.setUser_state(0);
//		 user.setUser_addr("青羊区");
//		 user.setUser_phone("111111");
//		 user.setUser_email("123@qq.com");
//	
//			ManagerDao managerdao = new ManagerDao();
//			managerdao.updateUsers(user);

		
	}
}
