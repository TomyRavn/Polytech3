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
public class BbsDelServlet extends HttpServlet{
	
	BbsDao bbsDao = new BbsDaoBatis();
	
	//리팩토링 : 코드가 하는 일은 똑같이 두면서, 코드를 더 효율적으로 개선하는 것
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		int delNo = Integer.parseInt(req.getParameter("bbsNo"));
		
		bbsDao.deleteBbs(delNo);
		
		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
	
	}

	//alt + shift + r 로 같은 값 해당 메소드 내 전체 변경
	
}