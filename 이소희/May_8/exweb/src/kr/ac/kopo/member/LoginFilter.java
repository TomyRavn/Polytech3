package kr.ac.kopo.member;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1. 회원 추가 기능도 로그인 없이 사용 가능하도록 변경
//2. 로그인 안 한 경우에는 [로그인]과 [회원가입] 메뉴만 나오고,
// 	로그인 한 경우에는, [회원목록][게시판][회원관리][로그아웃] 메뉴가 나오도록
// 	menu.jsp를 변경
//3. 게시판에 새 글을 쓸 경우에 로그인한 사람의 아이디가 자동으로 글 작성자로 저장

//필터(Filter) : 지정된 주소로 요청이 왔을때, 서블릿의 실행 전과 후에 실행되는 객체
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter의 doFilter 실행!");
		// 다음 필터 또는 서블릿 실행 전에 수행할 작업들
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println(req.getRequestURI());

		if (!req.getRequestURI().contentEquals(req.getContextPath() + "/member/login.do") 
				&& !req.getRequestURI().contentEquals(req.getContextPath() + "/member/add.do")) {
			// 로그인 검사 수행
			HttpSession session = req.getSession(); 
			MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");
			if (loginVo == null) {// 로그인 하지 않은 경우
				resp.sendRedirect(req.getContextPath() + "/member/login.do");// 로그인 화면으로 이동	
				return;		
			}
		}

		// 다음에 실행될 필터 또는 서블릿을 실행 시키라는 명령
		chain.doFilter(request, response);

		// 다음 필터 또는 서블릿 실행 후에 수행할 작업들
	
			
			
	}

}
