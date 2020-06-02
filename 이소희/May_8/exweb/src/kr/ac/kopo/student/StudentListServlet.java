package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/student/list.do")
public class StudentListServlet extends HttpServlet {
//	1. 브라우저 주소창에
//	http://localhost:8000/exweb/student/list.do
//	를 입력하여 접속(요청 전송)하면.
//	브라우저 화면에 "학생추가"링크를 추가하고,
//	그 링크를 클릭하면,
//	http://localhost:8000/exweb/student/addform.do
//	로 이동하여,
//	학생의 학번, 이름 성적을 입력할 수 있는 입력 엘리먼트들을 추력
//	(학번, 이름, 성적, 파라미터 이름은 stuNo stuName, stuScore로 설정
//	2-1저장 버튼을 클릭하면
//	http://localhost:8000/exweb/student/add.do
//	로 디오하여, 입력한 학생 정보를 데이터베이스에 저장하고
//	학생목록 화면으로 이동
//	3.학생 목록 화면에서 각 학생들의 학번을 클릭하면,
//	http://localhost:8000/exweb/student/editform.do
//	로 이동하여,
//	해당 학생의 학번, 이름, 성적을 입력할 수 있는 입력 엘리먼트들을 출력
//	(입력 엘리먼트에는 해당 학생의 현재 학번, 이름, 성적을 출력)
//	3-1 저장 버튼을 클릭하면
//	http://localhost:8000/exweb/student/edit.do
//	로 이동하여, 입력한 학생 정보를 데이터베이스에 저장하고
//	학생목록 화면으로 이동
//	3-2 삭제 버튼을 클릭하면
//	http://localhost:8000/exweb/student/del.do
//	로 이동하여 데이터베이스에서 해당 학생을 삭제하고,
//	브라우저 화면에 학생목록을 출력.
	

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
		out.println("	<h1>학생 목록</h1>   ");
		out.println("<a href='" + req.getContextPath() + "/student/addform.do'>학생 추가</a><br / >");
		{
		String sql = "SELECT stu_no, stu_name, stu_score FROM student";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

		while (rs.next()) {
			String stuNo = rs.getString("stu_no");
			String stuName = rs.getString("stu_name");
			int stuScore = rs.getInt("stu_score");	
//			out.println(stuNo + " : " + stuName + " : " + stuScore);
			out.println("<a href='" + req.getContextPath() + "/student/editform.do?stu_no="+stuNo+"'> " + stuNo + " </a>"+":"+stuNo+":"+stuName+":"+stuScore);
			  out.println("<a href='" + req.getContextPath() + "/student/del.do?stu_no="+stuNo+"'><button>삭제</button></a></br>");
			  
			  
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		
		out.println("</body>                          ");
		out.println("</html>                          ");
	}

}

