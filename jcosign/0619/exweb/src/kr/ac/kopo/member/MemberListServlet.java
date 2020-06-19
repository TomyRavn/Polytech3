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

//ȸ����� ȭ�鿡 'ȸ���߰�'��ũ�� �߰��ϰ�,
//��ũ�� Ŭ���ϸ� http://localhost:8000/exweb/member/addform.do�� �̵�

@WebServlet("/member/List.do")
public class MemberListServlet extends HttpServlet{

	MemberDao memberDao = new MemberDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<MemberVo> list = memberDao.selectMemberList();
		
		req.setAttribute("memList", list);		//��û��ü�� "memList"��� �̸����� list �����͸� ����
		
// 		"/WEB-INF/jsp/member/memList.jsp" ���Ϸ� �̵�
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp"); //�����û�� �����Ͽ� ó���� �� �ֵ��� �ϴ� ������ ��������
//		rd.forward(req, resp);   //���� ��û��ü�� ���䰴ü�� �������ָ鼭 �̵�	
		req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp").forward(req, resp);
		//�� ���ٰ� ����
	}
}

		
		//		super.service(req, resp);
		//		PrintWriter out = resp.getWriter();
		//		out.println("MemberListServlet");

//		resp.setContentType("text/html");		//���� ������ text/html���� �˸����� ����
//		resp.setCharacterEncoding("UTF-8");		//���� ������ ���� ���ڵ� ����	//utf-8�� �����Ѵ�.(�ѱ� ���� �� �ְ�.)
//		PrintWriter out = resp.getWriter(); 	//���䰴ü�� ����� �� �ִ� ��Ʈ�� ��������
//		//��������� ����.
//		//out.println("Hello Servlet!!!               ");
//		out.println("<!DOCTYPE html>                  ");
//		out.println("<html>                           ");
//		out.println("<head>                           ");
//		out.println("<meta charset='UTF-8'>           ");
//		out.println("<title>ȸ������</title> ");
//		out.println("</head>                          ");
//		out.println("<body>                           ");
//		out.println("	<h1>ȸ���߰�</h1>     ");
//		out.println("<a href='" + req.getContextPath() + "/member/addform.do'><button>�߰�</button></a><br />");
//		{
//			for (int i = 0; i < list.size(); i++) {
//				MemberVo vo = list.get(i);
//			for (MemberVo vo : list) {		//���� ����
//			
//			out.println("<a href='" + req.getContextPath() + "/member/editform.do?memId=" + vo.getMemId() + "'>" + vo.getMemId() + "</a>");
//			out.println(": " +vo.getMemPass() + ": "+ vo.getMemName() + ": " +vo.getMemPoint());
////			out.println("<a href='" + req.getContextPath() + "/member/del.do?memId=" + memId + "'><button>����</button></a><br />");
//			out.println("<br />");			//<br / > �ٹٲ�
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




