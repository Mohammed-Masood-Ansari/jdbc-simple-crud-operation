package com.jsp.jdbc_simple_project_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDisplayController {

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
			
			String displayStudentQuery="SELECT * FROM student";
			
			//step-3 Create the statement
			Statement statement=connection.createStatement();
			
			//step-4 execute Query
			ResultSet resultSet=statement.executeQuery(displayStudentQuery);
			
			while(resultSet.next()) {
			
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				long phone = resultSet.getLong("phone");
				
				System.out.println("id = "+id);
				System.out.println("name = "+name);
				System.out.println("phone = "+phone);
				
			}
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
