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
import com.higradius.CorrespondencePojo;

@WebServlet("/correspondenceData")
public class CorrespondenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CorrespondenceServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8"); 
		ServletOutputStream out = response.getOutputStream();
		
		String invoice_no=request.getParameter("invoice_no");   
          
		List<CorrespondencePojo> list=ServletOperation.fetchingCorrespondenceData(invoice_no); 
		
        Gson gson = new GsonBuilder().create();
        JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
        String output = jarray.toString();
        out.print(output);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
