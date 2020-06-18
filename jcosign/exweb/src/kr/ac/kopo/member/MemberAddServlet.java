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
	
	//��û�� ������, ��û ��Ŀ� ������� ����Ǵ� �޼���: service()
	//Ư�� ��û������� ��û�� �� ��쿡�� ����Ǵ� �޼���: do��û���()
	
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
		System.out.println(num + "���� ȸ�� �߰�");
		resp.sendRedirect(req.getContextPath() + "/member/List.do");
		
	}
}

//@Override
//protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		resp.setContentType("text/html");		//���䳻���� text/html���� �˸����� ����
//		resp.setCharacterEncoding("UTF-8");		//���䳻���� ���� ���ڵ� ����
//		out.println("<!DOCTYPE html>                  ");
//		out.println("<html>                           ");
//		out.println("<head>                           ");
//		out.println("<meta charset='UTF-8'>           ");
//		out.println("<title>ȸ������</title> ");
//		out.println("</head>                          ");
//		out.println("<body>                           ");
//		out.println("<a href='" + req.getContextPath() + "/member/List.do'>ȸ����������̵�</a>");
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


