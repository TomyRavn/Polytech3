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


@WebServlet("/bbs/add.do")	//이 주소로 오면 service가 실행되는 것은 불변의 진리 -> service가 여기 짜여져있지 않으므로 HttpServlet의 service가 실행되는데 doGet() doPost()가 구현되어있어 거기에 맞게 실행
public class BbsAddServlet extends HttpServlet{
	
	BbsDao bbsDao = new BbsDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		
		BbsVo vo = new BbsVo();
		String bbsTitle = req.getParameter("bbsTitle");
		String bbsContent = req.getParameter("bbsContent");
		
		HttpSession session = req.getSession();
		MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");	
		
		//보안 상 파라미터값을 받아와서 쓰면 안되고 세션에 있는 로그인한 사람의 아이디를 꺼내와서 써야함
		//String bbsWriter = req.getParameter("bbsWriter");
		
		//공백인 제목 등록 방지
		if(!bbsTitle.equals("")) {
		
			
			vo.setBbsTitle(bbsTitle);
			vo.setBbsContent(bbsContent);
			vo.setBbsWriter(loginVo.getMemId());
//			vo.setBbsWriter(bbsWriter);
		
			int num = bbsDao.insertBbs(vo);
	
			System.out.println(num + "개의 글 추가");
		}
		
		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
	}
	
}