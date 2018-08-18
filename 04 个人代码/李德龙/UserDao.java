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
		return null;//�����ѯû�м�¼���򷵻ؿ�
	}
	}
	//ת�˲���
	//���ṩת���û��˺ź�ת���û��˺ź�ת�˽��
	//�����ж�ת���û�����Ƿ���㣬���㷵��1��ִ��ȡ����������㷵��0��ֹ����
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
			//ִ�пۿ����
			sql = "update `user` set user_fund = user_fund - ? where user_account= ?";
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1, amount);
			pstm.setString(2, from);
			pstm.executeUpdate();
			
			//ִ�м�Ǯ����
	        sql = "update `user` set user_fund = user_fund + ? where user_account= ?";
	        pstm = con.prepareStatement(sql);
	        pstm.setDouble(1, amount);
			pstm.setString(2, to);
			pstm.executeUpdate();
			
			//�����׼�¼д���¼��
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
		
		//�޸��������
		public static void modifyPassword(String account,String newpassword) throws SQLException{
			Connection con = DBManager.getConnection();
			String sql = "update `user` set user_password=? where user_account=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, newpassword);
			pstm.setString(2, account);
			pstm.executeUpdate();
			DBManager.close(con);
		}
		//�޸ĸ��ָ�����Ϣ
		//�޸�����
		public static void modifyName(String account,String newname) throws SQLException{
			Connection con = DBManager.getConnection();
			String sql = "update `user_info` set user_name=? where user_id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, newname);
			pstm.setString(2, account);
			pstm.executeUpdate();
			DBManager.close(con);
		}
		
		//�޸ĵ�ַ
			public static void modifyAddr(String account,String newaddr) throws SQLException{
				Connection con = DBManager.getConnection();
				String sql = "update `user_info` set user_addr=? where user_id=?";
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, newaddr);
				pstm.setString(2, account);
				pstm.executeUpdate();
				DBManager.close(con);
			}
			
			//�޸ĵ绰
			public static void modifyPhone(String account,String newphone) throws SQLException{
				Connection con = DBManager.getConnection();
				String sql = "update `user_info` set user_phone=? where user_id=?";
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, newphone);
				pstm.setString(2, account);
				pstm.executeUpdate();
				DBManager.close(con);
			}
			
			//�޸�����
					public static void modifyEmail(String account,String newemail) throws SQLException{
						Connection con = DBManager.getConnection();
						String sql = "update `user_info` set user_email=? where user_id=?";
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setString(1, newemail);
						pstm.setString(2, account);
						pstm.executeUpdate();
						DBManager.close(con);
					}
					
					
					//�û�������
					//���ṩ�û��˺źʹ����
					public static void userEeposit(String user_account,double amount) throws SQLException{
						String sql = "update `user` set user_fund = user_fund + ? where user_account= ?";
						Connection con = DBManager.getConnection();
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setDouble(1, amount);
						pstm.setString(2, user_account);
						pstm.executeUpdate();
						
						
						//������¼д�뽻�׼�¼
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
					
					//�û�ȡ�����
					//���ṩ�û��˺ź�ȡ����
					//�����ж��û�����Ƿ���㣬���㷵��1��ִ��ȡ����������㷵��0��ֹ����
					@SuppressWarnings("deprecation")
					public static int userWithdrawal(String user_account,double amount) throws SQLException, ParseException{
						//�ж�����Ƿ����
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
							//ִ��ȡ�����
							sql = "update `user` set user_fund = user_fund - ? where user_account= ?";
							pstm = con.prepareStatement(sql);
							pstm.setDouble(1, amount);
							pstm.setString(2, user_account);
							pstm.executeUpdate();
							
							//��ȡ���¼д�뽻�׼�¼
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
	 * ����user��password��ѯ��¼�����ص���user
	 */
					public User getUserByAccountAndPassword(String user_account,String user_password) throws SQLException{
						String sql = "select * from user  natural join user_info where user_account = ? and user_password = ?";
						Connection con = DBManager.getConnection();
						PreparedStatement pstm = con.prepareStatement(sql);
						pstm.setString(1, user_account);
						pstm.setString(2, user_password);
						ResultSet rs = pstm.executeQuery();
						if(rs.next()){//��Ϊ���ֻ��һ����¼
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
							return null;//�����ѯû�м�¼���򷵻ؿ�
						}
					}
	
	
	/**
	 * ���һ��user��¼
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
	 * ��ѯ���е�user��¼����װ��һ�������У�����һ��user�Ľ����
	 * �ý�����������û���������Ϣ
	 * @return
	 * @throws SQLException 
	 */
	public static List<User> getAllUser() throws SQLException{
		String sql = "select * from user natural join user_info";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//Ҫ���ص�list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//ÿһ����¼��װ��һ��student������
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
			
			
			users.add(u);//ÿѭ��һ�Σ��򼯺������һ��Student����
		}
		DBManager.close(con);
		
		return users;
	}
	
	
	/**
	 * �鿴�����õ��˻������浽һ��������У�������������
	 * �ý�����������û���������Ϣ
	 * @param args
	 * @throws SQLException
	 */
	
	public static List<User> getAllUserStateIsOn() throws SQLException{
		String sql = "select * from user natural join user_info where user_state = 1";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//Ҫ���ص�list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//ÿһ����¼��װ��һ��student������
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
			
			
			
			users.add(u);//ÿѭ��һ�Σ��򼯺������һ��Student����
		}
		DBManager.close(con);
		return users;
	} 
	
	
	/**
	 * �鿴�Ѷ�����˻������浽һ��������У�������������
	 * �ý�����������û���������Ϣ
	 * @return
	 * @throws SQLException
	 */
	public static List<User> getAllUserStateIsOff() throws SQLException{
		String sql = "select * from user natural join user_info  where user_state = 0";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//Ҫ���ص�list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//ÿһ����¼��װ��һ��student������
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
			
			users.add(u);//ÿѭ��һ�Σ��򼯺������һ��Student����
		}
		DBManager.close(con);
		return users;
	}
	
	/**
	 * ���û��˻��Ŀ���
	 * @param user_account
	 * @param user_password
	 * @throws SQLException
	 */
	public static void ChangeUserStateToOn(String user_account,String user_password) throws SQLException{
		String sql = "update user set user_state=1  where user_account = ? and user_password = ?";
		Connection con = DBManager.getConnection(); //�������
		PreparedStatement pstm = con.prepareStatement(sql); //Ԥ�������
		pstm.setString(1, user_account); //��һ���ʺŸ�ֵΪaccount
		pstm.setString(2, user_password);//�ڶ����ʺŸ�ֵΪpassword
		pstm.execute();//ִ�в�ѯ��������ؽ������rs��
		
		DBManager.close(con);//�ر�����		
	}
	/**
	 * 
	 * @param user_account
	 * @param user_password
	 * @throws SQLException
	 */
	public static void ChangeUserStateToOff(String user_account,String user_password) throws SQLException{
		String sql = "update user set user_state=0  where user_account = ? and user_password = ?";
		Connection con = DBManager.getConnection(); //�������
		PreparedStatement pstm = con.prepareStatement(sql); //Ԥ�������
		pstm.setString(1, user_account); //��һ���ʺŸ�ֵΪaccount
		pstm.setString(2, user_password);//�ڶ����ʺŸ�ֵΪpassword
		pstm.execute();//ִ�в�ѯ
		
		DBManager.close(con);//�ر�����
	}
	/**
	 * ���ݱ�ź�ҳ��С��ȡ�û���Ϣ
	 */
	public List<User> findAll(int startIndex, int pageSize)throws SQLException{
		String sql = "select * from User";
		Connection con = DBManager.getConnection();
		PreparedStatement pstm = con.prepareStatement(sql);
		List<User> users = new ArrayList<>();//Ҫ���ص�list
		ResultSet rs = pstm.executeQuery();
		while(rs.next()){//ÿһ����¼��װ��һ��student������
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
			users.add(u);//ÿѭ��һ�Σ��򼯺������һ��Student����
		}
		DBManager.close(con);
		List<User> temp = new ArrayList<>();
		for(int i = startIndex;i<(startIndex + pageSize);i++){
			if(i<users.size())
			{			temp.add(users.get(i));}
		}
		return temp;
	}
	
	//�����˻����ҽ��׼�¼
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
//			System.out.println("���޴���");
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
