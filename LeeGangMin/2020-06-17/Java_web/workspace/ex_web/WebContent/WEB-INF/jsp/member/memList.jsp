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
		<body align="center">
<!-- 		다른 JSP파일(또는 서블릿출력)을 현재 위치에 포함 -->
<%-- 1. <%@ include file="/WEB-INF/jsp/comm/menu.jsp" %>  : 다른 JSP 파일의 내용을 복사하여 현재 위치에 붙여넣기한 것과 동일 --%>
<%-- 2. 액션 태그 <jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include> : 다른 JSP파일로 이동하여 실행한 후 다시 현재 위치로 돌아옴 (forward와 비슷, forward에서 include도 사용가능)--%>
<%-- 3. <c:import url="/WEB-INF/jsp/comm/menu.jsp"></c:import> : 2와 유사하지만, 외부의 다른 사이트까지 포함 가능(구글 등. 1,2는 현재 프로젝트에 있는 것만 가능)--%>
		
		<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
<!-- 		Apache Tiles나 -->
<!-- 		SiteMesh를 쓰면 일일이 메뉴를 다 붙여넣을 필요없음 -->
		
			<h1>회원목록</h1>     
		
		<a href='${pageContext.request.contextPath}/member/add.do'><button>회원가입</button></a></br></br>
		
		<c:forEach var="vo" items="${memList}">
			<a href='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'><b> ${vo.memId} </b></a> : ${vo.memPass} :  ${vo.memName} : ${vo.memPoint} </br>
		</c:forEach>
		
		===================================</br>
		
		</body>                          
		</html>