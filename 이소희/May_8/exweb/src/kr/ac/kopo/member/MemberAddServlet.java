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
		req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) " + "VALUES (?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);) {		
		pstmt.setString(1, memId); 
		pstmt.setString(2, memPw); 
		pstmt.setString(3, memName); 
		pstmt.setInt(4, memPoint); 
		int num = pstmt.executeUpdate();
		System.out.println(num + "개의 레코드 추가");
		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		//resp.sendRedirect("url주소 또는 경로") : 지정된 주소 또는 경로로 이동하라는 명령을 담은 응답을 브라우저에게 전송
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
		
		
//				resp.setContentType("text/html");
//				resp.setCharacterEncoding("UTF-8");
//				PrintWriter out = resp.getWriter();
//						
//				out.println("<!DOCTYPE html>                  ");
//				out.println("<html>                           ");
//				out.println("<head>                           ");
//				out.println("<meta charset='UTF-8'>           ");
//				out.println("<title>회원 관리</title>");
//				out.println("</head>                          ");
//				out.println("<body>                           ");
//				
//				//링크를 클릭하면 회원 리스트로 이동			
//				out.println("<a href='" + req.getContextPath() + "/member/list.do'>회원 목록으로 이동</a>");
//
//				out.println("</body>                          ");
//				out.println("</html>                          ");
			}
	}
	



	
