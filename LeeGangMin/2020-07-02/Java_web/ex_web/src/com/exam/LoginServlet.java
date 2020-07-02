package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");	//보낼 때 파라미터 이름(string 변수 이름 아님)을 받는 것과 똑같이 맞춰야 함
		String pw = req.getParameter("pw");
		
		resp.setContentType("text/html");		//크롬이 정확하게 해석할 수 있도록 html임을 명시해주는 코드(생략가능?)
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();		//print 위한 메소드
												//Error 코드 404 - 주소에 맞는 서블릿을 못찾았다(경로 오류)
												//Error 코드 500 - 실행 중 에러 발생
		
		//HTML 파일 복사 붙여넣기
		out.println("<!DOCTYPE html>                  	  ");
		out.println("<html>                           	  ");
		out.println("<head>                           	  ");
		out.println("<meta charset='UTF-8'>           	  ");
		out.println("<title>Insert title here</title> 	  ");
		out.println("</head>                          	  ");
		out.println("<body>                           	  ");
		
		if(id.equals("a001")) {
			if(pw.equals("1234")) {
				out.println("<h1>로그인 성공</h1>		    		  ");
				}
			else {
				out.println("<h1>로그인 실패</h1>		    		  ");
				}
		} else {
			out.println("<h1>존재하지 않는 ID입니다</h1>			  ");
		}
		
		out.println("</body>                          	  ");
		out.println("</html>                          	  ");	//html 형식으로 보내야 크롬이 인식할 것임
		
	}
}