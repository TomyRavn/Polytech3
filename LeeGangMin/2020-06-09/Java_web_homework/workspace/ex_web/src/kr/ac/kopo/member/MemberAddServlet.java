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
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		//메소드 분리방법(우클릭 Refactor > Extract Method > 메소드 명 입력 > 확인 > 접근 제한자 설정(public 등)
		
		MemberVo vo = new MemberVo();
		vo.setMemId(memId);
		vo.setMemPass(memPass);
		vo.setMemName(memName);
		vo.setMemPoint(memPoint);
		
		int num = memberDao.insertMember(vo);
	
		System.out.println(num + "명의 회원 추가");
		
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
	}
	
}