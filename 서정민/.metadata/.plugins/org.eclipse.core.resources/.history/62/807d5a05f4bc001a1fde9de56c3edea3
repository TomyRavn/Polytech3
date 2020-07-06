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
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	//요청을 받으면 , 요청방식에 상관없이 실행되는 메서드 : service()
	//특정 요청방식으로 요청이 온 경우에만 실행되는 메서드 : do요청방식()
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/memAddForm.jsp").forward(req, resp);			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
//		req.setCharacterEncoding("UTF-8");			
		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt( req.getParameter("memPoint")));
		int num = memberService.insertMember(vo); 			
		System.out.println(num + "개의 레코드 추가");			
		resp.sendRedirect(req.getContextPath()+ "/member/list.do");
	}
			
}


	
	
	
	
	
	
	
	
	
	

