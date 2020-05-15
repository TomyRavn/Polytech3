package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cal.do")
public class CalcServlet extends HttpServlet{	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Cal");
		req.setCharacterEncoding("UTF-8");
		

		String X = req.getParameter("x");
		Double num = Double.parseDouble(X);
	
		String Y = req.getParameter("y");
		Double num1 = Double.parseDouble(Y);

		String OP = req.getParameter("op");
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
			
		PrintWriter out = resp.getWriter(); 


		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>Insert title here</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
	

		if (OP .equals("plu")) {
			out.println(num+num1);
		}
		else if (OP .equals("min")) {
			out.println(num-num1);
		}
		else if (OP.equals("mul")) {
			out.println(num*num1);
		}
		else if (OP.equals("div")) {
			out.println(num/num1);
		}

	

		out.println("</head>                          ");
		out.println("</body>                          ");
	}
}

	
	
	
