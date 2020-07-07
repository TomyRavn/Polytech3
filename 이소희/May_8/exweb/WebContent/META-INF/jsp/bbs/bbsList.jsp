<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<jsp:include page="/META-INF/jsp/comm/menu.jsp"></jsp:include>
	<h1>게시글 목록</h1>
	
	<a href="${pageContext.request.contextPath}/bbs/add.do">새 글 쓰기</a>
	
	
	<table border="1">
	<thead>
	<tr><th>글번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
	</thead>
	<tbody>

	<c:forEach var="vo" items="${bbsList}">
	<tr>
	<td>${vo.bbsNo}</td>
	<td><a href= "${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}">
	<c:out value="${vo.bbsTitle}"/>
	</a></td>
	<td><c:out value="${vo.bbsWriter}"/>
	</td>
	<td><fmt:formatDate value = "${vo.bbsRegDate}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
	
	</c:forEach>
	
	</tbody>
	</table>
</body>
</html>