<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생 관리</title>
</head>
<body>
 <jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>     
<h1>학생 목록</h1>
<a href='${pageContext.request.contextPath}/student/add.do'>학생 추가</a><br/>

      
      <c:forEach var="vo" items="${stuList}">    
      <a href='${pageContext.request.contextPath}/student/edit.do?stu_no=${vo.stuNo}'>${vo.stuNo}</a>
         :${vo.stuName}:${vo.stuScore}
         <br/>
  </c:forEach>
      </body>
      </html>