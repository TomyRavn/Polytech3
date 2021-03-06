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

//1.회원추가 기능도 로그인 없이 사용가능하도록 변경 loginfilter를 변경
//2.로그인안한경우에는,[로그인] [회원가입] 메뉴가 나오고,
//로그인 한 경우에는 [회원관리][게시판][학생관리][로그아웃] 메뉴가 나오도록
//menu.jsp를 변경
//3.게시판에 새 글을 쓸 경우에 
//로그인한 사람의 아이디가 자동으로 글작성자로 저장되도록 변경

@WebFilter("/*")
//필터(Filter):지정된 주소로 요청이 왔을때, 서블릿의 실행 전과 후에 실행되는 객체
public class LoginFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter의 dofilter 실행!!");
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURI());

		if(! req.getRequestURI().equals(req.getContextPath()+ "/member/login.do") && ! req.getRequestURI().equals(req.getContextPath()+"/member/add.do")) 
				{
			//로그인 검사-로그인 주소 통과안되면 게시판 막아야함
			HttpSession session = req.getSession();
			MemberVo loginVo=(MemberVo)session.getAttribute("loginUser");
			
			if(loginVo == null) {//로그인 하지 않은 경우 -> 로그인 화면으로 이동
				resp.sendRedirect(req.getContextPath()+ "/member/login.do");
				return;
			}
		}
						
		//다음에 실행될 필터 또는 서블릿을 실행시키라는 명령
		chain.doFilter(request, response);
		
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들
		
	}
	
}
