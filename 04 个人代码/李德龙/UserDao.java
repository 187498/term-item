package com.scu03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.scu03.bean.Transfer;
import com.scu03.bean.User;
import com.scu03.util.DBManager;

public class UserDao {
	
	
	public User getByAccount(String account)throws SQLException{
		String sql = "select * from user where user_account=?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, account);
//		pstm.executeQuery();
		ResultSet rs = pstm.executeQuery();
		User user = new User();
		if(rs.next()){
		String u_account = rs.getString(1);
		
		user.setUser_account(u_account);
		DBManager.close(con);
		return user;
	}else{
		DBManager.close(con);
		return null;//如果查询没有记录，则返回空
	}
	}
	//转账操作
	//需提供转出用户账号和转入用户账号和转账金额
	//首先判断转出用户余额是否充足，充足返回1并执行取款操作，余额不足返回0终止操作
	public static int userTransfer(String from,String to,double amount) throws SQLException{
		Connection con = DBManager.getConnection();
		String sql = "select * from `user` where user_account=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, from);
		ResultSet rs = pstm.executeQuery();
		double remain = 0;
		while(rs.next()){
		remain = rs.getDouble(4);
		}
		if(remain>=amount){
			//执行扣款操作
			sql = "update `user` set user_fund = user_fund - ? where user_account= ?";
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1, amount);
			pstm.setString(2, from);
			pstm.executeUpdate();
			
			//执行加钱操作
	        sql = "update `user` set user_fund = user_fund + ? where user_account= ?";
	        pstm = con.prepareStatement(sql);
	        pstm.setDouble(1, amount);
			pstm.setString(2, to);
			pstm.executeUpdate();
			
			//将交易记录写入记录册
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   		
			Date dateTime = new Date(System.currentTimeMillis());
			sql = "insert into `transfer` values(?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, from);
			pstm.setString(2, to);
			pstm.setDouble(3, amount);
			pstm.setDate(4, dateTime);
			pstm.executeUpdate();
			DBManager.close(con);
			return 1;
			}
			else{
				DBManager.close(con);
				return 0;
			}
		}
		
		//修改密码操作
		public static void modifyPassword(String account,String newpassword) throws SQLException{
			Connection con = DBManager.getConnection();
			String sql = "update `user` set user_password=? where user_account=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, newpassword);
			pstm.setString(2, account);
			pstm.executeUpdate();
			DBManager.close(con);
		}
		//修改各种个人信息
		//修改姓名
		public static void modifyName(String account,String newname) throws SQLException{
			Connection con = DBManager.getConnection();
			String sql = "update `user_info` set user_name=? where user_id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, newname);
			pstm.setString(2, account);
			pstm.executeUpdate();
			DBManager.close(con);
		}
		
		//修改地址
			public static void modifyAddr(String account,String newaddr) throws SQLException{
				Connection con = DBManager.getConnection();
				String sql = "update `user_info` set user_addr=? where user_id=?";
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, newaddr);
				pstm.setString(2, account);
				pstm.executeUpdate();
				DBManager.close(con);
			}
			
			//修改电话
			public static void modifyPhone(String account,String newphone) throws SQLException{
				Connection con = DBManager.getConnection();
				String sql = "update `user_info` set user_phone=? where user_id=?";
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, newphone);
				pstm.setString(2, account);
				pstm.executeUpdate();
				DBManager.close(con);
			}
			
			//修改邮箱
					public static void modifyEmail(String account,String newemail) throws SQLException{
						Connection con = DBManager.getConnection();
						String sql = "update `user_info` set user_email=? where user_id=?";
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setString(1, newemail);
						pstm.setString(2, account);
						pstm.executeUpdate();
						DBManager.close(con);
					}
					
					
					//用户存款操作
					//需提供用户账号和存款金额
					public static void userEeposit(String user_account,double amount) throws SQLException{
						String sql = "update `user` set user_fund = user_fund + ? where user_account= ?";
						Connection con = DBManager.getConnection();
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setDouble(1, amount);
						pstm.setString(2, user_account);
						pstm.executeUpdate();
						
						
						//将存款记录写入交易记录
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   		
						Date dateTime = new Date(System.currentTimeMillis());
				        sql = "insert into `record` values(?,?,?)";
				        pstm = con.prepareStatement(sql);
				        pstm.setDate(1, dateTime);
				        pstm.setDouble(2, amount);
				        pstm.setString(3, user_account);
				        pstm.executeUpdate();
				        
						DBManager.close(con);
					}
					
					//用户取款操作
					//需提供用户账号和取款金额
					//首先判断用户余额是否充足，充足返回1并执行取款操作，余额不足返回0终止操作
					@SuppressWarnings("deprecation")
					public static int userWithdrawal(String user_account,double amount) throws SQLException, ParseException{
						//判断余额是否充足
						Connection con = DBManager.getConnection();
						String sql = "select * from `user` where user_account=?";
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setString(1, user_account);
						ResultSet rs = pstm.executeQuery();
						double remain = 0;
						while(rs.next()){
							remain = rs.getDouble(4);
						}
						if(remain>=amount){
							//执行取款操作
							sql = "update `user` set user_fund = user_fund - ? where user_account= ?";
							pstm = con.prepareStatement(sql);
							pstm.setDouble(1, amount);
							pstm.setString(2, user_account);
							pstm.executeUpdate();
							
							//将取款记录写入交易记录
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   		
							Date dateTime = new Date(System.currentTimeMillis());
					        sql = "insert into `record` values(?,?,?)";
					        pstm = con.prepareStatement(sql);
					        pstm.setDate(1, dateTime);
					        pstm.setDouble(2, amount);
					        pstm.setString(3, user_account);
					        pstm.executeUpdate();
					        DBManager.close(con);
					        return 1;
						}
						else{
							DBManager.close(con);
							return 0;
						}
						
				        
						
					}
					
	/**
	 * 根据user和password查询记录，返回单个user
	 */
					public User getUserByAccountAndPassword(String user_account,String user_password) throws SQLException{
						String sql = "select * from user  natural join user_info where user_account = ? and user_password = ?";
						Connection con = DBManager.getConnection();
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setString(1, user_account);
						pstm.setString(2, user_password);
						ResultSet rs = pstm.executeQuery();
						if(rs.next()){//因为最多只有一条记录
							String u_account = rs.getString(3);
							String u_id = rs.getString(1);
							String u_password = rs.getString(4);
							double u_fund = rs.getDouble(5);
							String u_name = rs.getString(2);
							int u_state = rs.getInt(6);
							String u_addr = rs.getString(7);
							String u_phone = rs.getString(8);
							String u_email = rs.getString(9);
							String u_gender = rs.getString(10);
							Date u_birth = rs.getDate(11);
							User u = new User();
							u.setUser_account(u_account);
							u.setPassword(u_password);
							u.setUser_fund(u_fund);
							u.setUser_id(u_id);
							u.setUser_state(u_state);
							u.setUser_name(u_name);
							u.setUser_addr(u_addr);
							u.setUser_phone(u_phone);
							u.setUser_email(u_email);
							u.setUser_birth(u_birth);
							u.setUser_gender(u_gender);
							DBManager.close(con);
							return u;
						}else{
							DBManager.close(con);
							return null;//如果查询没有记录，则返回空
						}
					}
	
	
	/**
	 * 添加一个user记录
	 * @param user
	 * @throws SQLException 
	 */
	public void saveUser(User user) throws SQLException{
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
		while(rs.next()){//每一条记录封装到一个student对象中
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
			
			
			users.add(u);//每循环一次，向集合中添加一个Student对象
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
	public static void ChangeUserStateToOn(String user_account,String user_password) throws SQLException{
		String sql = "update user set user_state=1  where user_account = ? and user_password = ?";
		Connection con = DBManager.getConnection(); //获得连接
		PreparedStatement pstm = con.prepareStatement(sql); //预处理语句
		pstm.setString(1, user_account); //第一个问号赋值为account
		pstm.setString(2, user_password);//第二个问号赋值为password
		pstm.execute();//执行查询结果，返回结果集到rs中
		
		DBManager.close(con);//关闭连接		
	}
	/**
	 * 
	 * @param user_account
	 * @param user_password
	 * @throws SQLException
	 */
	public static void ChangeUserStateToOff(String user_account,String user_password) throws SQLException{
		String sql = "update user set user_state=0  where user_account = ? and user_password = ?";
		Connection con = DBManager.getConnection(); //获得连接
		PreparedStatement pstm = con.prepareStatement(sql); //预处理语句
		pstm.setString(1, user_account); //第一个问号赋值为account
		pstm.setString(2, user_password);//第二个问号赋值为password
		pstm.execute();//执行查询
		
		DBManager.close(con);//关闭连接
	}
	/**
	 * 根据标号和页大小获取用户信息
	 */
	public List<User> findAll(int startIndex, int pageSize)throws SQLException{
		String sql = "select * from User";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//要返回的list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//每一条记录封装到一个student对象中
			String u_account = rs.getString(1);
			String u_id = rs.getString(2);
			String u_password = rs.getString(3);
			float u_fund = rs.getFloat(4);
			String u_name = rs.getString(5);
			int u_state = rs.getInt(6);
			User u = new User();
			u.setUser_account(u_account);
			u.setPassword(u_password);
			u.setUser_fund(u_fund);
			u.setUser_id(u_id);
			u.setUser_state(u_state);
			u.setUser_name(u_name);
			users.add(u);//每循环一次，向集合中添加一个Student对象
		}
		DBManager.close(con);
		List<User> temp = new ArrayList<>();
		for(int i = startIndex;i<(startIndex + pageSize);i++){
			if(i<users.size())
			{			temp.add(users.get(i));}
		}
		return temp;
	}
	
	//根据账户查找交易记录
	public List<Transfer> getTransferByAccount(String account) throws SQLException{
		String sql = "select * from transfer where out_account=? OR in_account=?";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, account);
		pstm.setString(2, account);
		ResultSet rs = pstm.executeQuery();
		
		String sql2 = "select * from record where user_account=?";
		pstm = con.prepareStatement(sql2);
		pstm.setString(1, account);
		ResultSet rs2 = pstm.executeQuery();
		
		List<Transfer> temp = new ArrayList<>();
		while(rs.next()){
			String out_account = rs.getString(1);
			String in_account = rs.getString(2);
			float funds = rs.getFloat(3);
			Date date = rs.getDate(4);
			
			Transfer transfer = new Transfer();
			transfer.setOut_account(out_account);
			transfer.setIn_account(in_account);
			transfer.setFunds(funds);
			transfer.setDate(date);
			
			temp.add(transfer);
		}
		while(rs2.next()){
			String p_account = rs2.getString(3);
			float funds = rs2.getFloat(2);
			Date date = rs2.getDate(1);
			
			Transfer transfer = new Transfer();
			transfer.setIn_account(p_account);
			transfer.setOut_account(p_account);
			transfer.setFunds(funds);
			transfer.setDate(date);
			
			temp.add(transfer);
		}
		DBManager.close(con);
		return temp;
	}
	
	public static void main(String[] args) throws SQLException {
//		String account = "123";
//		String password = "567";
		UserDao userDao = new UserDao();
//		User user = userDao.getUserByAccountAndPassword(account, password);
//		if(user != null){
//			System.out.println("user.name = " + user.getUser_name());
//		}else{
//			System.out.println("查无此人");
//		}
//		UserDao userDao = new UserDao();
		List<Transfer> users = userDao.getTransferByAccount("123");
		for(Transfer s : users){
			System.out.println("s.name = " + s.getIn_account());
	}
//		userDao.modifyAddr("789789", "111");
//		userDao.modifyPhone("789789", "111");
	}
	

}
