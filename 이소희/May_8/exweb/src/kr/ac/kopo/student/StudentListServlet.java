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

@WebServlet ("/student/list.do")
public class StudentListServlet extends HttpServlet {
	
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ArrayList<StudentVo> list = studentDao.selectStudentList();
		
		req.setAttribute("stuList", list);
	
		req.getRequestDispatcher("/META-INF/jsp/student/stuList.jsp").forward(req, resp);
	}
}

