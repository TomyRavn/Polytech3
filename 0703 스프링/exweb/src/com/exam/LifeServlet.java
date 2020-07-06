package com.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//LifeServleta = new LifeServlet(); <<톰캣이 실행

//인터페이스 구현 서블릿이라면 가져야할 메소드 생성 이전 서비스 서블릿은 http가 상속받아 구현해서 밑에 메소드가 없어도 실행가능 했었음.
//@WebServlet("/life.do")  //annotation는 컴퓨터한테 읽어주는 객체 annotation을 안쓴다면 , web.xml로 찾아줘야함. 남의 만든 서블릿을 불러올 수 있음
public class LifeServlet extends HttpServlet{
	

@Override
public void init() throws ServletException {
	// 이 서블릿 객체가 처음 생성된 후, 1번만 실행
	//보통 서블릿 실행을 위한 초기화 작업들을 수행
	//무언가를 준비할때 
	System.out.println("LifeServlet : init 실행!");
}	

@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 이 서블릿과 연결된 주소로 요청(새로고침)이 올 때마다 한번씩 실행
	System.out.println("LifeServlet : service 실행!");
	}

@Override
	public void destroy() {
		// 이 서블릿 객체가 메모리에서 제거될 떄, 마지막으로 1번 실행
		//보통 서블릿이 사용하던 자원(메모리,소캣 등)을 반납하는 작업들을 수행
	System.out.println("LifeServlet : destroy 실행!");
	
	}
	
}
