package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcSelectDemo {
public static void main(String[] args) {
	try {
		//1. load the driver class
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.open connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja1?user=root&password=root");
			
		//3.create statement
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from student");
			while(result.next()) {
				System.out.println(result.getInt(1)+" || "+ result.getString(2)+" || "+ result.getString(3));
			}
			connection.close();
			statement.close();
			result.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	
}
}
