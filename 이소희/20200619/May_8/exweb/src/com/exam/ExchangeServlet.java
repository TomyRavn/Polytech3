package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange.do")
public class ExchangeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {	
		
		
		
		String money = req.getParameter("dollar");
		double num = Double.parseDouble(money);
		double result = num * 1216.90;
		
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
		out.println(money + "달러 = " + result + "원<br/>");
		out.println("현찰 사실 때 : " + num * 1238.19 + "원<br/>");
		out.println("현찰 파실 때 : " + num * 1195.61 + "원<br/>");
		out.println("송금 보내실 때 : " + num * 1228.80 + "원<br/>");
		out.println("송금 받으실 때 : " + num * 1205.00 + "원");
		out.println("</body>                          ");
		out.println("</html>                          ");
		
}
}
