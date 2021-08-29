package com.higradius;

import java.io.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.ServletException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.higradius.ServletPojo;
import com.higradius.ServletOperation;

@WebServlet("/getAllInvoicedata")
public class GetAllInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllInvoiceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8"); 
		ServletOutputStream out = response.getOutputStream();
		
        List<ServletPojo> list=ServletOperation.getAllInvoiceDetails(); 
        
        Gson gson = new GsonBuilder().create();
        JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
        String output = jarray.toString();
        out.print(output);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
