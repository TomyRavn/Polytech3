package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//자바 웹 애플리케이션에서 데이터를 저장할 수 있는 공간(객체)
//1.요청객체(HttpServletRequest) : 요청마다 1개씩 새로 생성, 해당 요청처리(응답전송)가 끝나면 소멸
//2.세션객체(HttpSession) : 사용자(웹 브라우저, 클라이언트)마다 1개씩 생성, 요청 처리가 끝나도 계속 유지, 웹 애플리케이션 실행 중 계속 유지, 일정 시간(오랜시간)동안 접속(요청 전송)이 없을 시 사용자의 세션 객체가 소멸될 수 있음(설정 가능 session time out)
//3.서블릿컨텍스트객체(ServletContext) : 웹애플리케이션 전체에 1개만 생성, 웹 애플리케이션 실행 중 계속 유지
//(4) PageContext 객체 : JSP파일 1개마다 1개씩 새로 생성, 해당 JSP 실행이 끝나면 소멸
//						- 서블릿이 아닌 JSP에서만 사용 가능
//(5) 쿠키 : 사용자의 웹 브라우저에 저장시키고, 요청 전송시마다 자동으로 포함시켜 전송
//2나 (5)를 이용하여 장바구니

@WebServlet("/attr.do")
public class AttrServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청객체에 "reqCnt"라는 이름으로 저장된 값을 가져오기
		AtomicInteger rcnt = (AtomicInteger) req.getAttribute("reqCnt");
		if(rcnt == null) {					//요청객체에 "reqCnt"라는 이름으로 값을 저장한 적이 없는 경우
			rcnt = new AtomicInteger(0);	//0값을 가진 정수 객체 생성	(Thread의 안전한 정수 객체 , 일단은 Integer라고 생각(정수 하나를 저장가능함))
		}
		
		//1. 요청객체
		rcnt.incrementAndGet();				//정수 값을 1 증가
		req.setAttribute("reqCnt", rcnt);	//요청객체에 "reqCnt"라는 이름으로 rcnt 값을 저장
		
		//2. 세션객체
		HttpSession session = req.getSession(); //현재 요청에 속한 세션 객체 가져오기
		AtomicInteger scnt = (AtomicInteger) session.getAttribute("sesCnt");
		if(scnt == null) {
			scnt = new AtomicInteger(0);
		}
		scnt.incrementAndGet();
		session.setAttribute("sesCnt", scnt);
		
		//3.서블릿 컨텍스트 객체
		//현재 웹 애플리케이션의 서블릿 컨텍스트 객체 가져오기
		ServletContext sc = req.getServletContext();
//		ServletContext sc = this.getServletContext();
		AtomicInteger conCnt = (AtomicInteger) sc.getAttribute("conCnt");
		if(conCnt == null) {
			conCnt = new AtomicInteger(0);
		}
		conCnt.incrementAndGet();
		sc.setAttribute("conCnt", conCnt);
		
		
		PrintWriter out = resp.getWriter();
		out.println("reqCnt : " + rcnt);
		out.println("sesCnt : " + scnt);
		out.println("conCnt : " + conCnt);
		
		//요청객체를 계속 새로 생성하기 때문에, 새로고침을 해도 계속 1로만 출력(기존 요청객체는 사라지고, 다른 요청걕체가 생성되었기 때문)
		
	}
	
}