package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cal.do")
public class CalcServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String n1 = req.getParameter("x");
			String n2 = req.getParameter("y");
			String op = req.getParameter("op");
			
			double num1 = Double.parseDouble(n1);
			double num2 = Double.parseDouble(n2);
			double result = 0;
			String opOut ="";
					
			switch(op) {
			case "plu":
				opOut ="+";
				result = num1 + num2;
				break;
			case "min":
				opOut ="-";
				result = num1 - num2;
				break;
			case "mul":
				opOut ="*";
				result = num1 * num2;
				break;
			case "div":
				opOut ="/";
				result = num1 / num2;
				break;
			default:
				System.out.println("알 수 없는 연산자");
				return;												//이후 명령어는 실행할 필요 없도록 함
			}
			
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter out = resp.getWriter();
			out.println(n1+ opOut + n2 + "=" + result);
			
			
			out.println("<!DOCTYPE html>                  ");
			out.println("<html>                           ");
			out.println("<head>                           ");
			out.println("<meta charset='UTF-8'>           ");
			out.println("<title>Insert title here</title> ");
			out.println("</head>                          ");
			out.println("<body>                           ");

		out.println("</body>                          ");
		out.println("</html>                          ");

	}

}

