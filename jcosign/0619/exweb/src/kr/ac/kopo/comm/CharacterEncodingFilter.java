package kr.ac.kopo.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	
	private String enc;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		enc = filterConfig.getInitParameter("encoding");
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(enc);	//POST��� �ѱ� �Ķ���� ���� ���ؼ�
		
		chain.doFilter(request, response);  //���� ����� ���� �Ǵ� ������ ����
		
	}

}