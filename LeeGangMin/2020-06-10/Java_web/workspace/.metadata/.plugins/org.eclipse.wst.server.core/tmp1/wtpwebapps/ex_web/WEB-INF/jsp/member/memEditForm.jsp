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
		 
		<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
		아이디를 입력하세요 : <input type='text' name='memId' value='${memVo.memId}' readonly /></br></br>
		이름을 입력하세요 : <input type='text' name='memName' value='${memVo.memName}' /></br></br>
		포인트를 입력하세요 : <input type='text' name='memPoint' value='${memVo.memPoint}' />
		<input type='submit' value='저장' /></br></br>
		<a href='${pageContext.request.contextPath}/member/del.do?memId=${memVo.memId}'><button type='button' >삭제</button></a>
		</form></br></br>
		
		</body>                          
		</html>
		
<!-- 		자바코드가 꼭 필요하면 -> servlet -->
<!-- 		jsp에서 꼭 해야한다면 custom tag 사용 -->