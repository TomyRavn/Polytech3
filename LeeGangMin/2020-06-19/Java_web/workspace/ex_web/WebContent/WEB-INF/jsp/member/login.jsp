<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<style>
			.accept{margin-left: 700px;}
		</style>
		</head>
		<body align="center">
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
			<h1>로그인</h1>

		<form action="${pageContext.request.contextPath}/member/login.do" method=post>
		
		<table align="center">
			<tbody>
				<tr><th>아이디</th><td><input type="text" name="memId" /></td></tr>
				<tr><th>비밀번호</th><td><input type="password" name="memPass" /></td></tr>
			</tbody>
		</table>
		<input class="accept" type="submit" value="로그인" />
		</form></br></br>
		
		</body>
		</html>
	