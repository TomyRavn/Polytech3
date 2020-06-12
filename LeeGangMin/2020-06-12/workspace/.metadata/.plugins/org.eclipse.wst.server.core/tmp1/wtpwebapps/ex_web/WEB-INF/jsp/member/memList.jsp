<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
		<html>                           
		<!DOCTYPE html>                  
		<head>                           
		<meta charset='UTF-8'>           
		<title>회원관리</title> 
		<style>
		a, a:visited{
		text-decoration: none;
		color:blue;
		}
		</style>
		</head>                          
		<body>                           
			<h1>회원목록</h1>     
		
		<a href='${pageContext.request.contextPath}/member/add.do'><button>회원가입</button></a></br></br>
		
		<c:forEach var="vo" items="${memList}">
			<a href='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'><b> ${vo.memId} </b></a> : ${vo.memPass} :  ${vo.memName} : ${vo.memPoint} </br>
		</c:forEach>

		===================================
		
		</body>                          
		</html>