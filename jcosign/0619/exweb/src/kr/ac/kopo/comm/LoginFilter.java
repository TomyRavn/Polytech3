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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

//1. 회원추가 기능도 로그인 없이 사용 가능하도록 변경
//2. 로그인 안 한 경우에는, [로그인][회원가입]메뉴가 나오고,
// 로그인 한 경우에는, [회원관리][게시판][학생관리][로그아웃]메뉴가 나오도록 menu.jsp를 변경
//3. 게시판에 새 글을 쓸 경우에 
// 로그인한 사람의 아이디가 자동으로 글작성자로 저장되도록 변경

// 필터(Filter) : 지정된 주소로 요청이 왔을 때, 서블릿의 실행 전과 후에 실행되는 객체
//	- 여러 서블릿들에서 공통적으로 실행해야 하는 전처리/후처리 작업 구현시 사용
//	- 등록방법
//		(1) @WebFilter("요청주소") 를 필터 클래스에 적용하여 등록
//		(2) web.xml 실행파일에 등록

@WebFilter("/*")
public class LoginFilter implements Filter{
	private ArrayList<String> whiteList= new ArrayList<String>();
	//private은 안붙여도된다.
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init. 필터 객체가 처음 생성된 후 , 1번만 실행
		System.out.println("LogFilter의 init실행!");
		
		whiteList.add("/member/Login.do");
		whiteList.add("/member/add.do");
//		<String>에 두 주소를 담는다.
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// doFilter 이 필터에 지정된 주소로 요청이 올때마다 1번씩 실행
		System.out.println("LoginFilter의 doFilter 실행!");
		
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println( req.getRequestURI() );
		//RequestURI에서 ContextPath를 제외한 뒷부분의 경로만 추출
		
//		req.getRequestURI().substring( 6 );
//		req.getRequestURI().substring( "/exweb".length() );
//		req.getRequestURI().substring( req.getRequestURI().length() );
//		substring()는 ()안의 숫자만큼 지워준다. 그 중 맨 아래 것을 쓰는 게 가장 효율적(다른 건 코드 변경시 수정해야 하니까)
		String reqPath = req.getRequestURI().substring( req.getContextPath().length() );
		
//		whiteList.contains( req.getRequestURI() );
		//getRequestURI()안에는 req.getContextPath()가 포함되어 있다.
//		whiteList.contains( "/exweb/member/Login.do" );

//		if ( req.getRequestURI().equals(req.getContextPath()+"/member/Login.do") == false 
//				&& !req.getRequestURI().equals(req.getContextPath()+"/member/add.do")) {
//			//로그인 검사 시행 (둘 다 아닐 때 검사해야 하니까 &&로 묶는다.)
		if ( whiteList.contains( reqPath ) == false ) { //요청주소가 whiteList에 없는 경우
			HttpSession session = req.getSession();
			MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");
			if ( loginVo == null ) { //로그인하지 않은 경우
				resp.sendRedirect(req.getContextPath()+"/member/Login.do");	//로그인화면으로 이동
				return;
			}

			//		System.out.println( req.getRequestURL());

			//		HttpSession session = req.getSession();
			//		MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");
			//		if ( loginVo == null ) { //로그인하지 않은 경우
			//			//로그인화면으로 이동
			//			resp.sendRedirect(req.getContextPath()+"/member/Login.do");
			//			return;
			//		}
			//		
			
		}
		
		//다음에 실행될 필터 또는 서블릿을 실행시키라는 명령
		
		chain.doFilter(request, response);
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들
	}
	
	@Override
	public void destroy() {
		// 필터 객체가 소멸되기 전에 1번만 실행
	}
}
