<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!DOCTYPE html>                  
		<html>                           
		<head>                           
		<meta charset='UTF-8'>           
		<title>학생관리</title> 
		</head>                          
		<body align="center">
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>                           
			<h1>학생 정보 변경</h1>     
		
		 
		<form action='${pageContext.request.contextPath}/student/edit.do' method='post'>
		학번을 입력하세요 : <input type='text' name='stuNo' value='${stuVo.stuNo}' readonly /></br></br>
		이름을 입력하세요 : <input type='text' name='stuName' value='${stuVo.stuName}' /></br></br>
		성적을 입력하세요 : <input type='text' name='stuScore' value='${stuVo.stuScore}' />
		<input type='submit' value='저장' /></br></br>
		<a href='${pageContext.request.contextPath}/student/del.do?stuNo=${stuVo.stuNo}'><button type='button' >삭제</button></a>
		</form></br></br>
		
		</body>                          
		</html>                          
