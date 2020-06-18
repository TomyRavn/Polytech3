package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/student/add.do")
public class StudentAddServlet extends HttpServlet{
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.getRequestDispatcher("/WEB-INF/jsp/student/stuAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");	
		
		StudentVo vo = new StudentVo();		
		vo.setStuNo(req.getParameter("stu_no"));
		vo.setStuName(req.getParameter("stu_name"));
		vo.setStuScore(Integer.parseInt(req.getParameter("stu_score")));			
		int num = studentDao.insertStudent(vo);
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
//
//import kr.ac.kopo.member.MemberVo;
//
//@WebServlet("/student/add.do")
//public class StudentAddServlet00 extends HttpServlet{
//	StudentDaoJdbc00 studentDao = new StudentDaoJdbc00();
//
//@Override
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	req.getRequestDispatcher("/WEB-INF/jsp/student/stuAddForm.jsp").forward(req, resp);
//	}
//	
//@Override
//protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	req.setCharacterEncoding("UTF-8");
//	
//	StudentVo00 vo = new StudentVo00();
//	vo.setStuNo( req.getParameter("stuNo")); 
//	vo.setStuName( req.getParameter("stuName")); 
//	vo.setStuScore( Integer.parseInt(req.getParameter("stuScore")));
//		
//	int num = studentDao.insertStudent( vo );
//	System.out.println(num + "명의 회원 추가");
//	resp.sendRedirect(req.getContextPath() + "/student/List.do");
//			
//		}
//		
//}
//
