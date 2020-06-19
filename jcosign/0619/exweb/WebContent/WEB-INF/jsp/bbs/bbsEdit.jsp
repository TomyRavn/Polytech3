<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
	
	<h1>글 상세정보</h1>
	<form action="${pageContext.request.contextPath}/bbs/edit.do" method="post">
	<input type="hidden" name="bbsNo" value="${bbsVo.bbsNo}"/>
	<table border="1">
		<tbody>
<%-- 		<tr><th>글번호</th><td><input type="text" name="bbsNo" value="${bbsVo.bbsNo}" readonly="readonly"/></td></tr> 이렇게 해도 되고 위에 hidden(전송은 해야되나 보이지 않게 하는 것)이 있는 줄로 작성해도된다.--%>
			<tr><th>제목</th><td><input type="text" name="bbsTitle" value="${bbsVo.bbsTitle}"></td></tr>
			<tr><th>내용</th><td><textarea name="bbsContent" rows="10" cols="30" >${bbsVo.bbsContent}</textarea></td></tr>
			<tr><th>작성자</th><td><c:out value="${bbsVo.bbsWriter}"/></td></tr>
			<tr><th>작성일</th><td><fmt:formatDate value="${bbsVo.bbsRegDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /></td></tr>
		</tbody>
	</table>
		<input type="submit" value="저장">
		<a href="${pageContext.request.contextPath }/bbs/del.do?bbsNo=${bbsVo.bbsNo}"><button type='button'>삭제</button></a><br />
<!-- 혹은<a href='${pageContext.request.contextPath }/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><input type="button" value="삭제"/></a>로 사용 -->
	</form>
</body>
</html>