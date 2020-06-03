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
		<title>회원관리</title>
		</head>
		<body>
		<h1>회원 정보 변경</h1>

<%
		String no =request.getParameter("memId");
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
						 %>							
				<form action='<%=request.getContextPath()%>/member/memEdit.jsp' method='post'> 
				아아디:<input type='text'name='memId'value='<%=memID%>'readonly /><br/> 				
				이름:<input type='text' name='memName' value='<%=memName%>'/><br/> 
				포인트:<input type='text' name='memPoint' value='<%=memPoint%>'/><br/> 	
				<input type='submit' value='저장'/><br/>	
				</form>
				<a href='<%=request.getContextPath()%>/member/memDel.jsp?memId=<%=memID%>'><button type='button'>삭제</button></a><br/>
<%
				}	

			} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
%>			
							
</body>
</html>
		