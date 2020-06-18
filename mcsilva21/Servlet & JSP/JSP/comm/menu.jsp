<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<!--링크가 작동하도록 구현-->
<a href="${pageContext.request.contextPath}/member/list.do">[회원관리]</a>
<a href="${pageContext.request.contextPath}/bbs/list.do">[게시판]</a>
<a href="${pageContext.request.contextPath}/student/list.do">[학생관리]</a>


<!--로그인하지 않은 경우 -->

<c:if test="${loginUser==null}">
<a href="${pageContext.request.contextPath}/member/login.do">[로그인]</a>
<a href="${pageContext.request.contextPath}/member/add.do">[회원가입]</a>
</c:if>

<!--로그인한 경우 -->
<c:if test="${loginUser!=null}">
<strong>${loginUser.memName}님</strong>
<a href="${pageContext.request.contextPath}/member/logout.do">[로그아웃]</a>
</c:if>
</body>
</html>