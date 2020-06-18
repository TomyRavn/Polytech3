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
String memId = request.getParameter("memId"); 
String memPass = request.getParameter("memPass"); 
String memName = request.getParameter("memName"); 
int memPoint = Integer.parseInt(request.getParameter("memPoint")); 


String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point)"
		+ "VALUES (?, ?, ?, ?)";

try(
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		) {
	pstmt.setString(1, memId);	
	pstmt.setString(2, memPass);	
	pstmt.setString(3, memName);	
	pstmt.setInt(4, memPoint);	
	int num = pstmt.executeUpdate(); 
	out.println(num + "명예회원 추가");
} catch (SQLException e) {
	e.printStackTrace();

}

response.sendRedirect(request.getContextPath() + "/member/memList.jsp");

%>
