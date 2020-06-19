package kr.ac.kopo.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

//1. ȸ���߰� ��ɵ� �α��� ���� ��� �����ϵ��� ����
//2. �α��� �� �� ��쿡��, [�α���][ȸ������]�޴��� ������,
// �α��� �� ��쿡��, [ȸ������][�Խ���][�л�����][�α׾ƿ�]�޴��� �������� menu.jsp�� ����
//3. �Խ��ǿ� �� ���� �� ��쿡 
// �α����� ����� ���̵� �ڵ����� ���ۼ��ڷ� ����ǵ��� ����

// ����(Filter) : ������ �ּҷ� ��û�� ���� ��, ������ ���� ���� �Ŀ� ����Ǵ� ��ü
//	- ���� �����鿡�� ���������� �����ؾ� �ϴ� ��ó��/��ó�� �۾� ������ ���
//	- ��Ϲ��
//		(1) @WebFilter("��û�ּ�") �� ���� Ŭ������ �����Ͽ� ���
//		(2) web.xml �������Ͽ� ���

@WebFilter("/*")
public class LoginFilter implements Filter{
	private ArrayList<String> whiteList= new ArrayList<String>();
	//private�� �Ⱥٿ����ȴ�.
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init. ���� ��ü�� ó�� ������ �� , 1���� ����
		System.out.println("LogFilter�� init����!");
		
		whiteList.add("/member/Login.do");
		whiteList.add("/member/add.do");
//		<String>�� �� �ּҸ� ��´�.
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// doFilter �� ���Ϳ� ������ �ּҷ� ��û�� �ö����� 1���� ����
		System.out.println("LoginFilter�� doFilter ����!");
		
		//���� ���� �Ǵ� ���� ���� ���� ������ �۾���
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println( req.getRequestURI() );
		//RequestURI���� ContextPath�� ������ �޺κ��� ��θ� ����
		
//		req.getRequestURI().substring( 6 );
//		req.getRequestURI().substring( "/exweb".length() );
//		req.getRequestURI().substring( req.getRequestURI().length() );
//		substring()�� ()���� ���ڸ�ŭ �����ش�. �� �� �� �Ʒ� ���� ���� �� ���� ȿ����(�ٸ� �� �ڵ� ����� �����ؾ� �ϴϱ�)
		String reqPath = req.getRequestURI().substring( req.getContextPath().length() );
		
//		whiteList.contains( req.getRequestURI() );
		//getRequestURI()�ȿ��� req.getContextPath()�� ���ԵǾ� �ִ�.
//		whiteList.contains( "/exweb/member/Login.do" );

//		if ( req.getRequestURI().equals(req.getContextPath()+"/member/Login.do") == false 
//				&& !req.getRequestURI().equals(req.getContextPath()+"/member/add.do")) {
//			//�α��� �˻� ���� (�� �� �ƴ� �� �˻��ؾ� �ϴϱ� &&�� ���´�.)
		if ( whiteList.contains( reqPath ) == false ) { //��û�ּҰ� whiteList�� ���� ���
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
			
		}
		
		//������ ����� ���� �Ǵ� ������ �����Ű��� ���
		
		chain.doFilter(request, response);
		//���� ���� �Ǵ� ���� ���� ���� ������ �۾���
	}
	
	@Override
	public void destroy() {
		// ���� ��ü�� �Ҹ�Ǳ� ���� 1���� ����
	}
}
