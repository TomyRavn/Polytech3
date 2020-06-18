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

		System.out.println(num + "���� ���ڵ� �߰�");
		
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
////������ �ּ�â��
////http://localhost:8000/exweb/student/edit.do?stuno=a001
////�� �Է��ϰ� ����Ű�� �Է��ϸ�,
////������ ȭ�鿡 �л� ������ �Է��� �� �ִ� ���� �Է� ������Ʈ�� ����ϰ�,
////������ ���̽����� ���̵� 'a001'�� �л��� ������ ��ȸ�Ͽ�
////�� ������ �Է� ������Ʈ�鿡 ���� ������ ���
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
//		System.out.println(num + "���� �л� �߰�");
//		resp.sendRedirect(req.getContextPath() + "/student/List.do");
//	}
//}
