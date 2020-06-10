package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 회원목록 화면에 '회원 추가'링크를 추가하고,
//링크를 클릭하면  http://localhost:8000/exweb/member/addform.do 로 이동

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet {

	MemberDaoJdbc memberDao = new MemberDaoJdbc();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<MemberVo> list = memberDao.selectMemberList();

		req.setAttribute("memList", list); //요청 객체에 ""라는 이름으로 list 데이터를 저장
			
		
//		"/META-INF/jsp/member/memList.jsp"파일로 이동
//		RequestDispatcher rd = req.getRequestDispatcher("/META-INF/jsp/member/memList.jsp"); //현재 요청을 위임하여 처리할 수 있도록 하는 디스패치
//		rd.forward(req, resp); //현재 요청 객체와 응답 객체를 전달해주면서 이동
		req.getRequestDispatcher("/META-INF/jsp/member/memList.jsp").forward(req, resp);
		
	}
	
}

//			String memId = rs.getString("mem_id");
//			String mempass = rs.getString("mem_pass");
//			String memName = rs.getString("mem_name");
//			int mempoint = rs.getInt("mem_point");
