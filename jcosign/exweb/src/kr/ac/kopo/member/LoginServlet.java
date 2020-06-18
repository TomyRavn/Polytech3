package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1. "/member/login.do"�� GET��� ��û�� ������
//		/WEB-INF/jsp/member/login.jsp �� �̵�(forward)�Ͽ�
//		���̵�� ��й�ȣ�� �Է��� �� �ִ� ȭ���� Ŭ��
//2. ���̵�� ��й�ȣ�� �Է��ϰ� �α��� ��ư�� Ŭ���ϸ�
//		"/member/login.do"�� POST��� ��û�� �����ϰ�,
//		�Է��� ���̵�� ��й�ȣ�� ȸ���� ������ member ���̺��� ��ȸ�ϰ�
//		�׷� ȸ���� ������ "login success" ����ϰ�,
//		�׷� ȸ���� ������ "login fail"��� ���

@WebServlet("/member/Login.do")
// login�� �ҹ��ڷ� ���� �α��� ȭ���� �ȵǰ�, �빮�ڷ� ���� �� ���� ȭ���� �ȵ�.
//	�� �ּҿ� login.jsp�� �ּҰ� �����ϰ�

public class LoginServlet extends HttpServlet{
	private MemberDaoJdbc MemberDao = new MemberDaoJdbc();
//	private�� �ٿ��� �ǰ� �Ⱥٿ��� �ȴ�.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		MemberVo loginVo = MemberDao.selectLoginMember( vo );
		
		//�α��� ������, ȸ��������� �̵�
		//�α��� ���н�, �ٽ� �α��� ȭ������ �̵�
		PrintWriter out = resp.getWriter();
		
		if (loginVo == null) { //�α��� ����(�Է��� ID/PW�� ��ġ�ϴ� ȸ���� ���� ���)
			resp.sendRedirect(req.getContextPath() + "/member/Login.do");
			
		}else { //�α��� ����(�Է��� ID/PW�� ��ġ�ϴ� ȸ���� �ִ� ���)
			HttpSession session = req.getSession(); //�����û�� ���� ���ǰ�ü ��������
			session.setAttribute("loginUser", loginVo);	//�α��λ���� ������ ��� ��ü�� "loginUser"��� �̸����� ���ǿ� ����
			
			resp.sendRedirect(req.getContextPath() + "/member/List.do");
			
		}
		
		
	}
	
}
