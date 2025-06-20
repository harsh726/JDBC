package com.JDBC.Demo;

//STEP 1: Import the package
import java.sql.*;

public class InsertSingleRecord {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false";
		String userName = "root";
		String password = "2424";
		
		int userID = 6;
		String name = "Roshni";
		
		String querySimple = "insert into student values (5, 'Jinal')";
		String queryWithPassingValues = "insert into student values (" + userID + ", '" + name + "')";
		try {
			// STEP 2: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// STEP 3: Establish Connection
			Connection con = DriverManager.getConnection(url,userName, password);
			
			// STEP 4: Create the Statement (use any type of statement among Normal Statement, 
			//		   Prepared Statement or Callable Statement)
			Statement stmt = con.createStatement();
			
			// STEP 5.3: Execute query for insert single record
			int count = stmt.executeUpdate(queryWithPassingValues);
			
			// STEP 6.3 & 7.3: Display how many rows are affected
			System.out.println(count + " row/s are affected.");
			
			// STEP 8: Close the connection
			stmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
