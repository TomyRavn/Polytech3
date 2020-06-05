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

//브라우저 주소창에
//localhost:8000/ex_web/student/list.do를 입력하여 접속하면
//브라우저 화면에 학생목록(학번, 이름)이 출력되도록 구현

//학생 목록 화면에 "학생추가"링크를 추가하고, 그 링크를 클릭하면
//localhost:8000/ex_web/student/addform.do로 이동하여
//학생의 학번,이름,성적을 입력할 수 있는 입력엘리먼트들을 출력

//(학번, 이름, 성적 파라미터 이름은 stuNo, stuName, stuScore로 설정
//저장 버튼을 클릭하면
//localhost:8000/ex_web/student/add.do로 이동하여
//입력한 학생 정보를 데이터베이스에 저장하고 학생목록 화면으로 이동

//학생 목록 화면에서 그 학생들의 학번을 클릭하면
//localhost:8000/ex_web/student/editform.do로 이동하여,
//해당 학생의 학번, 이름, 성적을 입력할 수 있는 입력엘리먼트들을 출력

///입력엘리먼트에는 해당 학생의 현재 학번,이름, 성적을 출력
//저장버튼을 클릭하면 localhost:8000/ex_web/student/edit.do로 이동하여 데이터베이스에서
//해당 학생의 이름과 성적을 변경하고 학생목록 화면으로 이동

//삭제 버튼을 클릭하면
//localhost:8000/ex_web/student/del.do로 이동하여
//데이터베이스에서 해당 학생을 삭제하고 브라우저 화면에 학생목록이 출력

@WebServlet("/student/list.do")
public class StudentListServlet extends HttpServlet{
	
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
		
		String sql = "SELECT stu_no, stu_name, stu_score FROM student";
		
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset='UTF-8'>           ");
		out.println("<title>학생관리</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("	<h1>학생목록</h1>     ");
		
		out.println("<a href=\"" + req.getContextPath() + "/student/addform.do\" ><button>학생추가</button></a></br></br>");
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) {
			
			while(rs.next()) {
				String stuNo = rs.getString("stu_no");
				String stuName = rs.getString("stu_name");
				int stuScore = rs.getInt("stu_score");

				out.println("<a href=\"" + req.getContextPath() + "/student/editform.do?stuNo=" + stuNo + "\">" + stuNo + "</a> : " + stuName + " : " + stuScore);
				out.println(" <a href=\"" + req.getContextPath() + "/student/del.do?stuNo=" + stuNo + "\"><button>삭제</button></a> <br/>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("</body>                          ");
		out.println("</html>                          ");
		
	}
	
}