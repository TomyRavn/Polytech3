<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>회원관리</title>
		<style>
		.accept{ float : right; }
		</style>
		</head>
		<body align="center">
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
			<h1>회원가입</h1>

		<form action="${pageContext.request.contextPath}/member/add.do" method=post>
		아이디를 입력하세요 : <input type="text" name="memId" /></br></br>
		비밀번호를 입력하세요 : <input type="text" name="memPass" /></br></br>
		이름을 입력하세요 : <input type="text" name="memName" /></br></br>
		포인트를 입력하세요 : <input type="text" name="memPoint" />
		<input class="accept" type="submit" value="저장" />
		</form></br></br>
		
		</body>
		</html>
	