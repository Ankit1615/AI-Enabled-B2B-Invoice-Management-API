package com.higradius;
import java.sql.*;
public class Jdbcpractice {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/dev_central";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "rE8cvy)y+a";
	public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try{
		
	//STEP 2: Register JDBC driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//STEP 3: Open a connection
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	//STEP 4: Execute a query
	stmt = conn.createStatement();
	String sql;
	sql = "SELECT first_name, last_name, serial_, Alias,Quote_ FROM jdbc_table";
	ResultSet rs = stmt.executeQuery(sql);
	
	//STEP 5: Extract data from result set
	while(rs.next()){
		
	//Retrieve by column name
	String first_name = rs.getString("first_name");
	String last_name = rs.getString("last_name");
	int serial=rs.getInt("serial_");
	String alias = rs.getString("Alias");
	String quote = rs.getString("Quote_");
	
	//Display values
	System.out.print("First Name: " + first_name);
	System.out.print(", Last Name: " + last_name);
	System.out.print(", Serial: " + serial);
	System.out.print(", Alias: " + alias);
	System.out.print(", Quote: " + quote);
	System.out.println();
	}
	
	//STEP 6: Clean-up environment
	rs.close();
	stmt.close();
	conn.close();
	}catch(SQLException se){
		
	//Handle errors for JDBC
	se.printStackTrace();
	}catch(Exception e){
		
	//Handle errors for Class.forName
	e.printStackTrace();
	}finally{
		
	//finally block used to close resources
	try{
	if(stmt!=null)
	stmt.close();
	}catch(SQLException se2){
	}// nothing we can do
	try{
	if(conn!=null)
	conn.close();
	}catch(SQLException se){
	se.printStackTrace();
	}
	}
	System.out.println("Goodbye!");
	}
	}