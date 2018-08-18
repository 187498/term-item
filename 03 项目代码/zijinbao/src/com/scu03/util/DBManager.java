package com.scu03.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static final String URL = "jdbc:mysql://localhost:3306/zijinbao?characterEncoding=UTF-8";
	//2.2�û���
	private static final String USER = "root";
	//2.3����
	private static final String PASSWORD = "942562029";
	//��̬����飺��������
	static{
		//1.����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ������ӵľ�̬����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	/**
	 * �ر����ӵľ�̬����
	 * @throws SQLException 
	 */
	public static void close(Connection con) throws SQLException{
		if(con != null){
			con.close();
		}
	}
}

