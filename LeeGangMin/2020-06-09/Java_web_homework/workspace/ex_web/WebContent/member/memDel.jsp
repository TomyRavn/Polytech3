<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

	String sql = "DELETE FROM member WHERE mem_id = ?";
	String memId = request.getParameter("memId");

	try (Connection conn = DriverManager.getConnection(url, user, password);
	PreparedStatement pstmt = conn.prepareStatement(sql);) {

		pstmt.setString(1, memId);
		pstmt.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}

	response.sendRedirect(request.getContextPath() + "/member/memList.jsp");
%>