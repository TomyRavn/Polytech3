<%@page import="kr.ac.kopo.student.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!DOCTYPE html>                  
		<html>                           
		<head>                           
		<meta charset='UTF-8'>           
		<title>학생관리</title> 
		</head>                          
		<body>                           
			<h1>학생 정보 변경</h1>     
		
<%
		StudentVo vo = (StudentVo)request.getAttribute("stuVo");
%>
		 
		<form action='<%= request.getContextPath() %>/student/edit.do' method='post'>
		학번을 입력하세요 : <input type='text' name='stuNo' value='<%= vo.getStuNo() %>' readonly /></br></br>
		이름을 입력하세요 : <input type='text' name='stuName' value='<%= vo.getStuName() %>' /></br></br>
		성적을 입력하세요 : <input type='text' name='stuScore' value='<%= vo.getStuScore() %>' />
		<input type='submit' value='저장' /></br></br>
		<a href='<%= request.getContextPath() %>/student/del.do?stuNo=<%= vo.getStuNo() %>'><button type='button' >삭제</button></a>
		</form></br></br>
		
		</body>                          
		</html>                          
