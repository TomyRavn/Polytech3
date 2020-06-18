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

//�ڹ������ø����̼ǿ��� �����͸� ������ �� �ִ� ����(��ü)
//1.��û��ü(HttpServletRequest) : ��û�� ���� �� ���� 1���� ���� ����, ��ûó��(��������)�� ������ �Ҹ�
//2.���ǰ�ü(HttpSession) : �����(��������)���� 1���� ����, �����ø����̼� ���� �� ����
//					- �����ð����� ����(��û����)�� ���� ������� ���� ��ü�� �Ҹ� ����
//3.�������ؽ�Ʈ��ü(ServlerContext) : �����ø����̼� ��ü�� 1���� ����, �����ø����̼� ���� �� ��� ����
//					- ��� ����ڰ� ����
//(4) PageContext ��ü : JSP ���� 1������ 1���� ���� ����, �ش� JSP ������ ������ �Ҹ� 
//					- ������ �ƴ� JSP ���� ��� ����
//(5) ��Ű : ������� ���������� �����Ű��, ��û ���۽ø��� �ڵ����� ���Խ��� ����

@WebServlet("/attr.do")
public class AttrServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��û��ü�� "reqCnt"��� �̸����� ����� ���� ��������
		AtomicInteger rcnt = (AtomicInteger) req.getAttribute("reqCnt");
		if (rcnt == null) {//��û��ü�� "reqCnt"��� �̸����� ���� ������ ���� ���� ��� 
			rcnt = new AtomicInteger(0);	//0 ���� ���� ���� ��ü ����
		}
		rcnt.incrementAndGet();	//���� ���� 1����
		req.setAttribute("reqCnt", rcnt);	//��û��ü�� "reqCnt"��� �̸����� ����� ���� �����ϱ�
		
		HttpSession session = req.getSession();	//���� ��û�� ���� ���� ��ü ��������
		//���ǰ�ü�� "sesCnt"��� �̸����� ����� ���� ��������
		AtomicInteger scnt = (AtomicInteger) session.getAttribute("sesCnt");
		if (scnt == null) {//���ǰ�ü�� "sesCnt"��� �̸����� ���� ������ ���� ���� ��� 
			scnt = new AtomicInteger(0);	//0 ���� ���� ���� ��ü ����
		}
		scnt.incrementAndGet();	//���� ���� 1����
		session.setAttribute("sesCnt", scnt);	//���ǰ�ü�� "sesCnt"��� �̸����� scnt ���� ����
		
		//���� �����ø����̼��� �������ؽ�Ʈ ��ü ��������
		ServletContext context = req.getServletContext();
//		ServletContext sc = this.getServletContext();  �� �� �ϳ� ����
		//�������ؽ�Ʈ��ü�� "conCnt"��� �̸����� ����� ���� ��������
		AtomicInteger ccnt = (AtomicInteger) context.getAttribute("conCnt");
		if (ccnt == null) {//��û��ü�� "conCnt"��� �̸����� ���� ������ ���� ���� ��� 
			ccnt = new AtomicInteger(0);	//0 ���� ���� ���� ��ü ����
		}
		ccnt.incrementAndGet();	//���� ���� 1����
		context.setAttribute("conCnt", ccnt);	//���ǰ�ü�� "cesCnt"��� �̸����� ccnt ���� ����
		
		PrintWriter out = resp.getWriter();
		out.print(" request Cnt : " + rcnt );
		out.print(" session Cnt : " + scnt );
		out.print(" servlet context Cnt : " + ccnt );
		
	}
}
