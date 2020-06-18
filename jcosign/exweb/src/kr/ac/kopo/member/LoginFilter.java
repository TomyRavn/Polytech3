package kr.ac.kopo.member;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1. ȸ���߰� ��ɵ� �α��� ���� ��� �����ϵ��� ����
//2. �α��� �� �� ��쿡��, [�α���] [ȸ������] �޴��� ������,
// �α��� �� ��쿡��, [ȸ������][�Խ���][�л�����][�α׾ƿ�]�޴��� �������� menu.jsp�� ����
//3. �Խ��ǿ� �� ���� �� ��쿡 
// �α����� ����� ���̵� �ڵ����� ���ۼ��ڷ� ����ǵ��� ����

// ����(Filter) : ������ �ּҷ� ��û�� ���� ��, ������ ���� ���� �Ŀ� ����Ǵ� ��ü
@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter�� doFilter ����!");
		//���� ���� �Ǵ� ���� ���� ���� ������ �۾���
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println( req.getRequestURI());

		if ( req.getRequestURI().equals(req.getContextPath()+"/member/Login.do") == false 
				&& !req.getRequestURI().equals(req.getContextPath()+"/member/add.do")) {
			//�α��� �˻� ����
			HttpSession session = req.getSession();
			MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");
			if ( loginVo == null ) { //�α������� ���� ���
				resp.sendRedirect(req.getContextPath()+"/member/Login.do");	//�α���ȭ������ �̵�
				return;
			}

			//		System.out.println( req.getRequestURL());

			//		HttpSession session = req.getSession();
			//		MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");
			//		if ( loginVo == null ) { //�α������� ���� ���
			//			//�α���ȭ������ �̵�
			//			resp.sendRedirect(req.getContextPath()+"/member/Login.do");
			//			return;
			//		}
			//		
			//������ ����� ���� �Ǵ� ������ �����Ű��� ���
			

			//���� ���� �Ǵ� ���� ���� ���� ������ �۾���
		}
		
		chain.doFilter(request, response);
	}
}
