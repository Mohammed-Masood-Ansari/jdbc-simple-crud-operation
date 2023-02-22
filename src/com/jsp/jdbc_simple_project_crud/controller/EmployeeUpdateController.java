package com.jsp.jdbc_simple_project_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeUpdateController {

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
			
			String updateStudentQuery="update student set name='Raja' where id=124";
			
			//step-3 Create the statement
			Statement statement=connection.createStatement();
			
			//step-4 execute Query
			int id1=statement.executeUpdate(updateStudentQuery);
			
			if(id1!=0) {
				System.out.println("Data updated");
			}else {
			
				System.out.println("Given id is not found");
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
