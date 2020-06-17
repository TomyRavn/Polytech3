<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
		<html>                           
		<!DOCTYPE html>                  
		<head>                           
		<meta charset='UTF-8'>           
		<title>학생관리</title> 
		<style>
		a, a:visited{
		text-decoration: none;
		color:blue;
		}
		</style>
		</head>                          
		<body align="center">        
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
		                   
			<h1>학생목록</h1>     
		
		<a href='${pageContext.request.contextPath}/student/add.do'><button>학생추가</button></a></br></br>
		
		<c:forEach var="vo" items="${stuList}">
			<a href='${pageContext.request.contextPath}/student/edit.do?stuNo=${vo.stuNo}'><b> ${vo.stuNo} </b></a> : ${vo.stuName} : ${vo.stuScore} </br>
		</c:forEach>
		===================================
		
		</body>                          
		</html>                          