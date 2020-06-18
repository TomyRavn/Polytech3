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
	MemberDaoJdbc memberDao = new MemberDaoJdbc();
	
	//요청을 받으면, 요청 방식에 상관없이 실행되는 메서드: service()
	//특정 요청방식으로 요청이 온 경우에만 실행되는 메서드: do요청방식()
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/memAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		MemberVo vo = new MemberVo();
		vo.setMemId( req.getParameter("memId") );	//	== vo.setMemId( memId );
		vo.setMemPass( req.getParameter("memPass") );	//	== vo.setMemPass( memPass );
		vo.setMemName( req.getParameter("memName") );	//	== vo.setMemName( memName );
		vo.setMemPoint( Integer.parseInt(req.getParameter("memPoint")) );	//	== vo.setMemPoint( memPoint );
		
		int num = memberDao.insertMember( vo );
		System.out.println(num + "명의 회원 추가");
		resp.sendRedirect(req.getContextPath() + "/member/List.do");
		
	}
}

//@Override
//protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setContentType("text/html");		//응답내용이 text/html임을 알리도록 설정
//		resp.setCharacterEncoding("UTF-8");		//응답내용의 문자 인코딩 설정
//		out.println("<!DOCTYPE html>                  ");
//		out.println("<html>                           ");
//		out.println("<head>                           ");
//		out.println("<meta charset='UTF-8'>           ");
//		out.println("<title>회원관리</title> ");
//		out.println("</head>                          ");
//		out.println("<body>                           ");
//		out.println("<a href='" + req.getContextPath() + "/member/List.do'>회원목록으로이동</a>");
//
//		out.println("</body>                          ");
//		out.println("</html>                          ");
		
		
		
//	}

//private int insertMember(MemberVo vo) {
	// TODO Auto-generated method stub
//	return 0;
//}

//	public int insertMember( MemberVo vo ) {
//
////	public int insertMember(String memId, String memPass, String memName, int memPoint) {
//		int num = 0; 
//		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)"
//				+ "VALUES (?, ?, ?, ?)";
//
//		try(
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(sql);	
//				) {
//			
//			pstmt.setString(1, vo.getMemId());	
//			pstmt.setString(2, vo.getMemPass());	
//			pstmt.setString(3, vo.getMemName());	
//			pstmt.setInt(4, vo.getMemPoint());	
//			num = pstmt.executeUpdate(); 
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}
//


