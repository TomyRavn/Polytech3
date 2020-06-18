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
	//LoginServlet과 중복돼서 소문자로 바꿈.
	
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
				out.println("로그인 성공");
			} else {
				out.println("로그인 실패");
			}
		} else {
			out.println("존재하지 않는 ID입니다");
		}
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}