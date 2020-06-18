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

//������ �ּ�â��
//http://localhost:8000/exweb/member/del.do?memId=a001
//�� �Է��ϰ� ����Ű�� �Է��ϸ�
//�����ͺ��̽����� ���̵� 'a001'�� ȸ���� �����ϰ�,
//������ ȭ�鿡 ȸ������� ��µǵ��� ����
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
		System.out.print("������ ȸ���� ���̵� �Է��ϼ���.\n");
		String delid = req.getParameter("memId");	
		
			int num = memberDao.deletMember(delid);
			System.out.println(num + "��ȸ�� ����");
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
//			num = pstmt.executeUpdate(); //������ ����� ���ڵ� ���� ��ȯ
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}

