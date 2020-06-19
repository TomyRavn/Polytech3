package kr.ac.kopo.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

//필터(Filter) : 지정된 주소로 요청이 왔을 때, 서블릿의 실행 전과 후에 실행되는 객체
// - 여러 서블릿들에서 공통적으로 실행해야 하는 전처리/후처리 작업 구현시 사용
// - 등록방법
//		(1) @WebFilter("요청주소")를 필터 클래스에 적용하여 등록
//		(2)	web.xml 설정파일에 등록


//@WebFilter("/member/*") , @WebFilter("/member/abc.do")일 때는 둘 다 실행됨

//필터를 쓰는 이유 : 서블릿의 공통된 작업을 할 때, 서블릿 실행 전 선처리 후처리의 기능을 사용하고자 할 때 사용
//순서 : Filter(*) -> Servlet(a.do) -> Servlet(b.do) -> Servlet(c.do) -> Filter

//<->
//WebServlet을 여러개 썼을 경우 보다 구체적으로 일치하는(적합한) 주소만 실행 (* | abc.do 중 abc.do가 실행)

//1.회원 추가 기능도 로그인 없이 사용 가능하도록 변경
//2.로그인 안 한 경우에는, [로그인] [회원가입] 메뉴가 나오고,
//	로그인 한 경우에는, [회원관리], [게시판], [학생관리],[로그아웃] 메뉴가 나오도록 menu.jsp 변경
//3.게시판에 새 글을 쓸 경우에 로그인한 사람의 아이디가 자동으로 글작성자로 저장되도록 변경 

@WebFilter("*")
public class LoginFilter implements Filter{
	
	private ArrayList<String> whiteList = new ArrayList<String>();
	
	//필터 객체가 처음 생성된 후, 1번만 실행하는 코드
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter의 init 실행!");
		//로그인 없이 사용 가능한 영역 주소
		whiteList.add("/member/login.do");
		whiteList.add("/member/add.do");
	}
	
	
	//FilterChain : 동일한 주소로 걸어진 Filter들의 묶음
	//이 필터에 지정된 주소로 요청이 올때마다 1번씩 실행
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter의 doFilter 실행!");
		
		
		
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURI());	//contextPath부터 경로
//		System.out.println(req.getRequestURL());	//전체 경로
		
//		/ex_web/ -> 7 (0,1,2,3,4,5,6,7) : 하지만 고정형은 경로 변경 시 계속 바꾸어주어야함
//		RequestURI 에서 Context Path 를 제외한 뒷 부분의 경로만 추출
		
		String reqPath = req.getRequestURI().substring(req.getContextPath().length());
//		String reqPath = req.getRequestURI().substring(7);
//		whiteList.contains(reqPath)		//포함하고 있는지 안하고 있는지 참, 거짓으로 반환하는 메소드
		
		if(!whiteList.contains(reqPath)) {
			//로그인 검사 수행
			HttpSession session = req.getSession();
			MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");
			if(loginVo == null) {	//로그인 하지 않은 경우
				//로그인 화면으로 이동
				resp.sendRedirect(req.getContextPath()+"/member/login.do");
				return;
			}
		}
		
		
		//필터는 다음 실행할 필터나 서블릿을 지정해주어야 다음 내용이 정상적으로 수행됨
		//다음에 실행도리 필터 또는 서블릿을 실행시키라는 명령
		chain.doFilter(request, response);
		
		//다음 필터 또는 서블릿 실행 후에 수행할 작업들
	}
	
	
	//필터 객체가 소멸되기 전에 1번만 실행
	//필터가 사용하던 자원을 반납할 때 이용
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}