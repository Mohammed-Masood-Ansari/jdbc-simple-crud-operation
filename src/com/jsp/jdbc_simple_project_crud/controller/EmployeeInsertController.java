package com.jsp.jdbc_simple_project_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsertController {

	static Connection connection;
	
	public static void main(String[] args) {
		
		
		
		try {
			//step-1 load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create the connection
			String url = "jdbc:mysql://localhost:3306/jdbc-njjm8";
			String username = "root";
			String password = "root";
			
			connection=DriverManager.getConnection(url, username, password);
			
			String insertStudentQuery="insert into student values(125,'sahil',2345678)";
			
			//step-3 Create the statement
			Statement statement=connection.createStatement();
			
			//step-4 execute Query
			statement.execute(insertStudentQuery);
			
			System.out.println("Data...stored....");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//step-5 close the connetcion
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
