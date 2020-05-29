package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/add.do") // 회원가입 화면을 불러옴 후 리스트를 출력해야함.

public class MemberAddServlet extends HttpServlet{			
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="com";
		String password = "com01"; 
	
	@Override //서비스시작
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//한국어로 인코딩
		String memId = req.getParameter("memId"); //파라미터 요청값
		String memPass =req.getParameter("memPass");
		String memName =req.getParameter("memName");
		int memPoint = Integer.parseInt( req.getParameter("memPoint"));
	
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)" 
				+ "VALUES (?,?,?,?)";			
		try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {			
			pstmt.setString(1,memId); //파라미터값 받은걸로 채움
			pstmt.setString(2,memPass);
			pstmt.setString(3,memName);
			pstmt.setInt(4,memPoint);
			int num= pstmt.executeUpdate(); 
			System.out.println(num + "개의 레코드 추가"); 
								
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
//		resp.sendRedirect("url주소 또는 경로"): 지정된 주소 또는 경로로 이동하라는 명령을 담은 브라우저에게 전송
		resp.sendRedirect(req.getContextPath()+ "/member/list.do");
		
		//출력문이 없어서 아무것도 출력되지 않아서 out.println를 입력해줘야함.
		//회원목록 링크로 이동하는 html문 ↓
		
//		resp.setContentType("text/html"); 	//응답 내용이 text/html임을 브라우저에 알리도록 설정
//		resp.setCharacterEncoding("UTF-8"); //한글도 출력할 수 있도록 서버 설정
//		PrintWriter out = resp.getWriter(); // 응답객체에 출력할 수 있는 스트림(파이프 역할) 가져오기
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head> ");
//		out.println("<meta charset='UTF-8'> ");
//		out.println("<title>회원관리</title> ");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<a href='"+req.getContextPath()+"/member/list.do'>회원목록으로 이동</a>");
//		
//		out.println("</body>");
//		out.println("</html>");
//	
		
	}
}
	
	
	
	
	
	
	
	
	
	

