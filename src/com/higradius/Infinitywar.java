package com.higradius;

import java.sql.*;
import java.util.*;

public class Infinitywar {
	public static void main(String args[]) throws Exception {

		// Registering the Driver
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		// Getting the connection
		String mysqlUrl = "jdbc:mysql://localhost/dev_central";
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "rE8cvy)y+a");

		// Creating a Statement object
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		int exit = 1;
		int choice;
		while (exit == 1) {
			System.out.println("Select an option:-\n1.Display all Data\n2.Display Alias,Quote column using Serial");
			System.out.println("3.Display Alias,Quote column using First Name\n4.Display Alias,Quote column using Last Name");
			System.out.print("Enter your option:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Retrieving the data
				ResultSet rs = stmt.executeQuery("select * from jdbc_table");
				// Creating an ArrayList object
				ArrayList<InfinitywarPojo> list = new ArrayList<>();
				// Adding the Records of the table to the Array List
				while (rs.next()) {
					InfinitywarPojo studObj = new InfinitywarPojo();
					studObj.setFirst_name(rs.getString("first_name"));
					studObj.setLast_name(rs.getString("last_name"));
					studObj.setSerial(rs.getInt("serial_"));
					studObj.setAlias(rs.getString("Alias"));
					studObj.setQuote(rs.getString("Quote_"));
					list.add(studObj);
				}
				System.out.println("\nResults:");
				for (InfinitywarPojo obj : list) {
					System.out.print("Serial: " + obj.getSerial() + "\n");
					System.out.print("  First Name: " + obj.getFirst_name() + "\n");
					System.out.print("  Last_Name: " + obj.getLast_name() + "\n");
					System.out.print("  Alias: " + obj.getAlias() + "\n");
					System.out.print("  Quote: " + obj.getQuote() + "\n");
					System.out.println();
				}
				break;
			case 2:
				System.out.println("Enter Serial to view Alias and Quote:");
				int serial = sc.nextInt();
				// Retrieving the data
				ResultSet rs1 = stmt.executeQuery("select Alias,Quote_ from jdbc_table where serial_=" + serial);
				// Creating an ArrayList object
				ArrayList<InfinitywarPojo> list1 = new ArrayList<>();
				// Adding the Records of the table to the Array List
				while (rs1.next()) {
					InfinitywarPojo studObj = new InfinitywarPojo();
					studObj.setAlias(rs1.getString("Alias"));
					studObj.setQuote(rs1.getString("Quote_"));
					list1.add(studObj);
				}
				System.out.println("\nResults:");
				for (InfinitywarPojo obj : list1) {
					System.out.print("  Alias: " + obj.getAlias() + "\n");
					System.out.print("  Quote: " + obj.getQuote() + "\n");
				}
				break;
			case 3:
				System.out.println("Enter First Name to view Alias and Quote:");
				String firstName = sc.next();
				// Retrieving the data
				ResultSet rs2 = stmt
						.executeQuery("select Alias,Quote_ from jdbc_table where first_name='" + firstName + "'");
				// Creating an ArrayList object
				ArrayList<InfinitywarPojo> list2 = new ArrayList<>();
				while (rs2.next()) {
					InfinitywarPojo studObj = new InfinitywarPojo();
					studObj.setAlias(rs2.getString("Alias"));
					studObj.setQuote(rs2.getString("Quote_"));
					list2.add(studObj);
				}
				System.out.println("\nResults:");
				for (InfinitywarPojo obj : list2) {
					System.out.print("  Alias: " + obj.getAlias() + "\n");
					System.out.print("  Quote: " + obj.getQuote() + "\n");
				}
				break;
			case 4:
				System.out.println("Enter Last Name to view Alias and Quote:");
				String lastName = sc.next();
				// Retrieving the data
				ResultSet rs3 = stmt
						.executeQuery("select Alias,Quote_ from jdbc_table where last_name='" + lastName + "'");
				// Creating an ArrayList object
				ArrayList<InfinitywarPojo> list3 = new ArrayList<>();
				while (rs3.next()) {
					InfinitywarPojo studObj = new InfinitywarPojo();
					studObj.setAlias(rs3.getString("Alias"));
					studObj.setQuote(rs3.getString("Quote_"));
					list3.add(studObj);
				}
				System.out.println("\nResults:");
				for (InfinitywarPojo obj : list3) {
					System.out.print("  Alias: " + obj.getAlias() + "\n");
					System.out.print("  Quote: " + obj.getQuote() + "\n");
				}
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("\nAre you sure,You Want to Exit?");
			System.out.print("1.No,Repeat Once\n2.Yes\nEnter choice:");
			exit = sc.nextInt();
		}
		System.out.println(".....Exit Successfully!.....");
	}
}