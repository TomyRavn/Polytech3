package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 브라우저 주소창에
//http://localhost:8000/exweb/member/addform.do
//를 입력하고 엔터키를 입력하면,
//브라우저 화면에 회원 정보를 입력할 수 있는 입력 엘리먼트들이 출력되도록.
//폼에서 입력 받은 후 addservlet갑을 받아와야함

@WebServlet("/member/addform.do") //요청
public class MemberAddFormServlet extends HttpServlet { //실행 서비스메소드가 실행되어야 하니 오버라이드.
	
	@Override //서비스시작
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	resp.setContentType("text/html"); 	//응답 내용이 text/html임을 브라우저에 알리도록 설정
	resp.setCharacterEncoding("UTF-8"); //한글도 출력할 수 있도록 서버 설정
	PrintWriter out = resp.getWriter(); // 응답객체에 출력할 수 있는 스트림(파이프 역할) 가져오기
	
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head> ");
	out.println("<meta charset='UTF-8'> ");
	out.println("<title>회원관리</title> ");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>회원추가</h1>");
	
	//ContextPath: 현재 웹 애플리케이션(프로젝트)의 고유 경로
	out.println("<form action='" + req.getContextPath() + "/member/add.do' method='post'>"); 
	out.println("아아디:<input type='text'name='memId' /><br/> ")   ; 
	out.println("비밀번호:<input type='text' name='memPass'/><br/>") ;  
	out.println("이름:<input type='text' name='memName'/><br/>") ;  
	out.println("포인트:<input type='text' name='memPoint'/><br/>") ;  	
	out.println("<input type='submit' value='저장'/><br/>");
	out.println("<form/>");
	
	out.println("</body>");
	out.println("</html>");
	
	}

}
