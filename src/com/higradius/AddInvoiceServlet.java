package com.higradius;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.higradius.ServletOperation;
import com.higradius.ServletPojo;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/addInvoicedata")
public class AddInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddInvoiceServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
		String cust_number=request.getParameter("cust_number");  
        String name_customer=request.getParameter("name_customer");  
        Long doc_id=Long.parseLong(request.getParameter("doc_id"));
        String due_in_date=request.getParameter("due_in_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed1 =null;
        try {
        parsed1 = sdf.parse(due_in_date);
        }catch(ParseException pe){
	    	pe.printStackTrace();
	    }
        
        java.sql.Date sql_due_date = new java.sql.Date(parsed1.getTime());
        
        
        
        Double total_open_amount=Double.parseDouble(request.getParameter("total_open_amount"));  
        String notes=request.getParameter("notes"); 

        ServletPojo e=new ServletPojo();
        e.setCust_number(cust_number); 
        e.setName_customer(name_customer);
        e.setDoc_id(doc_id);  
        e.setDue_in_date(sql_due_date);  
        e.setTotal_open_amount(total_open_amount);
        e.setNotes(notes);
        
        int status=ServletOperation.addInvoiceDetails(e);
        if(status==0){  
        	out.println("Sorry! unable to save record");  
        }
          
        out.close();  
    } 
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
