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
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스 주소
		String user ="com";
		String password = "com01"; 
 %> 
 		

	
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		<title>학생</title>
		</head>
		<body>
		<h1>학생 정보 변경</h1>

<%
		String no =request.getParameter("stuNO");
		String sql = "SELECT stu_no,stu_name,stu_score FROM student WHERE  stu_no = ?";

			try (
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					)
			{				
				pstmt.setString(1, no);
				try (ResultSet rs = pstmt.executeQuery(); )
				{
					if (rs.next()) {
						String stuNO = rs.getString("stu_no");
						String stuName = rs.getString("stu_name");									
						int stuScore = rs.getInt("stu_score");	
 %>							
				<form action='<%=request.getContextPath()%>/Student/StudentEdit.jsp' method='post'> 
				아아디:<input type='text'name='stuNO'value='<%=stuNO%>'readonly /><br/> 				
				이름:<input type='text' name='stuName' value='<%=stuName%>'/><br/> 
				포인트:<input type='text' name='stuScore' value='<%=stuScore%>'/><br/> 	
				<input type='submit' value='저장'/><br/>	
				</form>
				<a href='<%=request.getContextPath()%>/Student/StudentDel.jsp?stuNO=<%=stuNO%>'><button type='button'>삭제</button></a><br/>
<%
				}	

			} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
%>			
							
</body>
</html>
		