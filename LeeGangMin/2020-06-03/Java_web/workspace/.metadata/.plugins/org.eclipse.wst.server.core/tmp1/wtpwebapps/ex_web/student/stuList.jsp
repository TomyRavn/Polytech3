<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//학생목록을 다음과 같은 표 형태로 출력하고,
	//'학번'을 클릭하면 학번순으로 정렬하여 출력하고,
	//'이름'을 클릭하면 이름순으로 정렬하여 출력
	//학번   이름
	//1234 포로리
	
	//'학번' 기준으로 정렬된 상태에서 '학번'을 다시 클릭하면,
	//오름차순과 내림차순을 번갈아서 정렬
	//'이름' 기준으로 정렬된 상태에서 '이름'을 다시 클릭하면
	//오름차순과 내림차순을 번갈아서 정렬
%>    

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
	
	String str_no = "stu_no";
	String str_name = "stu_name";
	String str_asc = "ASC";
	String str_desc = "DESC";
	
	boolean sort_stuName = true;
	boolean sort_DESC = true;
	String subject_now = str_name;
	String sort_now = str_desc;
%>
		
		<!DOCTYPE html>       
		<html>                
		<head>                
		<meta charset='UTF-8'>
		<title>학생관리</title>
		<style>
		a, a:visited{
		text-decoration: none;
		color:black;
		}
		td {
		text-align:center;
		border: 1px solid #aaa;
		color:black;
		} 
		</style>
		</head>               
		<body>                
			<h1>학생목록</h1> 
		<a href= '<%= request.getContextPath() %>/student/stuAddForm.jsp'><button>학생추가</button></a></br></br>
		
<%
		if(sort_stuName){sort_stuName = false; subject_now = str_name; sort_now = str_asc;}
		else{sort_stuName = true; subject_now = str_name; sort_now = str_desc;}

		if(sort_DESC){sort_DESC = false; subject_now = str_no; sort_now = str_asc;}
		else{sort_DESC = true; subject_now = str_no; sort_now = str_desc;}
		
		String sql = "SELECT stu_no, stu_name, stu_score FROM student ORDER BY " + subject_now + " " + sort_now;
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
%>
		<table>
			<tr>
				<td>
					<a href='<%= request.getContextPath() %>/student/stuList.jsp'><b>학번</b></a>
				</td>
				<td>
					<a href='<%= request.getContextPath() %>/student/stuList.jsp'><b>이름</b></a>
				</td>
				<td>
					성적
				</td>
			</tr>

<%
			while(rs.next()) {
				String stuNo = rs.getString("stu_no");
				String stuName = rs.getString("stu_name");
				int stuScore = rs.getInt("stu_score");
%>
			<tr>
				<td>
					<a href='<%= request.getContextPath() %>/student/stuEditForm.jsp?stuNo=<%= stuNo %>'><b><%= stuNo %></b></a>
				</td>
				<td>
					<%= stuName %>
				</td>
				<td>
					<%= stuScore %>
				</td>
			</tr>
	
<%
			}
%>

		</table>
<%
		} catch (SQLException e) {
			e.printStackTrace();
		}
%>
		</body>
		</html>