package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class loginDo extends HttpServlet{	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Login");
		req.setCharacterEncoding("UTF-8");
		
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
		
		if(id.equals("a001")) {
		if(pw.equals("1234")) {
		 	out.println("<h1>로그인이 성공 하였습니다.</h1>");
			}else{
			 out.println("<h1>로그인 실패.</h1>");}
			}else out.println("<h1>아이디를 확인해 주세요.</h1>");

		out.println("</head>                          ");
		out.println("</body>                           ");
	
	}
}
