/*
 * 	This is Demo project for JDBC Hello World project. 
 * 	Below are the steps need to follow for each JDBC project:
 * 
 *  	STEP 1: Import the package							---> java.sql
 *  	STEP 2: Load and Register the Driver				---> com.mysql.jdbc.Driver
 *    	STEP 3: Connecting or establishing the connection	---> Connection
 *      STEP 4: Create the statement						---> 
 *      STEP 5: Execute the query							--->
 *      STEP 6: Process result or Receive the result based on above query	--->
 *      STEP 7: Close the connection 										--->
 */
package com.JDBC.Demo;

// STEP 1: Import the package
import java.sql.*;

public class JDBC_Demo{

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false";
		String userName = "root";
		String password = "2424";
		String queryWholeTable = "select * from student";
		String queryUserNameColumn = "select userName from student where userID = 1";
		String queryInsertSingleRecord = "insert into student values (4, 'Lay')";
		try {
			// STEP 2: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// STEP 3: Establish Connection
			Connection con = DriverManager.getConnection(url,userName, password);
			
			// STEP 4: Create the Statement (use any type of statement among Normal Statement, 
			//		   Prepared Statement or Callable Statement)
			Statement stmt = con.createStatement();
			
//			<-------------------- Block for to fetch single column from DB -------------------->
			// STEP 5.1: Execute query for single column
			ResultSet rs = stmt.executeQuery(queryUserNameColumn);
			// STEP 6.1: Store the Data (For Single column)
			// In the parameter, we can pass column name same as table column name or column number
			rs.next();
			String name = rs.getString("userName");
			// STEP 7.1: Process result or Receive the result based on above query (For Single column)
			System.out.println(name);
			
//			<-------------------- Block for to fetch whole table from DB -------------------->
			// STEP 5.2: Execute query for whole table
			ResultSet rs2 = stmt.executeQuery(queryWholeTable);
			// STEP 6.2: Store the Data (For Whole Table)
			System.out.println("ID : " + "UserName");
			while(rs2.next()) {
				// STEP 7.2: Process result or Receive the result based on above query (For Whole Table)
				System.out.println(rs2.getInt("userID") + " : " + rs2.getString("userName"));
			}
			
//			<-------------------- Block for to insert single record to DB -------------------->
			// STEP 5.3: Execute query for insert single record
			int count = stmt.executeUpdate(queryInsertSingleRecord);
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
