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

@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/META-INF/jsp/member/login.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		MemberVo loginVo = memberService.selectLoginMember(vo);

//		PrintWriter out = resp.getWriter();
//
//		if (loginVo == null) { // 로그인 실패(입력한 ID/PW와 일치하는 회원이 없는 경우)
//			out.print("login fail!");
//		} else { // 로그인 성공(입력한 ID/PW와 일치하는 회원이 있는 경우)
//			out.print("login success!");
//		}

		
		
		// 로그인 성공시, 회원 목록으로 이동
		// 로그인 실패시, 다시 로그인 화면으로 이동
		if (loginVo == null) {
			resp.sendRedirect(req.getContextPath() + "/member/login.do");
		} else {
			HttpSession session = req.getSession(); //현재요청이 속한 세션 객체 가져오기
			session.setAttribute("loginUser", loginVo); //로그인 한 사람의 정보가 담긱 객체를 "loginUser"라는 이름으로 세션에 저장
			
			resp.sendRedirect(req.getContextPath() + "/member/list.do");
		}
	}
}
