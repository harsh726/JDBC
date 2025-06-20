package com.JDBC.Demo;

//STEP 1: Import the package
import java.sql.*;

public class FetchWholeTable {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false";
		String userName = "root";
		String password = "2424";
		String query = "select * from student";
		try {
			// STEP 2: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// STEP 3: Establish Connection
			Connection con = DriverManager.getConnection(url,userName, password);
			
			// STEP 4: Create the Statement (use any type of statement among Normal Statement, 
			//		   Prepared Statement or Callable Statement)
			Statement stmt = con.createStatement();
			
			// STEP 5: Execute query for whole table
			ResultSet rs2 = stmt.executeQuery(query);
			
			// STEP 6: Store the Data (For Whole Table)
			System.out.println("ID : " + "UserName");
			while(rs2.next()) {
				// STEP 7.2: Process result or Receive the result based on above query (For Whole Table)
				System.out.println(rs2.getInt("userID") + " : " + rs2.getString("userName"));
			}
			
			// STEP 8: Close the connection
			stmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
