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

//브라우저 주소창에
//http://localhost:8000/exweb/member/editform.do?memId=a001
//를 입력하고 엔터키를 입력하면,
//브라우저 화면에 회원정보를 입력할 수 있는 폼과 입력엘리먼트를 출력하고.
//데이터베이스에서 아이디가 'a001'인 회원정보를 조회하여
//그정보를 입력엘리먼트에 현재값으로 출력
	
	@WebServlet("/member/editform.do")
	public class MemberEditFormServlet extends HttpServlet{
		{
		try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
		}
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user ="com";
		String password = "com01"; 
		
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//form이 그대로 출력해야 하니 복붙	
			resp.setContentType("text/html"); 	
			resp.setCharacterEncoding("UTF-8"); 
			PrintWriter out = resp.getWriter(); 
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head> ");
			out.println("<meta charset='UTF-8'> ");
			out.println("<title>회원관리</title> ");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>회원 정보 변경</h1>");

			String no =req.getParameter("memId");

			String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id = ?";

			try (
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					)
			{				
				pstmt.setString(1, no);
				try (ResultSet rs = pstmt.executeQuery(); )
				{
					if (rs.next()) {
						String memID = rs.getString("mem_id");
						String memPass = rs.getString("mem_pass");
						String memName = rs.getString("mem_name");											
						int memPoint = rs.getInt("mem_point");	
						
						out.println("<form action='" + req.getContextPath() + "/member/edit.do' method='post'>"); 
						out.println("아아디:<input type='text'name='memId'value='" + memID + "'readonly /><br/> "); 
						//파라미터 값을 지정해줌 
						//readonly:제출입력을 눌렀을때 파라미터 값이 출력
						//disabled:아예블럭처리.
//						out.println("비밀번호:<input type='text' name='memPass' value='" +memPass + "'/><br/>") ;  
						out.println("이름:<input type='text' name='memName' value='" +memName + "'/><br/>") ;  
						out.println("포인트:<input type='text' name='memPoint' value='" + memPoint + "'/><br/>") ;  	
						out.println("<input type='submit' value='저장'/><br/>");
						out.println("<form/>");											
					}
	
			} 
				}
				catch (SQLException e) {
				e.printStackTrace();
			}
							
			out.println("</body>");
			out.println("</html>");
			
			}
			
		
		
		
	
			
	}
	
	
			
			
	
