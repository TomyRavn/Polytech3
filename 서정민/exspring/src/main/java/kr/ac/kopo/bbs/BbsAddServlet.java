package kr.ac.kopo.bbs;

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
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

@WebServlet("/bbs/add.do")
public class BbsAddServlet extends HttpServlet {
	private BbsService bbsServive = new BbsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsAdd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");

		BbsVo vo = new BbsVo();
		vo.setBbsTitle(req.getParameter("bbsTitle"));
		vo.setBbsContent(req.getParameter("bbsContent"));
		
		//로그인한 사용자의 아이디를 게시글 작성자로 강제설정->보안을 위해서
		HttpSession session = req.getSession();
		MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");
		vo.setBbsWriter(loginVo.getMemId());

		int num = bbsServive.insertBbs(vo);
		System.out.println(num + "개의 레코드 추가");

		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
	}

}
