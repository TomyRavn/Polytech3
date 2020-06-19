<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>게시판 관리</title>
		<style>
			.accept{margin-left: 700px;}
		</style>
		</head>
		<body align="center" bgcolor=#66FFCC>
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
			<h1>글 작성</h1>

		<form action="${pageContext.request.contextPath}/bbs/add.do" method=post>
		
		<table>
			<tbody>
				<tr><th>제목</th><td><input type="text" name="bbsTitle" style='width:600px;'/></td></tr>
				<tr><th>내용</th><td><textarea name="bbsContent" cols="20" row="40"' style='width:600px; height:400px;'></textarea></td></tr>
<%-- 				<tr><th>작성자</th><td><input type="text" name="bbsWriter" value="${sessionScope.loginUser.memId}" readonly/></td></tr> --%>
			</tbody>
		</table>
		<input class="accept" type="submit" value="저장" />
		</form></br></br>
		
		</body>
		</html>
	