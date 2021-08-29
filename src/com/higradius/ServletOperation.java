package com.higradius;
import java.util.*;  
import java.sql.*;
import com.higradius.ServletPojo;
import com.higradius.CorrespondencePojo;

public class ServletOperation {
	
	// Establishing connection
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            String mysqlUrl = "jdbc:mysql://localhost/h2h_internship";
            con=DriverManager.getConnection(mysqlUrl,"root","rE8cvy)y+a");  
        }catch(Exception e){
        	System.out.println(e);
        	}  
        return con;  
    }  
	
	//Get All Invoice table Data Details
 
    	public static List<ServletPojo> getAllInvoiceDetails(){
    		 List<ServletPojo> list=new ArrayList<>();
    		 try {
    		 Connection con=ServletOperation.getConnection();
             PreparedStatement ps=con.prepareStatement("select * from invoice_details");  
             ResultSet rs=ps.executeQuery();  
               
            while(rs.next()){
                ServletPojo e=new ServletPojo();  
                e.setCust_number(rs.getString(2));  
                e.setName_customer(rs.getString(3));  
                e.setDoc_id(rs.getLong(6));   //taking doc_id data because doc_id and invoice_id is same and some invoice_id data is missing . 
                e.setDue_in_date(rs.getDate(9)); 
                e.setTotal_open_amount(rs.getDouble(14));
                e.setNotes(rs.getString(19));  
                list.add(e);  
            }  
            con.close();  
    		 }catch(Exception e){e.printStackTrace();}  
        return list;  
    }
    	
    	//Inserting data in the required columns
    	
    	public static int addInvoiceDetails(ServletPojo e){  
            int status=0;  
            try{  
            	Connection con=ServletOperation.getConnection();  
                PreparedStatement ps=con.prepareStatement("insert into invoice_details(cust_number,name_customer,doc_id,due_in_date,total_open_amount,invoice_id,notes) values (?,?,?,?,?,?,?)");  
                ps.setString(1,e.getCust_number());  
                ps.setString(2,e.getName_customer());  
                ps.setLong(3,e.getDoc_id());  //inserting data in both doc_id and invoice_id because both have same value in table
                ps.setDate(4,e.getDue_in_date());  
                ps.setDouble(5,e.getTotal_open_amount());
                ps.setLong(6,e.getDoc_id()); 
                ps.setString(7,e.getNotes());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){
            	ex.printStackTrace();
            	}  
              
            return status;  
        }  
    	
    	
    	//Updating data in the required columns
    	public static int updateInvoiceDetails(ServletPojo e){  
            int status=0;  
            try{  
            	Connection con=ServletOperation.getConnection();
                PreparedStatement ps=con.prepareStatement("update invoice_details set total_open_amount=?,notes=? where doc_id=?");  
                ps.setDouble(1,e.getTotal_open_amount());  
                ps.setString(2,e.getNotes());  
                ps.setLong(3,e.getDoc_id());
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        
    	//Deleting data from table using doc_id
        public static int deleteInvoiceDetails(Long doc_id){  
            int status=0;  
            try{  
            	Connection con=ServletOperation.getConnection();
                PreparedStatement ps=con.prepareStatement("delete from invoice_details where doc_id=?");  
                ps.setLong(1,doc_id);    
                status=ps.executeUpdate();  
                con.close();  
            }catch(Exception ex){
            	ex.printStackTrace();
            	}  
              
            return status;  
        }  
        
    	//getting data by searching 
        
        public static List<ServletPojo> getDataByInvoice(String invoice_number){  
        	List<ServletPojo> list=new ArrayList<>();  
              
            try{
            	Connection con=ServletOperation.getConnection(); 
                PreparedStatement ps=con.prepareStatement("select * from invoice_details where doc_id like ?");  
                ps.setString(1,'%'+invoice_number+'%'); 
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){
                    ServletPojo e=new ServletPojo();
                    e.setCust_number(rs.getString(2));  
                    e.setName_customer(rs.getString(3));  
                    e.setDoc_id(rs.getLong(6));  
                    e.setDue_in_date(rs.getDate(9)); 
                    e.setTotal_open_amount(rs.getDouble(14));
                    e.setNotes(rs.getString(19));  
                    list.add(e);  
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return list;  
        }  
        
        //Getting limited data 
        
        public static List<ServletPojo> getLimitData(Long start,Long limit){  
        	List<ServletPojo> list=new ArrayList<>();  
              
            try{
            	Connection con=ServletOperation.getConnection(); 
                PreparedStatement ps=con.prepareStatement("SELECT * FROM invoice_details LIMIT ?, ?");  
                ps.setLong(1,start);
                ps.setLong(2,limit);
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){
                    ServletPojo e=new ServletPojo();  
                    e.setCust_number(rs.getString(2));  
                    e.setName_customer(rs.getString(3));  
                    e.setDoc_id(rs.getLong(6));  
                    e.setDue_in_date(rs.getDate(9)); 
                    e.setTotal_open_amount(rs.getDouble(14));
                    e.setNotes(rs.getString(19));  
                    list.add(e);  
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return list;  
        }  
        
        
        public static List<CorrespondencePojo> fetchingCorrespondenceData(String invoice_number){  
        	List<CorrespondencePojo> list=new ArrayList<>();  
              
            try{
            	Connection con=ServletOperation.getConnection(); 
                PreparedStatement ps=con.prepareStatement("select * from invoice_details where doc_id=?");  
                ps.setString(1,invoice_number); 
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){
                	CorrespondencePojo e=new CorrespondencePojo();  
                    e.setInvoice_number(rs.getLong(6));  
                    e.setPo_number(rs.getLong(6)); 
                    e.setInvoice_date(rs.getDate(15)); 
                    e.setDue_date(rs.getDate(9));
                    e.setTotal_open_amount(rs.getDouble(14));
                    e.setCurrency(rs.getString(10));  
                    list.add(e);  
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return list;  
        }  
        
        
}  
