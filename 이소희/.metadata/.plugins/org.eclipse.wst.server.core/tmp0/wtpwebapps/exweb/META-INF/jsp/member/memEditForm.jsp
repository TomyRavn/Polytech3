
<%@page import="kr.ac.kopo.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
	MemberVo vo  = (MemberVo)request.getAttribute("memVo");
	%>
	<!DOCTYPE html>               
	<html>                        
	<head>                        
	<meta charset='UTF-8'>        
	<title>회원 관리</title>
	</head>                      
	<body>                        
	
	<h1>회원 정보 수정</h1>
	
    <form action='<%=request.getContextPath()%>/member/edit.do' method='post'> 

  	아이디: <input text='text' name='memId' value='<%=vo.getMemId()%>' readonly /><br/>                  
  	이름: <input text='text' name='memName'value='<%=vo.getMemName()%>'/><br/>               
  	포인트: <input text='text' name='memPoint'value='<%=vo.getMemPoint()%>'/><br/>          
  	<input type='submit' value='저장' />                                       
  
  
  <a href='<%=request.getContextPath()%>/member/del.do?memId=<%=vo.getMemId()%>'><button type='button'> 삭제 </button></a><br/>
  </form>          

</body>                         
</html>                         
