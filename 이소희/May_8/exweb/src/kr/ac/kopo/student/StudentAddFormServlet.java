package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/addform.do")
public class StudentAddFormServlet extends HttpServlet {
	

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	resp.setContentType("text/html");
	resp.setCharacterEncoding("UTF-8");
	PrintWriter out = resp.getWriter();
	
	
	out.println("<!DOCTYPE html>                  ");
	out.println("<html>                           ");
	out.println("<head>                           ");
	out.println("<meta charset='UTF-8'>           ");
	out.println("<title>학생 관리</title>");
	out.println("</head>                          ");
	out.println("<body>                           ");
	
	
	out.println("	<h1>학생 추가</h1>   ");
	
	out.println("		<form action='" + req.getContextPath() + "/student/add.do' method='post'> ");
	out.println("		학번: <input text='text' name='stu_no'/><br/>                       ");
	out.println("		이름: <input text='text' name='stu_name'/><br/>                       ");
	out.println("		점수: <input text='text' name='stu_score'/><br/>                        ");
	out.println("		<input type='submit' value='저장' />                                        ");
	out.println("</form> ");
	
	out.println("</body>                          ");
	out.println("</html>                          ");
}
}

