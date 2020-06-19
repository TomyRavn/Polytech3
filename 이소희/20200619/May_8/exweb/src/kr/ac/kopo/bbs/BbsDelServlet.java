package kr.ac.kopo.bbs;

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


@WebServlet("/bbs/del.do")
public class BbsDelServlet extends HttpServlet {
	BbsDao bbsDao = new BbsDaoBatis();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	int no = Integer.parseInt(req.getParameter("bbsNo"));	
	int num = bbsDao.deleteBbs(no);
	resp.sendRedirect(req.getContextPath() + "/bbs/list.do");

	}

}



