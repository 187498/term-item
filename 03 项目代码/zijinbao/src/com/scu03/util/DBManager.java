package com.scu03.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static final String URL = "jdbc:mysql://localhost:3306/zijinbao?characterEncoding=UTF-8";
	//2.2用户名
	private static final String USER = "root";
	//2.3密码
	private static final String PASSWORD = "942562029";
	//静态代码块：加载驱动
	static{
		//1.加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获得连接的静态方法
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	/**
	 * 关闭连接的静态方法
	 * @throws SQLException 
	 */
	public static void close(Connection con) throws SQLException{
		if(con != null){
			con.close();
		}
	}
}

