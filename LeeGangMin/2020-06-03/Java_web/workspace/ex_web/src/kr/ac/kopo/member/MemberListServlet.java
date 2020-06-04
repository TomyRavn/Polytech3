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

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet{
	
	/*메소드 밖에 변수선언은 가능하지만, 기능들은 메소드나 생성자, 초기화 블록 등에 넣어야함*/
	//초기화 블록
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
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>회원관리</title> ");
		out.println("<style>");
		out.println("a, a:visited{");
		out.println("text-decoration: none;");
		out.println("color:black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>회원목록</h1>     ");
		
		out.println("<a href=\"" + req.getContextPath() + "/member/addform.do\"><button>회원가입</button></a></br></br>");
		
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				int memPoint = rs.getInt("mem_point");
				
				out.println("<a href=\"" + req.getContextPath() + "/member/editform.do?memId=" + memId + "\"><b>" + memId + "</b></a>" + " : " + memPass + " : " + memName  + " : " + memPoint + "</br>");
				
//				out.println("<table>");
//				out.println("<tr>");
//				out.println("<td>");
//				out.println(memId);
//				out.println("</td>");
//				out.println("<td>");
//				out.println(memPass);
//				out.println("</td>");
//				out.println("<td>");
//				out.println(memName);
//				out.println("</td>");
//				out.println("<td>");
//				out.println(memPoint);
//				out.println("</td>");
//				out.println("</tr>");
//				out.println("</table>");
			}
			out.println("===================================");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("</body>                          ");
		out.println("</html>                          ");
		
	}
	
}