package com.cjg.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String url = "jdbc:microsoft:sqlserver://localhost:1433;databaseName=banksystem";

	public static Connection getDBC() throws SQLException, Exception {
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		// 用户名为sa，密码为空
		Connection conn = DriverManager.getConnection(url, "root", "root");
		return conn;
	}
}
