package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/req/*") //모든 문자열(파일을)을 의미하는 * 사용가능 
@WebServlet("*.act") //파일명이.act로 끝나는 모든 파일에 대한 요청시,서블릿 실행
public class ReqServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //resp 응답 객체를 출력해줘야함		
		//어떤 주소로 요청(req)이 왔는지
		 String uri = req.getRequestURI();
		//어떤 브라우저에서 요청을 보냈는지 
		String header = req.getHeader("User-Agent");
		//변수자동처리 ctrl+1
			
		String agent = "Unknown Browser";
		if(header.contains("Chrome")) {
			agent = "Chrome";
		}else if (header.contains("Trident")) {
			agent = "Internet Explorer";
		}
			
		PrintWriter out = resp.getWriter();//응답객체를 받아와서 Writer글자를 출력할때 받음
		out.println("ReqServlet!!"); //out으로 출력해줌
		out.println(uri);
		out.println("Your Browser:" + agent);
		
//		ServletOutputStream out = resp.getOutputStream(); 문자가 아닌 영상,음악등 문자가 아닌 파일을 출력할떄 쓰임
//		out.write(b);
		
//브라우저에 주소를  입력 	http://localhost:8000/exweb/hello.do
//톰갯이 exweb에 웹 서블릿에 맞는 주소를 찾아서  @WebServlet("hello.do") class HttpServlet을 실행을 해줌
//HttpServlet은 상속을 해서 만듬 서비스메소드가 실행이 된 후
//HttpServletRequest req, HttpServletResponse resp
//브라우저창에 화면을 출력하고 싶으면 PrintWriter out = resp.getWriter(); 응답객체에 프린터를 함
//응답 객체에 들어오느 내용이 브라우저에 출력
//주소를 지정을하면 똑같은 값만 출력되므로 hello.do/x=3,y=4 뒤에 파라미터를 입력함 
///String x=req,getParmater("x)요청 객체를 꺼내서 출력함
//웹 서블릿이란 자바코드에 html을 넣는것 => 편집량이 너무 많음 --> jsp를 만들어 html안에 자바를 삽입함.
//exweb/WebContent << jsp를 만듦. css,자바스크립트등을 모두 만들 수 있음
				
	}
	
}

