package com.exam;

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

//자바웹애플리케이션에서 데이터를 저장할 수 있는 공간(객체)
//1.요청객체(HttpServletRequest) : 요청을 보낼 때 마다 1개씩 새로 생성, 요청처리(응답전송)가 끝나면 소멸
//2.세션객체(HttpSession) : 사용자(웹브라우저)마다 1개씩 생성, 웹애플리케이션 실행 중 유지
//					- 일정시간동안 접속(요청전송)이 없는 사용자의 세션 객체는 소멸 가능
//3.서블릿컨텍스트객체(ServlerContext) : 웹애플리케이션 전체에 1개만 생성, 웹애플리케이션 실행 중 계속 유지
//					- 모든 사용자가 공유
//(4) PageContext 객체 : JSP 파일 1개마다 1개씩 새로 생성, 해당 JSP 실행이 끝나면 소멸 
//					- 서블릿이 아닌 JSP 에서 사용 가능
//(5) 쿠키 : 사용자의 웹브라우저에 저장시키고, 요청 전송시마다 자동으로 포함시켜 전송

@WebServlet("/attr.do")
public class AttrServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청객체에 "reqCnt"라는 이름으로 저장된 값을 가져오기
		AtomicInteger rcnt = (AtomicInteger) req.getAttribute("reqCnt");
		if (rcnt == null) {//요청객체에 "reqCnt"라는 이름으로 값을 저장한 적이 없는 경우 
			rcnt = new AtomicInteger(0);	//0 값을 가진 정수 객체 생성
		}
		rcnt.incrementAndGet();	//정수 값을 1증가
		req.setAttribute("reqCnt", rcnt);	//요청객체에 "reqCnt"라는 이름으로 저장된 값을 저장하기
		
		HttpSession session = req.getSession();	//현재 요청이 속한 세션 객체 가져오기
		//세션객체에 "sesCnt"라는 이름으로 저장된 값을 가져오기
		AtomicInteger scnt = (AtomicInteger) session.getAttribute("sesCnt");
		if (scnt == null) {//세션객체에 "sesCnt"라는 이름으로 값을 저장한 적이 없는 경우 
			scnt = new AtomicInteger(0);	//0 값을 가진 정수 객체 생성
		}
		scnt.incrementAndGet();	//정수 값을 1증가
		session.setAttribute("sesCnt", scnt);	//세션객체에 "sesCnt"라는 이름으로 scnt 값을 저장
		
		//현재 웹애플리케이션의 서블릿컨텍스트 객체 가져오기
		ServletContext context = req.getServletContext();
//		ServletContext sc = this.getServletContext();  둘 중 하나 쓰기
		//서블릿컨텍스트객체에 "conCnt"라는 이름으로 저장된 값을 가져오기
		AtomicInteger ccnt = (AtomicInteger) context.getAttribute("conCnt");
		if (ccnt == null) {//요청객체에 "conCnt"라는 이름으로 값을 저장한 적이 없는 경우 
			ccnt = new AtomicInteger(0);	//0 값을 가진 정수 객체 생성
		}
		ccnt.incrementAndGet();	//정수 값을 1증가
		context.setAttribute("conCnt", ccnt);	//세션객체에 "cesCnt"라는 이름으로 ccnt 값을 저장
		
		PrintWriter out = resp.getWriter();
		out.print(" request Cnt : " + rcnt );
		out.print(" session Cnt : " + scnt );
		out.print(" servlet context Cnt : " + ccnt );
		
	}
}
