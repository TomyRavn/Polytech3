package kr.ac.kopo.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();	//�����û�� ���� ���ǰ�ü ��������
//		session.setAttribute("loginUser", null); //���ǿ� "loginUser"��� �̸����� null�� ����
//		session.removeAttribute("loginUser"); //���ǿ� "loginUser"��� �̸����� ������ ���� ����
		session.invalidate();	//���ǰ�ü��ü�� �ʱ�ȭ(���λ���)=���ǿ� �����ߴ� ��絥���ͻ���
		
		resp.sendRedirect(req.getContextPath()+"/member/Login.do");	//�α���ȭ������ �̵�
		
	}
	
	
	
}
