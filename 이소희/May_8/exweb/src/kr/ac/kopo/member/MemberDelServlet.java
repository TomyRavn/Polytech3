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

//브라우저 주소창에
//http://localhost:8000/exweb/member/del.do?memId=a001
//를 입력하고 엔터키를 입력하면,
//데이터베이스에서 아이디가 'a001'인 회원을 삭제하고,
//브라우저 화면에 회원 목록이 출력되도록 구현

@WebServlet("/member/del.do")
public class MemberDelServlet extends HttpServlet {
	MemberDaoJdbc memberDao = new MemberDaoJdbc();

	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	String delId = req.getParameter("memId");
	
	int num = memberDao.deleteMember(delId); 

	System.out.println(num + "명의 회원 삭제");
	
	resp.sendRedirect(req.getContextPath() + "/member/list.do");

	}

}



