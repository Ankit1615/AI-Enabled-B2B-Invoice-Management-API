package com.higradius;
import java.sql.*;
import java.util.*;
public class Jdbcpractice1 {

	public static void main(String args[]) throws Exception {
		
		//Registering the Driver
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		//Getting the connection
		String mysqlUrl = "jdbc:mysql://localhost/dev_central";
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "rE8cvy)y+a");

		//Creating a Statement object
		Statement stmt = con.createStatement();

		//Retrieving the data
		ResultSet rs = stmt.executeQuery("select * from jdbc_table");

		//Creating an ArrayList object
		ArrayList<InfinitywarPojo> studList = new ArrayList<>();

		//Adding the Records of the table to the Array List
		while(rs.next()) {
		InfinitywarPojo studObj= new InfinitywarPojo();
		studObj.setFirst_name(rs.getString("first_name"));
		studObj.setLast_name(rs.getString("last_name"));
		studObj.setSerial(rs.getInt("serial_"));
		studObj.setAlias(rs.getString("Alias"));
		studObj.setQuote(rs.getString("Quote_"));
		studList.add(studObj);
		}
		
        //Menu driven Program
        Scanner sc=new Scanner(System.in);
        int exit=1;
        while(exit==1) {
        System.out.print("Menu:-\n1.Display all Data\n2.Display Alias ,Quote data using Serial\nEnter choice:");
        int choice=sc.nextInt();
        int count=0;
        switch(choice) {
        case 1:
        	for (InfinitywarPojo obj : studList) {
        		System.out.print("First Name: "+obj.getFirst_name()+", ");
        		System.out.print("Last_Name: "+obj.getLast_name()+", ");
        		System.out.print("Serial: "+obj.getSerial()+", ");
        		System.out.print("Alias: "+obj.getAlias()+", ");
        		System.out.print("Quote: "+obj.getQuote()+", ");
        		System.out.println();
        		}
        	break;
        case 2:
        	System.out.println("Enter Serial to view Alias and Quote:");
        	int serial=sc.nextInt();
        	for (InfinitywarPojo obj : studList) {
        		if(serial==obj.getSerial()) {
        			count=1;
        			System.out.print("Alias: "+obj.getAlias()+", ");
        			System.out.print("Quote: "+obj.getQuote()+", ");
        			break;
        		}
        		}
        	if(count==0) {
        		System.out.println("Invalid Serial");
        	}
        	
        	break;
        default:
        	System.out.println("Invalid Choice");
        	break;
        }
        System.out.println("\nAre you sure,You Want to Exit?");
        System.out.print("1.No,Repeat Once\n2.Yes\nEnter choice:");
        exit=sc.nextInt();
        }
        System.out.println(".....Exit Successfully!.....");
		}
		}