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
	String user = "com";
	String password = "com01";
	%>
	
	
	<!DOCTYPE html>               
	<html>                        
	<head>                        
	<meta charset='UTF-8'>        
	<title>회원 관리</title>
	</head>                     
	<body>                        
	
		<h1>회원 정보 수정</h1>   
	<%
    String No = request.getParameter("memId");
    
    
    String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member WHERE mem_id = ?";
   
    try (
          Connection conn = DriverManager.getConnection(url, user, password);
          PreparedStatement pstmt = conn.prepareStatement(sql);				            						            	 
          ) 
    		{
    	 	pstmt.setString(1, No);		                
         	try (ResultSet rs = pstmt.executeQuery();)		                 	
         		{ 	
         		if(rs.next()) {
         		String MemId = rs.getString("mem_id");
         		String MemPass = rs.getString("mem_pass");
         		String MemName = rs.getString("mem_name");
         		int MemPoint = rs.getInt("mem_point");
         		
    %>    		
<%--        <a href='<%=request.getContextPath()%>/member/edit.do?memId=<%=MemId%>'><%= MemId%></a>:<%=MemPass%>:<%=MemName%>:<%=MemPoint%> --%>
         	<form action='<%=request.getContextPath()%>/member/memEdit.jsp' method='post'>
         		
         		
         	아이디: <input text='text' name='memId' value='<%=MemId %>' readonly /><br/>            
<!-- //     비밀번호: <input text='text' name='memPw'value='" + MemPass + "'/><br/>                  -->
       		이름: <input text='text' name='memName'value='<%=MemName %>'/><br/>                     
        	포인트: <input text='text' name='memPoint'value='<%=MemPoint%>'/><br/>                
        	<input type='submit' value='저장' />
         
         
         		<a href='<%=request.getContextPath()%>/member/memDel.jsp?memId=<%=MemId%>'><button type='button'> 삭제 </button></a><br/>
         		</form>           
  <%      		
               }													                	
         	}  	
         	
    		} catch (SQLException e) {
       e.printStackTrace();
    		}
    
    
    
    %>
</body>      
</html>      
