package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
			
		if(connection!=null) {
			return connection;
		}else {
			
			try {	
				Class.forName("org.postgresql.Driver");	
			}catch(ClassNotFoundException e){
				e.printStackTrace();	
			}
			//jdbc:postgresql://<dbURL>:5432/<dbName>

			connection = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_UN"),System.getenv("DB_PWD"));
			
			return connection;
		}
		
		
		
	}
	
//	public static void main(String[] args) {
//		try {
//			getConnection();
//			System.out.println("Connection Successful!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
}
