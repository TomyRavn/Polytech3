package kr.ac.kopo.comm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//������(Listener) : Ư�� ���(�̺�Ʈ)�� �߻��ϸ�, �ڵ����� ����
//	- ��û��ü,���ǰ�ü,�������ؽ�Ʈ��ü�� ���� �Ǵ� �Ҹ�� ��
//	- ��û��ü,���ǰ�ü,�������ؽ�Ʈ��ü�� �Ӽ��� �߰�,����,������ ��
//	- ��Ÿ ���

//������ ��� ���
//	- (1) ������ Ŭ������ @WebListener ���
//	- (2) web.xml ���

//@WebListener
public class InitListener implements ServletContextListener{
		
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// �������ؽ�Ʈ ��ü�� ó�� ������ �� ���� = �� ���������̼��� ó�� ����� ��
		System.out.println("InitListner : contextInitialized ����!");
		
//		web.xml�� <context-param>���� ����� �ʱ�ȭ �Ķ���Ͱ� ��������
		String driver = sce.getServletContext().getInitParameter("driverClass");
		
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName( driver );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// �������ؽ�Ʈ ��ü�� ó�� �Ҹ�Ǳ� ������ ���� = �� ���������̼��� ����� ��
		System.out.println("InitListner : contextDestroyed ����!");
	}

}
