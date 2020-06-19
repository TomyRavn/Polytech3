<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 	로그인하지 않은 경우 -->
	<c:if test="${loginUser == null}">
		<a href="${pageContext.request.contextPath}/member/login.do">[로그인]</a>
		<a href="${pageContext.request.contextPath}/member/add.do">[회원가입]</a>
	</c:if>


	<!-- 	로그인한 경우 -->
	<c:if test="${loginUser != null}">
		<a href="${pageContext.request.contextPath}/member/list.do">[회원관리]</a>
		<a href="${pageContext.request.contextPath}/bbs/list.do">[게시판]</a>
		<a href="${pageContext.request.contextPath}/student/list.do">[학생관리]</a>
		<a href="${pageContext.request.contextPath}/member/logout.do">[로그아웃]</a>
		<c:out value="${loginUser.memName}" /> 님,안녕하세요.
	</c:if>

</body>
</html>