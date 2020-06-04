<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 		resp.setContentType("text/html"); -->
<!-- 		resp.setCharacterEncoding("UTF-8"); -->
<!-- 		를 위해서 해줌 -->
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
		
		<!DOCTYPE html>       
		<html>                
		<head>                
		<meta charset='UTF-8'>
		<title>회원관리</title>
		<style>
		a, a:visited{
		text-decoration: none;
		color:black;
		}
		</style>
		</head>               
		<body>                
			<h1>회원목록</h1> 
		<a href= '<%= request.getContextPath() %>/member/memAddForm.jsp'><button>회원가입</button></a></br></br>
		
<%
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
		try (
// 				끝 한글자를 지워서 자동완성으로 sql붙은 녀석들을 다 import 시켜주어야 함 
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				int memPoint = rs.getInt("mem_point");

%>

<a href='<%= request.getContextPath() %>/member/memEditForm.jsp?memId=<%= memId %>'><b><%= memId %></b></a>
: <%= memPass %> : <%= memName %> : <%= memPoint %>
</br>
	
<%
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
%>
		</body>
		</html>