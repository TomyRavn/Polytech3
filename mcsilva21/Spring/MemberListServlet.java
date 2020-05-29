package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1.
//회원목록 화면에 회원추가 링크를 추가
//링크를 클릭하면, //http://localhost:8000/exweb/member/addform.do로 이동

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet{
	{
	//초기화 블럭 - 한번만 실행하도됨.
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //web-inf/lib에 .jbdc를 추가해야함. 
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
	String user ="com";
	String password = "com01"; 
	
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //req:요청객체 resp:응답개체
	
				
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
		
		out.println("<h1>회원목록</h1>");
		out.println("<a href='" + req.getContextPath() + "/member/addform.do'>회원가입</a></br>");
		

				
		{
			String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
					
		try(
				Connection conn = DriverManager.getConnection(url, user, password);				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			
			while (rs.next()) {
				
			String memId = rs.getString("mem_id"); 	
			String memName = rs.getString("mem_name"); 		 
			String memPass = rs.getString("mem_pass"); 		
			int memPoint = rs.getInt("mem_point"); 	
			out.println("<a href='" + req.getContextPath() + "/member/editform.do?memId="+memId+"'>" + memId + "</a>"+":"+memPass+":"+memName+":"+memPoint);
				
//			out.println(memId+":"+memPass+":"+memName+":"+memPoint);
			//브라우저에 출력 x 콘솔창에출력 ->응답객체에서 받아 출력해야함.sysout 안됨.
			//a001 :1234 :고길동 :777 a002 :1234 :마이콜 :200 a004 :1203 :또오치 :1004 a010 :1234 :유노윤호 :1004 >>한줄로 출력됨
			//memId는 파라미터값!
			out.println("<a href='" + req.getContextPath() + "/member/del.do?memId="+memId+"'><button>삭제</button></a><br/>");
//			out.println("<a href='" + req.getContextPath() + "/member/editform.do?memId="+memId+"'><button>변경</button></a><br/>");접근방법
			
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
				
		out.println("</body>");
		out.println("</html>");
				
	}

}
