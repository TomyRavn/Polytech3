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
   

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      
//      String stuNo = req.getParameter("stu_no");
//      String stuName = req.getParameter("stu_name");
//      int stuScore = Integer.parseInt(req.getParameter("stu_score"));
      
      StudentVo vo = new StudentVo();
      vo.setStuNo(req.getParameter("stu_no"));
      vo.setStuName(req.getParameter("stu_name"));
      vo.setStuScore(Integer.parseInt(req.getParameter("stu_score")));
      
      StudentDaoJdbc studentDao = new StudentDaoJdbc();
      int num = studentDao.updateStudentVo(vo);

      System.out.println(num + "개의 레코드 추가");
      
      resp.sendRedirect(req.getContextPath() + "/student/list.do");
      
   }

}