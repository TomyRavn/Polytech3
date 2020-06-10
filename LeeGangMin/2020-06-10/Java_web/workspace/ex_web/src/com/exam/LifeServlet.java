package com.exam;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//최소한의 요구조건 : implements servlet
//httpservlet에서 구현이 되어 상속받았기 때문에 기존 servlet에서는 메소드를 따로 구현할 필요가 없었음(destroy, ... 등)

//@WebServlet("/life.do")	//--> 주석 처리시 브라우저에서 실행하지 못함

public class LifeServlet extends HttpServlet{
	
	//오버라이드해서 주로 씀
	//주로 override하는 메소드 (3개 ; init, service, destroy)
	
	
//	//톰캣이 알아서 실행시켜줌
//	LifeServlet a = new LifeServlet();
//	a.init();
	@Override
	public void init() throws ServletException {
		//이 서블릿 객체가 처음 생성된 후, 1번만 실행
		//보통 서블릿 실행을 위한 초기화 작업들을 수행
		System.out.println("LifeServlet : init 실행!");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이 서블릿과 연결된 주소로 요청이 올 때마다 한번씩 실행
		System.out.println("LifeServlet : service 실행!");
	}
	
	@Override
	public void destroy() {
		//이 서블릿 객체가 메모리에서 제거될 때, 마지막으로 1번만 실행
		//보통 서블릿이 사용하던 자원(메모리, 소켓 등)을 반납하는 작업들을 수행
		System.out.println("LifeServlet : destroy 실행!");	//메모리 반납 절차라서 메모리가 부족한 상황이 아니면 잘 찍히지 않음?
															//호출이 오랫동안 되지 않을 때 찍힘
	}
}