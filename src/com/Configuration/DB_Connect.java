package com.Configuration;

import java.sql.*;

public class DB_Connect {
	public static final String driver = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnect() throws Exception {
		Connection con = null;
		Class.forName(driver);
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/resturant_system?allowPublicKeyRetrival=true?useSSL=false", "root",
				"@Redhat8910");
		return con;
	}

}
