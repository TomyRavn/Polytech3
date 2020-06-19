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
//localhost:8000/ex_web/member/del.do?memId=a001
//을 입력하고 엔터키를 입력하면
//데이터베이스에서 아이디가 'a001'인 회원을 삭제하고,
//브라우저 화면에 회원목록이 출현되도록 구현

@WebServlet("/member/del.do")
public class MemberDelServlet extends HttpServlet{
	
	MemberDao memberDao = new MemberDaoBatis();
	
	//리팩토링 : 코드가 하는 일은 똑같이 두면서, 코드를 더 효율적으로 개선하는 것
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String delId = req.getParameter("memId");
		
		memberDao.deleteMember(delId);
		
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
	
	}

	//alt + shift + r 로 같은 값 해당 메소드 내 전체 변경
	
}