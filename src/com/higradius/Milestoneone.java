package com.higradius;

import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.io.IOException;
public class Milestoneone{
	
	//JDBC Driver and DB URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/h2h_internship";
	
	//SQLyog Database Credentials
	static final String USER = "root";
	static final String PASS = "rE8cvy)y+a";
	
	// Reading CSV
	private static ArrayList<Pojomilestone> milestoneList;
	public static ArrayList<Pojomilestone> readCsvfile(String filepath) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			milestoneList = new ArrayList<Pojomilestone>();
			String line = null;
			reader.readLine();   //skip first line 
			while((line = reader.readLine()) != null) {
				   String[] data = line.split(",");
				    
				   if(data.length > 0) {
					   Pojomilestone milobj = new Pojomilestone();
					   
					   milobj.setBusiness_code(data[0]);
					   milobj.setCust_number(data[1]);
					   milobj.setName_customer(data[2]);
					   milobj.setClear_date(data[3]);
					   milobj.setBusiness_year(data[4]);
					   milobj.setDoc_id(data[5]);
					   milobj.setPosting_date(data[6]);
					   milobj.setDocument_create_date(data[8]);
					   milobj.setDue_in_date(data[9]);
					   milobj.setInvoice_currency(data[10]);
					   milobj.setDocument_type(data[11]);
					   milobj.setPosting_id(data[12]);
					   milobj.setArea_business(data[13]);
					   milobj.setTotal_open_amount(data[14]);
					   milobj.setBaseline_create_date(data[15]);
					   milobj.setCust_payment_terms(data[16]);
					   milobj.setInvoice_id(data[17]);
					   milobj.setIsOpen(data[18]);
					   
					   milestoneList.add(milobj);
					   }
				   }
		
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return milestoneList;
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		int batchSize = 5000;
		String filepath = "C:/Users/KIIT/Desktop/Highradius/1806262.csv";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Open a connection
		    System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected database successfully...");
			
			conn.setAutoCommit(false);
			
			// Execute Query
			System.out.println("Inserting records into the table...");
			String sql = "INSERT INTO invoice_details (business_code, cust_number, name_customer, clear_date, business_year, doc_id, posting_date, document_create_date, due_in_date, invoice_currency, document_type, posting_id, area_business, total_open_amount, baseline_create_date, cust_payment_terms, invoice_id, isOpen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			
			long startTime = System.currentTimeMillis();
			
			// Delete the previous values in tables to avoid any error
			String dsql = "DELETE FROM invoice_details";
			stmt = conn.createStatement();
			stmt.executeUpdate(dsql);
			
			int count = 0;
			
			ArrayList<Pojomilestone> pojoList = readCsvfile(filepath) ;
			
			for (Pojomilestone obj: pojoList) {
				String business_code = obj.getBusiness_code();
				String cust_number = obj.getCust_number();
				String name_customer = obj.getName_customer();
				java.sql.Timestamp clear_date = obj.getClear_date();
				Short business_year = obj.getBusiness_year();
				Long doc_id = obj.getDoc_id();
				java.sql.Date posting_date = obj.getPosting_date();
				java.sql.Date document_create_date = obj.getDocument_create_date();
				java.sql.Date due_in_date = obj.getDue_in_date();
				String invoice_currency = obj.getInvoice_currency();
				String document_type = obj.getDocument_type();
				Short posting_id = obj.getPosting_id(); 
				String area_business = obj.getArea_business();
				Double total_open_amount = obj.getTotal_open_amount();
				java.sql.Date baseline_create_date = obj.getBaseline_create_date();
				String cust_payment_terms = obj.getCust_payment_terms();
				Long invoice_id = obj.getInvoice_id();
				Short isOpen = obj.getIsOpen();
				
				pstmt.setString(1, business_code);
				pstmt.setString(2, cust_number);
				pstmt.setString(3, name_customer);
				pstmt.setTimestamp(4, clear_date);
				pstmt.setShort(5, business_year);
				pstmt.setLong(6, doc_id);
				pstmt.setDate(7, posting_date);
				pstmt.setDate(8, document_create_date);
				pstmt.setDate(9, due_in_date);
				pstmt.setString(10, invoice_currency);
				pstmt.setString(11, document_type);
				pstmt.setShort(12, posting_id);
				pstmt.setString(13, area_business);
				pstmt.setDouble(14, total_open_amount);
				pstmt.setDate(15, baseline_create_date);
				pstmt.setString(16, cust_payment_terms);
				if (invoice_id == null) {
					pstmt.setLong(17, doc_id);
				}
				else {
					pstmt.setLong(17, invoice_id);
				}
				pstmt.setShort(18, isOpen);
				
				pstmt.addBatch();
				count ++;
				if (count%batchSize == 0) {
					pstmt.executeBatch();
				}
			}
			pstmt.executeBatch();
			conn.commit();
			long endTime = System.currentTimeMillis();
			long timediff = (endTime - startTime);
			System.out.println(count+" Records affected");
			System.out.println("Total time taken : "+timediff+" milliseconds");
			pstmt.close();
			conn.close();
		}
		catch (SQLException sqe) {
			sqe.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (pstmt!=null)
					pstmt.close();
			}
			catch(SQLException sqe1) {
				sqe1.printStackTrace();
			}
			try{
				if (conn!=null)
					conn.close();
			}
			catch (SQLException sqe2) {
				sqe2.printStackTrace();
			}
			}
		System.out.println("Successfully Execution Completed!");
	}
}
