package com.JDBC.Demo;

//STEP 1: Import the package
import java.sql.*;

public class InsertRecordWithPreparedStatement {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false";
		String userName = "root";
		String password = "2424";
		
		int userID = 7;
		String name = "Rian";
		
		String queryWithPreparedStatement = "insert into student values (?, ?)";
		try {
			// STEP 2: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// STEP 3: Establish Connection
			Connection con = DriverManager.getConnection(url,userName, password);
			
			// STEP 4: Create the Statement (use any type of statement among Normal Statement, 
			//		   Prepared Statement or Callable Statement)
			// Here we used prepared statement that contains query with (?, ?) in the parameter
			PreparedStatement ps = con.prepareStatement(queryWithPreparedStatement);
			ps.setInt(1, userID);
			ps.setString(2, name);
			
			// STEP 5.3: Execute query for insert single record
			int count = ps.executeUpdate();
			
			// STEP 6.3 & 7.3: Display how many rows are affected
			System.out.println(count + " row/s are affected.");
			
			// STEP 8: Close the connection
			ps.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
