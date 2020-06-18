<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
	<h1>회원추가</h1>
	
	<a href='<%= request.getContextPath() %>/member/memAddForm.jsp'>추가</a><br />
	
<%
			String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
			try(
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);	
					ResultSet rs = pstmt.executeQuery(); 
					)
					{
						while (rs.next()) {
							String memId = rs.getString("mem_id"); 
							String memPass = rs.getString("mem_pass"); 
							String memName = rs.getString("mem_name"); 
							int memPoint = rs.getInt("mem_point"); 
%>							
							<a href='<%= request.getContextPath() %>/member/memEditForm.jsp?memId=<%=memId%>'><%=memId%></a>
							: <%= memPass %> : <%= memName %> : <%= memPoint %>
							<br/>
<%							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
 %>
</body> 
</html>