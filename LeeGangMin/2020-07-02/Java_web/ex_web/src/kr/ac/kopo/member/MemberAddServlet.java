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


@WebServlet("/member/add.do")	//이 주소로 오면 service가 실행되는 것은 불변의 진리 -> service가 여기 짜여져있지 않으므로 HttpServlet의 service가 실행되는데 doGet() doPost()가 구현되어있어 거기에 맞게 실행
public class MemberAddServlet extends HttpServlet{
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	//요청을 받으면, 요청방식에 상관없이 실행되는 메소드 : service()
	//특정 요청방식으로 요청이 온 경우에만 실행되는 메소드 : do요청방식() (HttpServlet에 모두 구현되어있음) 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/memAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		MemberVo vo = new MemberVo();
		vo.setMemId(memId);
		vo.setMemPass(memPass);
		vo.setMemName(memName);
		vo.setMemPoint(memPoint);
		
		int num = memberService.insertMember(vo);
	
		System.out.println(num + "명의 회원 추가");
		
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
	}
	
	
//	주소가 달라도 요청방식이 다를 수 있다
//	HTTP command
//	회원추가 버튼을 눌렀을 떄와 저장을 눌렀을 때
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		//get방식으로 요청이 온 경우
//		if(req.getMethod().equalsIgnoreCase("get")) {
//			
//			req.getRequestDispatcher("/WEB-INF/jsp/member/memAddForm.jsp").forward(req, resp);
//			
//		}
//		//post방식으로 요청이 온 경우
//		else if(req.getMethod().equalsIgnoreCase("post")){
//			
//			req.setCharacterEncoding("UTF-8");
//			
//			String memId = req.getParameter("memId");
//			String memPass = req.getParameter("memPass");
//			String memName = req.getParameter("memName");
//			int memPoint = Integer.parseInt(req.getParameter("memPoint"));
//			
//			MemberVo vo = new MemberVo();
//			vo.setMemId(memId);
//			vo.setMemPass(memPass);
//			vo.setMemName(memName);
//			vo.setMemPoint(memPoint);
//			
//			int num = memberDao.insertMember(vo);
//		
//			System.out.println(num + "명의 회원 추가");
//			
//			resp.sendRedirect(req.getContextPath() + "/member/list.do");
//			
//		}
//		
//	}
	
}