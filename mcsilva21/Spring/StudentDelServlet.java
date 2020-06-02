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

@WebServlet("/student/del.do") //요청
public class StudentDelServlet extends HttpServlet { //실행 서비스메소드가 주소롸 연결되야 함.
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
	
	@Override //서비스시작
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		req.setCharacterEncoding("UTF-8");
		
								
	{			
		String sql = "DELETE FROM student WHERE stu_no = ?";
		String stuNO = req.getParameter("stuNO");
	
try (
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
					
	) {
		pstmt.setString(1,stuNO); //?에 채워넣음
		int num= pstmt.executeUpdate();
		System.out.println("1명의 회원삭제");

	} catch (SQLException e) {
	e.printStackTrace();
	} 
	}
	
	resp.sendRedirect(req.getContextPath()+ "/student/list.do");
	
}

}	