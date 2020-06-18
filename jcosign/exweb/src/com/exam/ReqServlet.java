package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/req/*")	//모든 문자열(파일명)을 의미하는 * 사용 가능
@WebServlet("*.act")	//파일명이 .act로 끝나는 모든 파일에 대한 요청시, 서블릿 실행
public class ReqServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		어떤주소로 요청이 왔는지
		String uri = req.getRequestURI();
		//어떤 브라우저에서 요청을 보냈는지
		String header = req.getHeader("User-Agent");	//"User-Agent" 요청헤더값 가져오기
		String agent = "Unknown Browser";
		if(header.contains("Chrome")){
			agent = "Chrome";
		} else if(header.contains("Trident")){
			agent = "Internet Explorer";
		}
		
		PrintWriter out = resp.getWriter();
		out.println("ReqServlet!!");
		out.println(uri);
		out.println("Your Browser : " + agent);
	}
}
