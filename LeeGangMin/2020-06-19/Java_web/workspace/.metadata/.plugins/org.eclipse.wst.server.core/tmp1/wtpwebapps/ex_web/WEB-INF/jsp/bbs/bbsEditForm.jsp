<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>                  
		<html>                           
		<head>                           
		<meta charset='UTF-8'>           
		<title>게시판 관리</title>
		
		<style>
			.accept{margin-left: 700px;}
			.delete{ float : right; }
		</style>
		
		</head>                          
		<body align="center" bgcolor=#66FFCC>
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>                           
			<h1>게시판 글 변경</h1>
			
		<form action='${pageContext.request.contextPath}/bbs/edit.do' method='post'>
		<input type='hidden' name='bbsNo' value='${bbsVo.bbsNo}' />
		<table>
			<tbody>
<%-- 				<tr><th>글 번호</th><td><input type='text' name='bbsNo' value='${bbsVo.bbsNo}' readonly /></td></tr> --%>
				<tr><th>글 제목</th><td><input type='text' name='bbsTitle' value='${bbsVo.bbsTitle}' style='width:600px;'/></td></tr>
				<tr><th>최초작성일</th><td><input type='text' name='bbsRegDate' value='<fmt:formatDate value="${bbsVo.bbsRegDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>' style='width:210px;' readonly/></td></tr>
				<tr><th>글 내용</th><td><textarea name="bbsContent" cols="40" row="20"' style='width:600px; height:400px;'>${bbsVo.bbsContent}</textarea></td></tr>
				<tr><th>작성자</th><td><input type='text' name='bbsWriter' value='<c:out value="${bbsVo.bbsWriter}"></c:out>' readonly /></td></tr>
				
			</tbody>
		</table>
		
		<input class='accept' type='submit' value='저장' /></br></br>
		<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button class='delete' type='button'>삭제</button></a>
		</form></br></br>
		
		</body>                          
		</html>