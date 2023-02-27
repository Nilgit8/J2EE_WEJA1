package com.jspiders.jdbc.select;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcDemo {
	private static Connection connection;
	private static FileReader fileReader;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static String filepath="E:\\WEJA1_J2EE\\jdbc\\src\\resources\\db_info.properties";
	private static Properties properties;
	private static int result;
public static void main(String[] args) {
	try {
		fileReader=new FileReader(filepath);
		properties=new Properties();
		properties.load(fileReader);
		
		Class.forName(properties.getProperty("driverpath"));
		connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
		
		query="update student Set email=? where id=?";
		preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setString(1, "nil@gmail.com");
		preparedStatement.setInt(2, 1);
		
		result=preparedStatement.executeUpdate();
		System.out.println("query ok "+result+" row(s) affected");
		
		
		
		} catch (IOException | ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
}
