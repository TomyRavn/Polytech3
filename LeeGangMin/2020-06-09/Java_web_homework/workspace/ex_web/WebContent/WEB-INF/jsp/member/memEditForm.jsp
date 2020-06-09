<%@page import="kr.ac.kopo.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!DOCTYPE html>                  
		<html>                           
		<head>                           
		<meta charset='UTF-8'>           
		<title>회원관리</title> 
		</head>                          
		<body>                           
			<h1>회원 정보 변경</h1>     
		
<%
		//강제 형변환 해주어야 함. 컴파일러는 무슨 타입형인지 모르므로
		MemberVo vo = (MemberVo)request.getAttribute("memVo");
%>
		 
		<form action='<%= request.getContextPath() %>/member/edit.do' method='post'>
		아이디를 입력하세요 : <input type='text' name='memId' value='<%= vo.getMemId() %>' readonly /></br></br>
		이름을 입력하세요 : <input type='text' name='memName' value='<%= vo.getMemName() %>' /></br></br>
		포인트를 입력하세요 : <input type='text' name='memPoint' value='<%= vo.getMemPoint() %>' />
		<input type='submit' value='저장' /></br></br>
		<a href='<%= request.getContextPath() %>/member/del.do?memId=<%= vo.getMemId() %>'><button type='button' >삭제</button></a>
		</form></br></br>
		
		</body>                          
		</html>                          
