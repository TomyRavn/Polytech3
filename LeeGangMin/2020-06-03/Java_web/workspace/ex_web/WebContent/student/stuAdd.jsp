<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<!-- response의 인코딩 설정만 UTF-8로 설정해줌 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
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
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		int stuScore = Integer.parseInt(request.getParameter("stuScore"));
		
		String sql = "INSERT INTO student (stu_no, stu_name, stu_score) "
				+ "VALUES (?, ?, ?)";
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, stuNo);
			pstmt.setString(2, stuName);
			pstmt.setInt(3, stuScore);
			
			pstmt.executeUpdate(); 

			} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/student/stuList.jsp");
%>