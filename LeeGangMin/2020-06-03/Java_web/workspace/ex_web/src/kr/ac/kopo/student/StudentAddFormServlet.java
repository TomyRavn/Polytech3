package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/addform.do")
public class StudentAddFormServlet extends HttpServlet{
	
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>학생관리</title> ");
		out.println("<style>");
		out.println(".accept{ float : right }");
		out.println("</style>");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>학생추가</h1>     ");

		out.println("<form action=\"" + req.getContextPath() + "/student/add.do\" method=\"post\">");
		out.println("학번을 입력하세요 : <input type=\"text\" name=\"stuNo\" /></br></br>");
		
		out.println("이름을 입력하세요 : <input type=\"text\" name=\"stuName\" /></br></br>");

		out.println("성적을 입력하세요 : <input type=\"text\" name=\"stuScore\" /></br></br>");
		out.println("<input class=\"accept\" type=\"submit\" value=\"저장\" />");
		out.println("</form>");
		out.println("</br>");
		out.println("</br>");
		
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}
}