package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seg")
public class ServletGet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String connectIP =(String)getServletContext().getAttribute("connectIP");
		String connectUser =(String)getServletContext().getAttribute("connectUser");
	
		
		PrintWriter out = response.getWriter();
		out.print("<p>connectIP:" + connectIP + "</p>");
		out.print("<p>connectUser:" + connectUser + "</p>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
