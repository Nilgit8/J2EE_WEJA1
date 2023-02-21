package com.jspiders.jdbc.select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSelectDemo3 {
	
 private static String filepath="E:\\WEJA1_J2EE\\jdbc\\src\\resources\\db_info.properties";
 private static FileReader fileReader;
 private static Properties properties;
 private static Connection connection;
 private static Statement statement;
 private static int result;
 private static String query;
 private static ResultSet resultSet;
                             
public static void main(String[] args) {
	try {
		fileReader=new FileReader(filepath);
		properties=new Properties();
		properties.load(fileReader);
		
		Class.forName(properties.getProperty("driverpath"));
		 connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
		 
		 statement=connection.createStatement();
		 query="delete from student where id=4";
		 
		 result=statement.executeUpdate(query);
		 System.out.println("query ok "+result+" row's affected");
		 
		 query="select * from student";
		 resultSet=statement.executeQuery(query);
		 while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+" || "+resultSet.getString(2)+" || "+resultSet.getString(3)+" || "+resultSet.getString(4));
				
			}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
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
			if (fileReader != null) {
				fileReader.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
