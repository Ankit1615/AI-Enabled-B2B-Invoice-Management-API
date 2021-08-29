package com.higradius;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.higradius.ServletOperation;
import com.higradius.ServletPojo;

@WebServlet("/updateInvoicedata")
public class UpdateInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateInvoiceServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        Long doc_id=Long.parseLong(request.getParameter("doc_id"));
        Double total_open_amount=Double.parseDouble(request.getParameter("total_open_amount"));  
        String notes=request.getParameter("notes");
          
        ServletPojo e=new ServletPojo();  
        e.setDoc_id(doc_id);   
        e.setTotal_open_amount(total_open_amount);
        e.setNotes(notes);  
          
        int status=ServletOperation.updateInvoiceDetails(e);  
        if(status==0){  
        	out.println("Sorry! unable to update record");   
        }
          
        out.close();  
    }  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
