
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
		
		String stuNo = request.getParameter("stu_no");
		String stuName = request.getParameter("stu_name");
		int stuScore = Integer.parseInt(request.getParameter("stu_score"));
		
		
		String sql = "UPDATE student SET stu_name = ?, stu_score=? WHERE stu_no = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
				) {		
		pstmt.setString(1, stuName); 
		pstmt.setInt(2, stuScore); 
		pstmt.setString(3, stuNo); 

		int num = pstmt.executeUpdate();
		System.out.println(num + "개의 레코드 추가");
		
		} catch (SQLException e) {
				e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/student/stuList.jsp");
		
	
%>