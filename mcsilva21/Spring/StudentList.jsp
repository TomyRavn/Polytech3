<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
	String user ="com";
	String password = "com01"; 
%>	
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		<title>학생관리</title>
		</head>
		<body>
		
		
		<h1>학생목록</h1>
		<a href= '<%=request.getContextPath()%>/Student/StudentAddForm.jsp'>학생가입</a></br>
			
			<table border=1; width=300px;>
			<tr align='center'>
			<td align='center'>학번</td>
			<td align='center'>이름</td>
			</tr>			

<%						
		{
		String sql = "SELECT stu_no,stu_name,stu_score FROM student";
					
		try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			) {
			
			while (rs.next()) {
				
				String stuNO = rs.getString("stu_no"); 	
				String stuName = rs.getString("stu_name"); 		 
				int stuScore = rs.getInt("stu_score");
								
 %>				
			<tr>
			<td align='center'><%=stuNO%></td>
			<td align='center'><%=stuName%></td>
			</tr>
		
						
			<a href='<%=request.getContextPath()%>/Student/StudentEditForm.jsp?stuNO=<%=stuNO%>'><%=stuNO%></a>			
			<%=stuNO%> : <%=stuName%> : <%=stuScore%>
		
			</br>
<%					
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}%>					
		</body>
		</html>
				
    