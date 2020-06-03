<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!   
	{
	try {
		Class.forName("oracle.jdbc.OracleDriver"); //web-inf/lib에 .jbdc를 추가해야함. 
	} catch (ClassNotFoundException e) {
				
	e.printStackTrace();
			}
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user ="com";
		String password = "com01"; 
 %>
 
 <%
		request.setCharacterEncoding("UTF-8");	


//	String delId = req.getParameter("memId");
									
	{			
		String sql = "Delete from student where stu_no = ?";
		String delId = request.getParameter("stuNO");
	
try (
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
					
	) {
		pstmt.setString(1,delId); //?에 채워넣음
		int num= pstmt.executeUpdate();
		System.out.println("1명의 회원삭제");

	} catch (SQLException e) {
	e.printStackTrace();
	} 
	}
	
	response.sendRedirect(request.getContextPath()+ "/Student/StudentList.jsp");
	
%> 		