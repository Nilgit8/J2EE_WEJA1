package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectDemo2 {        /// 2nd way of connection
	public static String driverpath="com.mysql.cj.jdbc.Driver";
	public static Connection connection;
	public static String dburl="jdbc:mysql://localhost:3306/weja1";
	public static String username="root";
	public static String password="root";
	public static Statement statement;
	public static String queryString;
	public static ResultSet resultSet;
	
public static void main(String[] args) {
	
	try {
		//load the driver class.
		Class.forName(driverpath);
		
		//open connection
		connection=DriverManager.getConnection(dburl,username,password);
		
		//create statement
		statement=connection.createStatement();
		queryString="select * from student";
	 resultSet=statement.executeQuery(queryString);
		
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1)+" || "+resultSet.getString(2)+" || "+resultSet.getString(3)+" || "+resultSet.getString(4));
			
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		try {
			if (connection != null) {
				connection.close();
				}
			
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
}
}
}
