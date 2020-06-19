package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 애플리케이션 서버를 통해서 실행되는 클래스는 Servlet 규칙을 따라서 만들어야 함
//톰캣이 실행하는 주체이므로 Servlet 규칙을 따라야 톰캣이 알고 실행

//Servlet 규칙을 잘 모르는 경우
//일반적으로 HttpServlet 클래스를 상속하여 작성 -> 남이 만든 클래스를 가져와 그대로 쓰거나 기능을 추가하여 사용

//HelloServlet h = new HelloServlet();
//h.service();								=> 이전 2줄은 톰캣이 자동작성해 실행

@WebServlet("/hello.do") //웹 페이지에 연결 시키는 역할 (.class로 실행시키지 않기 때문) .. 해당 주소를 요청 받았을 때 실행
public class HelloServlet extends HttpServlet{	//이 때는 규칙만 지켰지 아무것도 하지 않음
	
	//따라서, 이 서블렛클래스를 실행시키는 요청이 올 때마다 한 번씩 실행되는 메소드는 다음과 같음(service 메소드 .. 메인 메소드처럼 여김)
	@Override
	protected void service(HttpServletRequest req/*요청 객체*/, HttpServletResponse resp/*응답 객체(보내줄 것들)*/) 
			throws ServletException, IOException {
				System.out.println("Hello Servlet"); //현재 컴퓨터(서버 컴퓨터)에 출력
		
				
		//POST 방식으로 전송 된 파라미터 값의 인코딩 설정(한글)
		req.setCharacterEncoding("UTF-8");
				
		//HTML에서 값 받기! "a'이라는 이름의 파라미터 값을 가져와서 변수 n에 저장
		String n = req.getParameter("a");
		String n2 = req.getParameter("b");
		//HTML에서는 주소 값 뒤에 ?a=sohee를 붙인다! ex) http://localhost:8000/exweb/hello.do?a=sohee
		//b 값을 더 받고 싶으면 & 입력 후 추가로 입력~ ex) ...?a=sohee&b=포로리
		
		resp.setContentType("text/html"); 	//응답 내용이 text/html임을 브라우저에 알리도록 설정
		resp.setCharacterEncoding("UTF-8"); //한글도 출력할 수 있도록 서버 설정
		
		//요청으로 보낸 웹브라우저에 출력하기 위해서는 인자로 받은 응답객체에 출력해야 함
		PrintWriter out = resp.getWriter(); // 응답객체에 출력할 수 있는 스트림(파이프 역할) 가져오기
		//out.println("Hello Servlet!!!");
		
//		resp.setContentType("text/html"); 	
//		resp.setCharacterEncoding("UTF-8");
//		PrintWriter out = resp.getWriter();
//		한글을 출력하기 위해서는 반드시 위의 세 코드를 작성해야 한다.
		
		
		//HTML 파일 복사 붙여넣기
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>Insert title here</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>Hello, " + n + "</h1>         "); //n 값을 문자열에서 빠져 나오게 하기 = n  드래그 후 ctrl+1
		out.println("	<h1>안녕, " + n2 + "</h1>         ");
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}