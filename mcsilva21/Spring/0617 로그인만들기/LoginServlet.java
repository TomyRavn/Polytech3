package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//1."/member/login.do"로 GET방식 요청을 보내면
//   /WEB-INF/JSP/member/login.jsp로 이동(forward)하여
//   아이다와 비밀번호를 입려할 수 있는 화면을 출력
//2.아이디와 비밀번호를 입력하고 로그인 버튼을 클릭하면
//  /member/login.do"로 POST방식 요청을 전송하고,
//  입력한 아이디와 비밀번호의 회원정보를  member 테이블에서 조회
// 그런 회원이 있으면 로그인 성공"Login success"를 출력
// 그런 회원이 없으면 로그인 성공"Login fail"라고 출력

@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {	
	private MemberDaojdbc memberDao = new MemberDaojdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 	

		req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);			
}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	MemberVo vo = new MemberVo();
	vo.setMemId(req.getParameter("memId"));
	vo.setMemPass(req.getParameter("memPass"));
	MemberVo loginVo = memberDao.selectLoginMember(vo);
	
	//로그인 성공시,회원목록으로 이동
	//로그인 실패시,다시 로그인화면으로 이동
	PrintWriter out = resp.getWriter();
	req.setCharacterEncoding("UTF-8");
	
	if(loginVo==null) { //로그인실패(입력한 ID/PW와 일치하는 회원이 없는 경우)
//		out.print("Login fail");
		resp.sendRedirect(req.getContextPath()+ "/member/login.do");
	} else { //로그인성공(입력한 ID/PW와 일치하는 회원이 있는 경우)
//		out.print("Login success");
		
		HttpSession session = req.getSession();//현재요청이 속한 세션객체 가져오기
		session.setAttribute("loginUser", loginVo); //로그인한사람의정보가 담긴 객체를 LoginUser"라는 이름으로 세션에 저장
		
		resp.sendRedirect(req.getContextPath()+ "/member/list.do");
	}
		
	}
}