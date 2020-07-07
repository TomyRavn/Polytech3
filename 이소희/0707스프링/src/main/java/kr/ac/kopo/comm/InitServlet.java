package kr.ac.kopo.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {

		try {
			Class.forName("oracle.jdbc.OracleDriver"); // web-inf/lib에 .jbdc를 추가해야함.
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
