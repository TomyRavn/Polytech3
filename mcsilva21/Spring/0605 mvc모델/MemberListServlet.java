package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet {

	MemberDaojdbc memberDao = new MemberDaojdbc();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		//req:요청객체 resp:응답개체
		ArrayList<MemberVo>list = memberDao.selectMemberList(); //db작업후 
		
		req.setAttribute("memList", list); //요청객체에 ""라는 이름으로 list 데이터를 저장
		
		//"/WEB-INF/jsp/member/memList.jsp"파일로 이동
		//데이터베이스는 dao 출력은 jsp로 분할
		
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp");
//		//현재 요청을 위임하여 처리할 수 있도록하는 디스패치 가져오기
//		rd.forward(req, resp);//현재 요청객체와 응답객체를 전달해주면서 이동
		req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp").forward(req, resp);//jsp로이동
}
}
