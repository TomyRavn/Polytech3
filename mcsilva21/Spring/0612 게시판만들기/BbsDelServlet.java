package kr.ac.kopo.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bbs/del.do")
public class BbsDelServlet extends HttpServlet {
	BbsDaojdbc bbsDao = new BbsDaojdbc(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int delNo = Integer.parseInt(req.getParameter("bbsNo"));											
	int num = bbsDao.delBbs(delNo); 
	System.out.println(num+"명의 회원삭제");	
	resp.sendRedirect(req.getContextPath()+ "/bbs/list.do");	
}
	//주소,링크.리다이렉트는 get방식
}	



	


