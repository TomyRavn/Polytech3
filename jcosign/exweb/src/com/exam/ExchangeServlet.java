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
			System.out.println(result + "��");
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.println("<!DOCTYPE html>                  ");
			out.println("<html>                           ");
			out.println("<head>                           ");
			out.println("<meta charset='UTF-8'>           ");
			out.println("<title>Insert title here</title> ");
			out.println("</head>                          ");
			out.println("<body>                           ");
			out.println(money + "�޷� " + result + "��<br />");
			
			out.println("���� �� �� " + (num*1238.19) + "��<br />");
			out.println("���� �� �� " + (num*1195.61) + "��<br />");
			out.println("�۱� �� �� " + (num*1228.80) + "��<br />");
			out.println("�۱� ���� �� " + (num*1205.00) + "��<br />");
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}
