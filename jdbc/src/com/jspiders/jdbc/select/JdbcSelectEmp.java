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

public class JdbcSelectEmp {
  private static String filepath ="D:\\Qsp course\\WEJA1_J2EE\\jdbc\\src\\resources\\db_info.properties";
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

	 //insert operation
	 query="insert into employee values('3', 'Mohan', 'Python Dev', '9745632100', 'mohan@gmail.com'),"
	 		+ "('6', 'Dipak', 'Testing', '8523697416', 'dipak@gmail.com'),"
	 		+ "('7', 'Vaibhav', 'Java Dev', '765489123', 'vaibhav@gmail.com')";
	 result=statement.executeUpdate(query);
	 System.out.println("query ok "+result+" row's affected");
	 query="select * from employee";
	resultSet=statement.executeQuery(query);
	 while (resultSet.next()) {
			System.out.println(resultSet.getString(1)+" || "
	 +resultSet.getString(2)+"  || "+resultSet.getString(3)+" || "
					+resultSet.getString(4)+" || "+resultSet.getString(5));
		}
	 
	 System.out.println();
	 //update operation
	 query="update employee set Department='developer' where Emp_no=2";
	 result=statement.executeUpdate(query);
	 query="update employee set Department='full-stack' where Emp_no=1";
	 if (result==1) {
		 result+=statement.executeUpdate(query);
	}
	 System.out.println("query ok "+result+" row's affected");
	 query="select * from employee";
	 resultSet=statement.executeQuery(query);
	 while (resultSet.next()) {
			System.out.println(resultSet.getString(1)+" || "
	 +resultSet.getString(2)+"  || "+resultSet.getString(3)+" || "
					+resultSet.getString(4)+" || "+resultSet.getString(5));
	 }
	 
	 System.out.println();
	 //DELET OPERATION
	 query="delete from employee where Emp_no=3";
	 result=statement.executeUpdate(query);
	 System.out.println("query ok "+result+" row's affected");
	 query="select * from employee";
	 resultSet=statement.executeQuery(query);
	 while (resultSet.next()) {
			System.out.println(resultSet.getString(1)+" || "
	 +resultSet.getString(2)+"  || "+resultSet.getString(3)+" || "
					+resultSet.getString(4)+" || "+resultSet.getString(5));
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
