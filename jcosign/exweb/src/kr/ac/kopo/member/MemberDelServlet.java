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

//브라우저 주소창에
//http://localhost:8000/exweb/member/del.do?memId=a001
//을 입력하고 엔터키를 입력하면
//데이터베이스에서 아이디가 'a001'인 회원을 삭제하고,
//브라우저 화면에 회원목록이 출력되도록 구현
@WebServlet("/member/del.do")
public class MemberDelServlet extends HttpServlet{
	MemberDaoJdbc memberDao = new MemberDaoJdbc();
	
//	{
//		try {
//
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}	
//	}
//	String url = "jdbc:oracle:thin:@localhost:1521:xe"; 		
//	String user = "com";										
//	String password = = "com01";	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("삭제할 회원의 아이디를 입력하세요.\n");
		String delid = req.getParameter("memId");	
		
			int num = memberDao.deletMember(delid);
			System.out.println(num + "명예회원 삭제");
		resp.sendRedirect(req.getContextPath() + "/member/List.do");
	}
	}

//	public int deletMember(String memId) {
//		int num = 0;
//		String sql = "DELETE FROM member WHERE mem_id = ?";		
//		try(
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(sql);	
//				){
//			pstmt.setString(1, memId);
//			num = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}

