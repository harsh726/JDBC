package com.JDBC.Demo;

//STEP 1: Import the package
import java.sql.*;

public class FetchSingleColumn {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false";
		String userName = "root";
		String password = "2424";
		String query = "select userName from student where userID = 1";
		try {
			// STEP 2: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// STEP 3: Establish Connection
			Connection con = DriverManager.getConnection(url,userName, password);
			
			// STEP 4: Create the Statement (use any type of statement among Normal Statement, 
			//		   Prepared Statement or Callable Statement)
			Statement stmt = con.createStatement();
			
			// STEP 5: Execute query for single column
			ResultSet rs = stmt.executeQuery(query);
			
			// STEP 6: Store the Data (For Single column)
			// In the parameter, we can pass column name same as table column name or column number
			rs.next();
			String name = rs.getString("userName");
			
			// STEP 7: Process result or Receive the result based on above query (For Single column)
			System.out.println(name);
			
			// STEP 8: Close the connection
			stmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
