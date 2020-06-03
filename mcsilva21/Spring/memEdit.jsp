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
		String user ="com";
		String password = "com01"; 
%>	

<% 
		request.setCharacterEncoding("UTF-8");
		String memId = request.getParameter("memId"); //파라미터 요청값 요청,호출 값이 똑같아야함.
		String memName =request.getParameter("memName");
		int memPoint = Integer.parseInt( request.getParameter("memPoint"));
	
		String sql = "UPDATE  member SET mem_name = ?, mem_point =? where mem_id =?";
				
		try(
			Connection conn = DriverManager.getConnection(url, user, password);				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {			
			pstmt.setString(3,memId); //파라미터값 받은걸로 채움
			pstmt.setString(1,memName);
			pstmt.setInt(2,memPoint);
			int num= pstmt.executeUpdate(); 
			System.out.println(num + "개의 레코드 추가"); 
								
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		response.sendRedirect(request.getContextPath()+ "/member/memList.jsp");
			
%>	
