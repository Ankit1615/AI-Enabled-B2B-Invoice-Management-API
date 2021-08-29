package com.higradius;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.higradius.ServletOperation;


@WebServlet("/deleteInvoicedata")
public class DeleteInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteInvoiceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        String doc_id=request.getParameter("doc_id");  
        Long id=Long.parseLong(doc_id);  
        ServletOperation.deleteInvoiceDetails(id);  
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
