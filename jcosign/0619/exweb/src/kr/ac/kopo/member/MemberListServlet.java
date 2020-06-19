package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.HelloServlet;

//회원목록 화면에 '회원추가'링크를 추가하고,
//링크를 클릭하면 http://localhost:8000/exweb/member/addform.do로 이동

@WebServlet("/member/List.do")
public class MemberListServlet extends HttpServlet{

	MemberDao memberDao = new MemberDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<MemberVo> list = memberDao.selectMemberList();
		
		req.setAttribute("memList", list);		//요청객체에 "memList"라는 이름으로 list 데이터를 저장
		
// 		"/WEB-INF/jsp/member/memList.jsp" 파일로 이동
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp"); //현재요청을 위임하여 처리할 수 있도록 하는 디스패쳐 가져오기
//		rd.forward(req, resp);   //현재 요청객체와 응답객체를 전달해주면서 이동	
		req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp").forward(req, resp);
		//위 두줄과 같음
	}
}

		
		//		super.service(req, resp);
		//		PrintWriter out = resp.getWriter();
		//		out.println("MemberListServlet");

//		resp.setContentType("text/html");		//응답 내용이 text/html임을 알리도록 설정
//		resp.setCharacterEncoding("UTF-8");		//응답 내용의 문자 인코딩 설정	//utf-8로 통일한다.(한글 나올 수 있게.)
//		PrintWriter out = resp.getWriter(); 	//응답객체에 출력할 수 있는 스트림 가져오기
//		//여기까지는 고정.
//		//out.println("Hello Servlet!!!               ");
//		out.println("<!DOCTYPE html>                  ");
//		out.println("<html>                           ");
//		out.println("<head>                           ");
//		out.println("<meta charset='UTF-8'>           ");
//		out.println("<title>회원관리</title> ");
//		out.println("</head>                          ");
//		out.println("<body>                           ");
//		out.println("	<h1>회원추가</h1>     ");
//		out.println("<a href='" + req.getContextPath() + "/member/addform.do'><button>추가</button></a><br />");
//		{
//			for (int i = 0; i < list.size(); i++) {
//				MemberVo vo = list.get(i);
//			for (MemberVo vo : list) {		//위와 같음
//			
//			out.println("<a href='" + req.getContextPath() + "/member/editform.do?memId=" + vo.getMemId() + "'>" + vo.getMemId() + "</a>");
//			out.println(": " +vo.getMemPass() + ": "+ vo.getMemName() + ": " +vo.getMemPoint());
////			out.println("<a href='" + req.getContextPath() + "/member/del.do?memId=" + memId + "'><button>삭제</button></a><br />");
//			out.println("<br />");			//<br / > 줄바꿈
//			}
//			out.println("----------------------------------");
//			
//		}
//		out.println("</body>                          ");
//		out.println("</html>                          ");
//	}

//	public ArrayList<MemberVo> selectMemberList() {
//		ArrayList<MemberVo> list= new ArrayList<MemberVo>();
//		
//		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
//		try(
//				Connection conn = DriverManager.getConnection(url, user, password);
//				PreparedStatement pstmt = conn.prepareStatement(sql);	
//				ResultSet rs = pstmt.executeQuery(); 
//				)
//				{
//					while (rs.next()) {
//						MemberVo vo = new MemberVo();
//						vo.setMemId( rs.getString("mem_id"));
//						vo.setMemPass( rs.getString("mem_pass"));
//						vo.setMemName( rs.getString("mem_name"));
//						vo.setMemPoint( rs.getInt("mem_point"));
//						list.add(vo);
						
//							String memId = rs.getString("mem_id"); 
//							String memPass = rs.getString("mem_pass"); 
//							String memName = rs.getString("mem_name"); 
//							int memPoint = rs.getInt("mem_point"); 
						
//					}
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		return list;




