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
   
	  private StudentService studentService = new StudentServiceImpl();

	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {	      	   
	    String No = req.getParameter("stu_no");
	   StudentVo vo = studentService.selectStudent(No);	   
	   req.setAttribute("stuVo", vo);	   
	   req.getRequestDispatcher("/WEB-INF/jsp/Student/StudentEditForm.jsp").forward(req, resp);	   

	   }
	
	
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");  
      StudentVo vo = new StudentVo();
      vo.setStuNo(req.getParameter("stu_no"));
      vo.setStuName(req.getParameter("stu_name"));
      vo.setStuScore(Integer.parseInt(req.getParameter("stu_score")));          
      int num = studentService.updateStudentVo(vo);
      System.out.println(num + "개의 레코드 추가");      
      resp.sendRedirect(req.getContextPath() + "/student/list.do");
      
   }

}