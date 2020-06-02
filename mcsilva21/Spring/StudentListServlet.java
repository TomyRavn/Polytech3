package kr.ac.kopo.student;

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

@WebServlet("/student/list.do")
public class StudentListServlet extends HttpServlet{
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
	String user ="com";
	String password = "com01"; 
			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		resp.setContentType("text/html"); 	
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head> ");
		out.println("<meta charset='UTF-8'> ");
		out.println("<title>학생관리</title> ");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>학생목록</h1>");
		out.println("<a href='" + req.getContextPath() + "/studnet/addform.do'>학생추가</a></br>");
		
				
		{
			String sql = "SELECT stu_no,stu_name, stu_score FROM student";
					
		try(
				Connection conn = DriverManager.getConnection(url, user, password);				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			
			while (rs.next()) {
				
			String stuNO = rs.getString("stu_no"); 	
			String stuName = rs.getString("stu_name"); 		 
			int stuScore = rs.getInt("stu_score"); 	
			out.println("<a href='" + req.getContextPath() + "/student/editform.do?stuNO="+stuNO+"'>" + stuNO + "</a>"+":"+stuName+":"+stuScore);
			out.println("<a href='" + req.getContextPath() + "/student/del.do?stuNO="+stuNO+"'><button>삭제</button></a><br/>");				
		}			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}				
		out.println("</body>");
		out.println("</html>");				
	}
}
