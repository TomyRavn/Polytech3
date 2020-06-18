package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/exchang.do")
public class ExchangeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String money = req.getParameter("dollar");
			double num = Double.parseDouble(money);
			double result = num*1216.90;
			System.out.println(result + "원");
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.println("<!DOCTYPE html>                  ");
			out.println("<html>                           ");
			out.println("<head>                           ");
			out.println("<meta charset='UTF-8'>           ");
			out.println("<title>Insert title here</title> ");
			out.println("</head>                          ");
			out.println("<body>                           ");
			out.println(money + "달러 " + result + "원<br />");
			
			out.println("현찰 살 때 " + (num*1238.19) + "원<br />");
			out.println("현찰 팔 때 " + (num*1195.61) + "원<br />");
			out.println("송금 할 때 " + (num*1228.80) + "원<br />");
			out.println("송금 받을 때 " + (num*1205.00) + "원<br />");
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}
