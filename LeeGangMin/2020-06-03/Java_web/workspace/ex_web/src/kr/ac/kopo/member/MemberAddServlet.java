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


@WebServlet("/member/add.do")
public class MemberAddServlet extends HttpServlet{

	/*사용자가 어떤 주소를 먼저 입력할지 모르므로 일단은 서블렛마다 초기화*/
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//POST방식으로 전송된 파라미터 값의 인코딩 설정
		req.setCharacterEncoding("UTF-8");			//변수 저장 전에 위치
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
				+ "VALUES (?, ?, ?, ?)";
//		int num = 0;
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setInt(4, memPoint);
			
			pstmt.executeUpdate();
//			num = pstmt.executeUpdate(); 

			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//resp.sendRedirect("URL주소 또는 경로")
		//: 지정된 주소 또는 경로로 이동하라는 명령을 담은 응답을 브라우저에게 전송
		
		//1.list.do로 강제 이동시키는 명령어
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
		//2. INSERT 결과 출력
//		out.println("<!DOCTYPE html>                  ");
//		out.println("<html>                           ");
//		out.println("<head>                           ");
//		out.println("<meta charset='UTF-8'>           ");
//		out.println("<title>회원관리</title> ");
//		out.println("</head>                          ");
//		out.println("<body>                           ");
//		
//		out.println(num + "개의 레코드가 추가 되었습니다. </br></br>");
//		out.println("<a href=\"" + req.getContextPath() + "/member/list.do\"> 회원목록으로 이동 </a>");
//		out.println("</br>");
//		
//		out.println("</body>                          ");
//		out.println("</html>                          ");
		
	}
	
}