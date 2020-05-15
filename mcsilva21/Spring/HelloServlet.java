package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�����ø����̼� ������ ���ؼ� ���ष�Ǵ� Ŭ������ Servlet ��Ģ�� ���� ������ �Ѵ�.
//�Ϲ������� httpServlet Ŭ������ ����Ͽ� �ۼ�

@WebServlet("/hello.do") // "/hello.do" �ּҷ� ��û�� ���� �� ������ ���� �̸� ���� ���� ��������
public class HelloServlet extends HttpServlet {
	
	
	//������ Ŭ������ �����Ű�� ��û�� �ö����� �ѹ��� ����Ǵ� �޼���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Serclet");
		
		//post 방식으로 저송된 파라미터 값의 인토딩 설정
		req.setCharacterEncoding("UTF-8");
		//"name"�̶�� �̸��� �Ķ���� ����  �����ͼ� ���� n�� ���� ����==> �����̸��ڿ�?name=GaYeong �Ķ���� �Է�
		String n = req.getParameter("a");
		String s = req.getParameter("b");
	
		//��û���� ���� ������������ ����ϱ� ���ؼ���
		//���ڷ� ���� ���䰴ü�� ����ؾ��Ѵ�.
		
		resp.setContentType("text/html");//���䳻���� text/html �������� ���������� �˷��� (1)
		resp.setCharacterEncoding("UTF-8"); //���� ��ü(����)�� ���� ���ڵ� ����(2) 1,2 =>��  ��Ʈ�� �������� �����ϱ�.
			
		PrintWriter out = resp.getWriter(); // ���䰴ü�� ����� �� �ִ� ��Ʈ����������(3) =>�ѱ� ����Ϸ��� 1,2,3 �ۼ��ؾ���
		//		out.println("Hello Servlet!!!");
		out.println("<!DOCTYPE html>                   ");
		out.println("<html>                            ");
		out.println("<head>                            ");
		out.println("<meta charset='UTF-8'>            "); //���ڵ� ����
		out.println("<title>Insert title here</title>  ");
		out.println("</head>                           ");
		out.println("<body>                            ");
		out.println("	<h1>Hello, " + n + " </h1>      ");
		out.println("	<h1>안녕, "+ s +" </h1>             "); //ũ���� ��� �������� ����.
		out.println("</body>                           ");
		out.println("</html>                           ");
	}
}
