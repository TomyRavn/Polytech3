package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.student.StudentVo;

@WebServlet ("/student/list.do")
public class StudentListServlet extends HttpServlet {
   
   private StudentService studentService = new StudentServiceImpl();
 
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<StudentVo> list = studentService.selectStudentList();
      
      req.setAttribute("stuList", list);
   
      req.getRequestDispatcher("/WEB-INF/jsp/Student/StudentList.jsp").forward(req, resp);
   }
}