<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
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
%>
<%
request.setCharacterEncoding("UTF-8");


{
	String sql = "DELETE FROM student WHERE stu_no = ?";		
	String stuno = request.getParameter("stuNo");	
	try(
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			){
		pstmt.setString(1, stuno);
		int num = pstmt.executeUpdate();
		System.out.println(num + "명의 회원 삭제");
	} catch(SQLException e) {
		e.printStackTrace();
	}
	response.sendRedirect(request.getContextPath() + "/student/stuList.jsp");
}

%>