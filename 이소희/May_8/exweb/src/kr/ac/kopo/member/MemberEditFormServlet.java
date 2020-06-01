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
//http://localhost:8000/exweb/member/edit.do?memId=a001
//를 입력하고 엔터키를 입력하면,
//브라우저 화면에 회원 정보를 입력할 수 있는 폼과 입력 엘리먼트를 출력하고,
//데이터 베이스에서 아이디가 'a001'인 회원의 정보를 조회하여
//그 정보를 입력 엘리먼트들에 현재 값으로 출력

//a001 같은 아이디 값은 변경할 수 없다.

@WebServlet("/member/editform.do")
public class MemberEditFormServlet extends HttpServlet {
	{
	try {
		Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";
	

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	
	
	resp.setContentType("text/html");
	resp.setCharacterEncoding("UTF-8");
	PrintWriter out = resp.getWriter();
	
	out.println("<!DOCTYPE html>                  ");
	out.println("<html>                           ");
	out.println("<head>                           ");
	out.println("<meta charset='UTF-8'>           ");
	out.println("<title>회원 관리</title>");
	out.println("</head>                          ");
	out.println("<body>                           ");
	ut.println("<a href='" + req.getContextPath() + "/member/del.do?memId=" + memId + "'><button> 삭제 </button></a><br / >");	
	
	out.println("	<h1>회원 정보 수정</h1>   ");
	
    String No = req.getParameter("memId");
    
    
    String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id = ?";
   
    try (
          Connection conn = DriverManager.getConnection(url, user, password);
          PreparedStatement pstmt = conn.prepareStatement(sql);				            						            	 
          ) 
    		{
    	 	pstmt.setString(1, No); //No 값을 첫 번째 물음표에 채워라.		                
         	try (ResultSet rs = pstmt.executeQuery();) //실행결과 레코드들을 가리키고 있는 resultset 값 반환			                 	
         		{ 	
         		if(rs.next()) {
         		String MemId = rs.getString("mem_id");
         		String MemPass = rs.getString("mem_pass");
         		String MemName = rs.getString("mem_name");
         		int MemPoint = rs.getInt("mem_point");
         		
         		out.println("		<form action='" + req.getContextPath() + "/member/edit.do' method='post'> ");
         		//disabled 는 전송이 안 됨! readonly는 전송이 됨!
         		out.println("		아이디: <input text='text' name='memId' value='" + MemId + "' readonly /><br/>                       ");
//         		out.println("		비밀번호: <input text='text' name='memPw'value='" + MemPass + "'/><br/>                        ");
         		out.println("		이름: <input text='text' name='memName'value='" + MemName + "'/><br/>                       ");
         		out.println("		포인트: <input text='text' name='memPoint'value='" + MemPoint + "'/><br/>                        ");
         		out.println("		<input type='submit' value='저장' />                                        ");
         		out.println("</form> ");	            
               }													                	
         	   }        	
         	
    } catch (SQLException e) {
       e.printStackTrace();
    }
	

	out.println("</body>                          ");
	out.println("</html>                          ");
}
}





