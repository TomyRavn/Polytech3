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

//브라우저 주소창에
//http://localhost:800/exweb>>고유주소/member/del.do?/>>파라미터memId=a001//값을 꺼내와야함.
//http://localhost:800/exweb/member/del.do?memId='a001' << ''를 입력하면 삭제가 됨. 삭제하고자 할떄는 ''없앰.
//http://localhost:800/exweb/member/del.do?memId=a001
//를 입력하고 엔터키를 입력하면.
//데이터배이스에서 아이디 가 'a001'인 회원을 삭제하고,
//브라우저 화면에 회원목록이 출력되도록 구현

@WebServlet("/member/del.do") //요청
public class MemberDelServlet extends HttpServlet { //실행 서비스메소드가 주소롸 연결되야 함.
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
			


	String delId = req.getParameter("memId");
									
	{			
		String sql = "Delete from member where MEM_ID = ?";
	
try (
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
					
	) {
		pstmt.setString(1,delId); //?에 채워넣음
		int num= pstmt.executeUpdate();
		System.out.println("1명의 회원삭제");

	} catch (SQLException e) {
	e.printStackTrace();
	} 
	}
	
	resp.sendRedirect(req.getContextPath()+ "/member/list.do");
	
}

}	



	


