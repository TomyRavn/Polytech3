package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.student.StudentVo;

@WebServlet ("/student/List.do")
public class StudentListServlet extends HttpServlet {
	
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ArrayList<StudentVo> list = studentDao.selectStudentList();
		
		req.setAttribute("stuList", list);
	
		req.getRequestDispatcher("/WEB-INF/jsp/student/stuList.jsp").forward(req, resp);
	}
}





//package kr.ac.kopo.student;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.exam.HelloServlet;
//
//@WebServlet("/student/List.do")
//public class StudentListServlet00 extends HttpServlet{
//
//	StudentDaoJdbc00 studentDao = new StudentDaoJdbc00();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ArrayList<StudentVo00> list = studentDao.selectStudentList();
//		
//		req.setAttribute("stuList", list);
//
//		req.getRequestDispatcher("/WEB-INF/jsp/student/stuList.jsp").forward(req, resp);
//
//	}
//}
//
//
//
////	/*1. 브라우저 주소창이 http://localhost:8000/exweb/student/List.do 
////	 * 를 입력하여 접속(요청전송)하면, 브라우저 화면에 학생목록(학번, 이름)이 출력되도록 구현. 
////	 * 2. 학생목록 화면에 "학생추가" 링크를 추가하고, 그 링크를 클릭하면 
////	 * http://localhost:8000/exweb/student/addform.do 로 이동하여,
////	 * 학생의 학번,이름,성적을 입력할 수 있는 입력엘리먼트들을 출력
////	 * (학번,이름,성적 파라미커 이름은 stuNo,stuName,stuScore 로 설정)
////	 * 2-1. 저장 버튼을 클릭하면
////	 * http://localhost:8000/exweb/student/add.do 로 이동하여,
////	 * 입력한 학생 정보를 데이터베이스에 저장하고 학생목록 화면으로 이동
////	 * 3. 학생목록화면에서 각 학생들의 학번을 클릭하면,
////	 * http://localhost:8000/exweb/student/editform.do 로 이동하여,
////	 * 해당 학생의 학번,이름,성적을 입력할 수 있는 입력엘리먼트들을 출력
////	 * (입력엘리먼트에는 해당 학생의 현재 학번,이름,성적을 출력)
////	 * 3-1.저장 버튼을 클릭하면
////	 * http://localhost:8000/exweb/student/del.do 로 이동하여,
////	 * 데이터베이스에서 해당 학생을 삭제하고,
////	 * 브라우저 화면에 학생목록이 출력*/