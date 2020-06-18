package kr.ac.kopo.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/edit.do")
public class StudentEditServlet extends HttpServlet{
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
    String No = req.getParameter("stu_no");
	StudentVo vo = studentDao.selectStudent(No);
	
	req.setAttribute("stuVo", vo);
	
	req.getRequestDispatcher("/WEB-INF/jsp/student/stuEditForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		StudentVo vo = new StudentVo();
		vo.setStuNo(req.getParameter("stu_no"));
		vo.setStuName(req.getParameter("stu_name"));
		vo.setStuScore(Integer.parseInt(req.getParameter("stu_score")));
	
		int num = studentDao.updateStudentVo(vo);

		System.out.println(num + "개의 레코드 추가");
		
		resp.sendRedirect(req.getContextPath() + "/student/List.do");
		
	}

}





//package kr.ac.kopo.student;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
////브라우저 주소창에
////http://localhost:8000/exweb/student/edit.do?stuno=a001
////를 입력하고 엔터키를 입력하면,
////브라우저 화면에 학생 정보를 입력할 수 있는 폼과 입력 엘리먼트를 출력하고,
////데이터 베이스에서 아이디가 'a001'인 학생의 정보를 조회하여
////그 정보를 입력 엘리먼트들에 현재 값으로 출력
//@WebServlet("/student/edit.do")
//public class StudentEditServlet00 extends HttpServlet{
//	StudentDaoJdbc00 studentDao = new StudentDaoJdbc00();
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String no = req.getParameter("stuNo");
//		StudentVo00 vo = studentDao.selectStudent(no);
//		
//		req.setAttribute("stuVo", vo);
//		
//		req.getRequestDispatcher("/WEB-INF/jsp/student/stuEditForm.jsp").forward(req, resp);
//		
//	}
//	
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//
//		StudentVo00 vo = new StudentVo00();
//		vo.setStuNo( req.getParameter("stuNo"));
//		vo.setStuName( req.getParameter("stuName"));
//		vo.setStuScore( Integer.parseInt(req.getParameter("stuScore")));
//		
//		
//		int num = studentDao.updateStudent(vo);
//		
//		System.out.println(num + "명의 학생 추가");
//		resp.sendRedirect(req.getContextPath() + "/student/List.do");
//	}
//}
