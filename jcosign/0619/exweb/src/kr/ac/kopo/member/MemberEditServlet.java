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

@WebServlet("/member/edit.do")
public class MemberEditServlet extends HttpServlet{
	MemberDao memberDao = new MemberDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("memId");
		MemberVo vo = memberDao.selectMember(no);

		req.setAttribute("memVo", vo);

		req.getRequestDispatcher("/WEB-INF/jsp/member/memEditForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");	//POST방식으로 전송된 파라미터 값의 인코딩 설...

		MemberVo vo = new MemberVo();
		vo.setMemId( req.getParameter("memId"));
		vo.setMemName( req.getParameter("memName"));
		vo.setMemPoint( Integer.parseInt(req.getParameter("memPoint")));
		
		
		int num = memberDao.updateMember(vo);
		
		System.out.println(num + "명의 회원 추가");
		resp.sendRedirect(req.getContextPath() + "/member/List.do");
	}

	
}
