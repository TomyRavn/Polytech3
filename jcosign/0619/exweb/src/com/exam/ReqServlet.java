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

//@WebServlet("/req/*")	//��� ���ڿ�(���ϸ�)�� �ǹ��ϴ� * ��� ����
@WebServlet("*.act")	//���ϸ��� .act�� ������ ��� ���Ͽ� ���� ��û��, ���� ����
public class ReqServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		��ּҷ� ��û�� �Դ���
		String uri = req.getRequestURI();
		//� ���������� ��û�� ���´���
		String header = req.getHeader("User-Agent");	//"User-Agent" ��û����� ��������
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
