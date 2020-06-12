<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
table{
  border-collapse: collapse;
  text-align: center;
}
</style>
</head>
<body>
	
	<h1>게시글 목록</h1>	
	<a href="${pageContext.request.contextPath}/bbs/add.do">새글쓰기</a>
	</br>
	</br>
	
	<table border="1">	
	<thead>
		<tr><th>글번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>		
	</thead>
	<tbody>
		<c:forEach var="vo" items="${bbsList}">
		<tr>
		<td>${vo.bbsNo}</td>
		<td><a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}">${vo.bbsTitle}</a></td>
		<td>${vo.bbsWriter}</td>
		<td>${vo.bbsRegDate}</td>
		</tr>
		</c:forEach>
	</tbody>
	
	</table>


</body>
</html>