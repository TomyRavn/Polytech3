package kr.ac.kopo.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/list.do")
public class StudentListServlet extends HttpServlet{
	
	
	private StudentService studentService = StudentServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<StudentVo> studentList = studentService.selectStudentList();
		req.setAttribute("stuList", studentList);
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/stuList.jsp").forward(req, resp);
		
	}
	
}