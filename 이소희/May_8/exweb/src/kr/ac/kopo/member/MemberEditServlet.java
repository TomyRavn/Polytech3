package kr.ac.kopo.member;

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

@WebServlet("/member/edit.do")
public class MemberEditServlet extends HttpServlet{
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
//		String memPw = req.getParameter("memPw");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		
		String sql = "UPDATE member SET mem_name = ?, mem_point=? WHERE mem_id = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
				) {		
		pstmt.setString(3, memId); 
//		pstmt.setString(2, memPw); 
		pstmt.setString(1, memName); 
		pstmt.setInt(2, memPoint); 
		int num = pstmt.executeUpdate();
		System.out.println(num + "개의 레코드 추가");
		
		} catch (SQLException e) {
				e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
	}
//회원 정보 클릭하면 화면 나오도록
}
