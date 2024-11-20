package com.sg.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	private static Connection con;
	
	public static Connection connect()
	{
		try {
			 String url = "jdbc:mysql://localhost:3306/foodappdb";
			 String name = "root";
			 String pass = "root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,name,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
