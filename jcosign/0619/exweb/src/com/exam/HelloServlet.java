package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�� ���ø����̼� ������ ���� ����Ǵ� Ŭ������ Servlet ��Ģ�� ���� ������ ��
//�Ϲ������� HttpServlet Ŭ������ ����Ͽ� �ۼ�

@WebServlet("/hello.do") //"/hello.do" �ּҷ� ��û�� ���� �� ������ ����
public class HelloServlet extends HttpServlet {
	
	//�� ������ Ŭ������ �����Ű�� ��û�� �� ������ �� ���� ����Ǵ� �޼���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet");
		
		//POST������� ���۵� �Ķ���� ���� ���ڵ� ����
		req.setCharacterEncoding("UTF-8");
		//"name"�̶�� �̸��� �Ķ���� ���� �����ͼ� ���� n�� ����
		String n = req.getParameter("a");
		String n2 = req.getParameter("b");
		
		//��û���� ���� �� ���������� ����ϱ� ���ؼ��� ���ڷ� ���� ���䰴ü�� ����ؾ� ��.
			//�������
		resp.setContentType("text/html");
		//���� ������ text/html���� �˸����� ����
		resp.setCharacterEncoding("UTF-8");
		//���� ������ ���� ���ڵ� ����
		//utf-8�� �����Ѵ�.(�ѱ� ���� �� �ְ�.)
		PrintWriter out = resp.getWriter(); //���䰴ü�� ����� �� �ִ� ��Ʈ�� ��������
			//��������� ����.
		//out.println("Hello Servlet!!!               ");
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>Insert title here</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>Hello, " + n + "</h1>     ");
		out.println("	<h1>�ȳ�, " + n2 + "</h1>        	  ");
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}
