package kr.ac.kopo.student;

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

@WebServlet("/student/add.do") // 회원가입 화면을 불러옴 후 리스트를 출력해야함.

public class StudentAddServlet extends HttpServlet{			
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
		String stuNO = req.getParameter("stuNO"); //파라미터 요청값
		String stuName =req.getParameter("stuName");
		int stuScore = Integer.parseInt( req.getParameter("stuScore"));
	
		String sql = "INSERT INTO student (stu_no,stu_name, stu_score)" 
				+ "VALUES (?,?,?)";			
		try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {			
			pstmt.setString(1,stuNO); //파라미터값 받은걸로 채움
			pstmt.setString(2,stuName);		
			pstmt.setInt(3,stuScore);
			int num= pstmt.executeUpdate(); 
			System.out.println(num + "개의 레코드 추가"); 
								
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		

		resp.sendRedirect(req.getContextPath()+ "/student/list.do");
		
	}
}
	
	
	
	
	
	
	
	
	
	

