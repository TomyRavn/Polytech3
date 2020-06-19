package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 애플리케이션 서버를 통해 실행되는 클래스는 Servlet 규칙을 따라서 만들어야 함
//일반적으로 HttpServlet 클래스를 상속하여 작성

@WebServlet("/hello.do") //"/hello.do" 주소로 요청이 오면 이 서블릿을 실행
public class HelloServlet extends HttpServlet {
	
	//이 서블릿이 클래스를 실행시키는 요청이 올 때마다 한 번씩 실행되는 메서드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet");
		
		//POST방식으로 전송된 파라미터 값의 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		//"name"이라는 이름의 파라미터 값을 가져와서 변수 n에 저장
		String n = req.getParameter("a");
		String n2 = req.getParameter("b");
		
		//요청으로 보낸 웹 브라우저에게 출력하기 위해서는 인자로 받은 응답객체에 출력해야 함.
			//여기부터
		resp.setContentType("text/html");
		//응답 내용이 text/html임을 알리도록 설정
		resp.setCharacterEncoding("UTF-8");
		//응답 내용의 문자 인코딩 설정
		//utf-8로 통일한다.(한글 나올 수 있게.)
		PrintWriter out = resp.getWriter(); //응답객체에 출력할 수 있는 스트림 가져오기
			//여기까지는 고정.
		//out.println("Hello Servlet!!!               ");
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>Insert title here</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>Hello, " + n + "</h1>     ");
		out.println("	<h1>안녕, " + n2 + "</h1>        	  ");
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}
