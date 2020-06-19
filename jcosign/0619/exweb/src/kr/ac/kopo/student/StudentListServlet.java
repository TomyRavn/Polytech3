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
////	/*1. ������ �ּ�â�� http://localhost:8000/exweb/student/List.do 
////	 * �� �Է��Ͽ� ����(��û����)�ϸ�, ������ ȭ�鿡 �л����(�й�, �̸�)�� ��µǵ��� ����. 
////	 * 2. �л���� ȭ�鿡 "�л��߰�" ��ũ�� �߰��ϰ�, �� ��ũ�� Ŭ���ϸ� 
////	 * http://localhost:8000/exweb/student/addform.do �� �̵��Ͽ�,
////	 * �л��� �й�,�̸�,������ �Է��� �� �ִ� �Է¿�����Ʈ���� ���
////	 * (�й�,�̸�,���� �Ķ��Ŀ �̸��� stuNo,stuName,stuScore �� ����)
////	 * 2-1. ���� ��ư�� Ŭ���ϸ�
////	 * http://localhost:8000/exweb/student/add.do �� �̵��Ͽ�,
////	 * �Է��� �л� ������ �����ͺ��̽��� �����ϰ� �л���� ȭ������ �̵�
////	 * 3. �л����ȭ�鿡�� �� �л����� �й��� Ŭ���ϸ�,
////	 * http://localhost:8000/exweb/student/editform.do �� �̵��Ͽ�,
////	 * �ش� �л��� �й�,�̸�,������ �Է��� �� �ִ� �Է¿�����Ʈ���� ���
////	 * (�Է¿�����Ʈ���� �ش� �л��� ���� �й�,�̸�,������ ���)
////	 * 3-1.���� ��ư�� Ŭ���ϸ�
////	 * http://localhost:8000/exweb/student/del.do �� �̵��Ͽ�,
////	 * �����ͺ��̽����� �ش� �л��� �����ϰ�,
////	 * ������ ȭ�鿡 �л������ ���*/