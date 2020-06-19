package com.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Life.do")
public class LifeServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		//�� ���� ��ü�� ó�� ������ ��, 1���� ����
		//���� ���� ������ ���� �ʱ�ȭ �۾����� ����
		System.out.println("LifeServlet : init ����!");
	}	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�� ������ ����� �ּҷ� ��û�� �� ������ �ѹ��� ����
		System.out.println("LifeServlet : service ����!");
	}
	
	@Override
	public void destroy() {
		//�� ���� ��ü�� �޸𸮿��� ���ŵ� ��, ���������� 1���� ����
		//���� ������ ����ϴ� �ڿ�(�޸�,���� ��)�� �ݳ��ϴ� �۾����� ����
		System.out.println("LifeServlet : destroy ����!");

	}
}
