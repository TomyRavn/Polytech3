package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//브라우저 주소창에
//https://localhost:8000/exweb/member/addform.do
//을 입력하고 엔터키를 입력하면
//브라우저 화면에 회원 정보를 입력할 수 있는 입력 엘리먼트들이 출력되도록

@WebServlet("/member/addform.do")
public class MemberAddFormServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>회원관리</title> ");
		out.println("<style>");
		out.println(".accept{ float : right }");
		out.println("</style>");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>회원가입</h1>     ");

		//ContextPath : 현재 웹애플리케이션(프로젝트)의 고유 경로
		out.println("<form action=\"" + req.getContextPath() + "/member/add.do\" method=\"post\">");
		out.println("아이디를 입력하세요 : <input type=\"text\" name=\"memId\" />");
		out.println("</br>");
		out.println("</br>");
		out.println("비밀번호를 입력하세요 : <input type=\"text\" name=\"memPass\" />");
		out.println("</br>");
		out.println("</br>");
		out.println("이름을 입력하세요 : <input type=\"text\" name=\"memName\" />");
		out.println("</br>");
		out.println("</br>");
		out.println("포인트를 입력하세요 : <input type=\"text\" name=\"memPoint\" />");
		out.println("<input class=\"accept\" type=\"submit\" value=\"저장\" />");
		out.println("</form>");
		out.println("</br>");
		out.println("</br>");
		
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
	
}