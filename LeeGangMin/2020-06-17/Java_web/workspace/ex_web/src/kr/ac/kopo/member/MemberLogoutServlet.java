package kr.ac.kopo.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class MemberLogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//1.null을 저장하는 방식
		session.setAttribute("loginUser", null);	//세션에 "loginUser"라는 이름으로 null을 저장
//		//2.이름에 저장한 값 자체를 제거하는 방식
//		session.removeAttribute("loginUser");		//세션에 "loginUser"라는 이름으로 저장한 값 자체를 제거
//		//3.세선을 초기화(재생성)하는 방식
//		session.invalidate();						//세션 객체 자체를 초기화(새로 생성) -> 세션에 저장했던 모든 데이터를 삭제
		
		resp.sendRedirect(req.getContextPath() + "/member/login.do");
	}
	
}