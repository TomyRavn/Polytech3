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


@WebServlet("/student/del.do")
public class StudentDelServlet extends HttpServlet {
	StudentDaoJdbc studentDao = new StudentDaoJdbc();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {

	
	String delNo = req.getParameter("stu_no");	
	int num = studentDao.deleteStudent(delNo); 
	System.out.println(num + "���� �л� ����");
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
//@WebServlet("/student/del.do")
//public class StudentDelServlet00 extends HttpServlet {
//	StudentDaoJdbc00 studentDao = new StudentDaoJdbc00();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.print("������ �л��� ���̵� �Է��ϼ���.\n");
//		String delid = req.getParameter("stuNo");
//
//		int num = studentDao.deletStudent(delid);
//		System.out.println(num + "���� �л� ����");
//		resp.sendRedirect(req.getContextPath() + "/student/List.do");
//
//	}
//}
