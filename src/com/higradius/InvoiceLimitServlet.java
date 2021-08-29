package com.higradius;

import java.io.*;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.higradius.ServletOperation;
import com.higradius.ServletPojo;

@WebServlet("/get_limit_invoicedata")
public class InvoiceLimitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InvoiceLimitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/json;charset=UTF-8"); 
		ServletOutputStream out = response.getOutputStream();
		
		Long start=Long.parseLong(request.getParameter("start"));
		Long limit=Long.parseLong(request.getParameter("limit"));
          
		List<ServletPojo> list=ServletOperation.getLimitData(start,limit); 
		
        Gson gson = new GsonBuilder().create();
        JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
        String output = jarray.toString();
        out.print(output);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
