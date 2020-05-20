package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cal2.do")
public class CalcServlet2 extends HttpServlet{	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Cal2");
		req.setCharacterEncoding("UTF-8");
		

		String n1 = req.getParameter("x");
		String n2= req.getParameter("y");
		String op = req.getParameter("op");
		

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");			
		PrintWriter out = resp.getWriter(); 

		Double num1 = Double.parseDouble(n1);
		Double num2 = Double.parseDouble(n2);
		

		double result = 0;
		String opOut="";
		switch(op) {
		
		case "plu":
			result =num1+num2;
			opOut = "+";
			break;
			
		case "min":
			result =num1-num2;
			opOut = "-";
			break;
			
		case "mul":
			result =num1*num2;
			opOut = "*";
			break;
			
		case "div":
			result =num1/num2;
			opOut = "/";
			break;
			
		default: out.println("알수없는 연산자");
			return;
		}
		
		out.print(n1 + opOut + n2 + " = " + result);
	}




	
}


	

