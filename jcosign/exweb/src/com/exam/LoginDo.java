package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class LoginDo extends HttpServlet {
	//LoginServlet�� �ߺ��ż� �ҹ��ڷ� �ٲ�.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
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
		
		if(id.equals("a001")){
			if(pw.equals("1234")) {
				out.println("�α��� ����");
			} else {
				out.println("�α��� ����");
			}
		} else {
			out.println("�������� �ʴ� ID�Դϴ�");
		}
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}