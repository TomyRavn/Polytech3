<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
/*	
	1. 처음 접속한 사람의 경우, 이름을 입력할 수 있는 폼을 보여주고,
		이름을 입력한 후 전송 버튼을 누르면, 다시 현재 JSP파일로 접속
	2. 이름을 입력한 사람의 경우, "입력한이름 님, 안녕하세요"라는 메세지 출력
	3. 현재까지 이름을 입력한 모든 사용자의 수를 "총 사용자 : 00명"이라고 출력 
*/

/*	JSP 에서는 기본객체들을 변수선언 없이 사용가능
	요청객체 : request, 세션객체 : session, 서블릿컨텍스트객체 : application 
	사용자가 이름을 입력하여 전송한 경우, 그 이름을 세션객체에 "userNick"이름으로 저장*/
	
	String nickParam = request.getParameter("nick");
	String nickSession = (String)session.getAttribute("userNick");
// 	nickSession값이 null일 때만 if가 실행
	if (nickParam != null && nickSession == null) {
		session.setAttribute("userNick", nickParam);
		AtomicInteger totalVal = (AtomicInteger)application.getAttribute("total");
		if (totalVal == null){
			totalVal = new AtomicInteger(0);
			application.setAttribute("total", totalVal);
		}
		totalVal.incrementAndGet();
	}
/*
	세션객체에 이름을 저장할 때마다, 
	서블릿컨텍스트객체에 "tatal"이라는 이름으로 저장된 값을 1씩 증가
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>속성 저장 연습</title>
</head>
<body>
	<!-- 세션에 "userNick"이름으로 저장된 속성값이 없는 사용자인 경우 -->
<%-- 	<c: test="${sessionScope.userNick == null}"> <% if(){} %>대신 사용. --%>
	<c:if test="${userNick == null}">
	<!-- 	<form action="attr.jsp"> -->
	<form action="${pageContext.request.contextPath}/exattr.jsp">
		이름 : <input type="text" name="nick"/>
		<input type="submit"/>
	</form>	
	</c:if>

	<!-- 세션에 "userNick"이름으로 저장된 속성값이 있는 사용자인 경우 -->
	<c:if test="${userNick != null}">
		<h3>${userNick}님, 안녕하세요.</h3>
	</c:if>
	<!-- 	모든 사용자에게 다음을 출력 -->
	<h1>총 사용자 : ${applicationScope.total}명</h1>
	<h1>총 사용자 : ${total}명</h1>
	
	
<%-- 		이름: <input type="name" name="memName" value='${memVo.memName}' placeholder="이름을 입력하시오" /> <br /> --%>
<!-- 		<br /><br /><input type="submit" value="저장"/> -->
<%-- 		<a href='${pageContext.request.contextPath }/member/del.do?memId=${memVo.memId}'><button type='button'>삭제</button></a><br /> --%>
</body>
</html>