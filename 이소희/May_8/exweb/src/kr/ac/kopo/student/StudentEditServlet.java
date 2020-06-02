package kr.ac.kopo.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/edit.do")
public class StudentEditServlet extends HttpServlet{
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String stuNo = req.getParameter("stu_no");
		String stuName = req.getParameter("stu_name");
		int stuScore = Integer.parseInt(req.getParameter("stu_score"));
		
		
		String sql = "UPDATE student SET stu_name = ?, stu_score=? WHERE stu_no = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
				) {		
		pstmt.setString(1, stuName); 
		pstmt.setInt(2, stuScore); 
		pstmt.setString(3, stuNo); 

		int num = pstmt.executeUpdate();
		System.out.println(num + "개의 레코드 추가");
		
		} catch (SQLException e) {
				e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath() + "/student/list.do");
		
	}
}