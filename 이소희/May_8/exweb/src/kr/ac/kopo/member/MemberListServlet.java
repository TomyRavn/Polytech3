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

//1. 회원목록 화면에 '회원 추가'링크를 추가하고,
//링크를 클릭하면  http://localhost:8000/exweb/member/addform.do 로 이동

@WebServlet ("/member/list.do")
public class MemberListServlet extends HttpServlet {
	{
	//오라클 JDBC 드라이버 클래스를 메모리에 로드
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		
		resp.setContentType("text/html"); 	
		resp.setCharacterEncoding("UTF-8"); 
		PrintWriter out = resp.getWriter(); 
	
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>회원 관리</title>");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>회원 목록</h1>   ");
		out.println("<a href='" + req.getContextPath() + "/member/addform.do'>회원 추가</a><br / >");
		{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

		while (rs.next()) {
			String memId = rs.getString("mem_id");
			String mempass = rs.getString("mem_pass");
			String memName = rs.getString("mem_name");
			String mempoint = rs.getString("mem_point");
			
			
			out.println(memId + " : " + mempass + " : " + memName + " : " + mempoint);
			out.println("<a href='" + req.getContextPath() + "/member/del.do?memId=" + memId + "'><button> 삭제 </button></a><br / >");

		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}

}
