package kr.ac.kopo.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//처음 생성됐을 때 한번만 실행하기 위한 용도
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//오라클 JDBC 드라이버 클래스를 메모리에 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}