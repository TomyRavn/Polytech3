package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/addform.do")
public class StudentAddFormServlet extends HttpServlet {
	

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	req.getRequestDispatcher("/META-INF/jsp/student/stuAddForm.jsp").forward(req, resp);
}
}

