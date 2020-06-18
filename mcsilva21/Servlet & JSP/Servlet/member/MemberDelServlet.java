package kr.ac.kopo.member;

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


@WebServlet("/member/del.do")
public class MemberDelServlet extends HttpServlet {
	MemberDaojdbc memberDao = new MemberDaojdbc(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String delId = req.getParameter("memId");											
	int num = memberDao.delMember(delId); 
	System.out.println(num+"명의 회원삭제");	
	resp.sendRedirect(req.getContextPath()+ "/member/list.do");	
}
	//주소,링크.리다이렉트는 get방식
}	



	


