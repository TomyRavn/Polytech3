<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	page import="java.util.concurrent.atomic.AtomicInteger"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<% 
// 	HttpSession session = request.getSession();
// 	이미 있기 떄문에 이렇게 할 필요없음 -> session
	
// 	JSP에서 기본객체들을 변수선언 없이 사용 가능
// 	요청객체 : request, 세션 객체 : session, 서블릿 컨텍스트 객체 : application
	
// 	1. 처음 접속한 사람의 경우, 이름을 입력할 수 있는 폼을 보여주고,
// 		이름을 입력한 후 전송 버튼을 누르면, 다시 현재 JSP 파일로 접속
// 	2. 이름을 입력한 사람의 경우, "입력한이름 님, 안녕하세요" 라는 메시지 출력
// 	3. 현재까지 이름을 입력한 모든 사용자의 수를 "총 사용자 : 00명" 이라고 출력
// 	사용자가 이름을 입력하여 전송한 경우, 그 이름을 세션객체에 "userNick"이름으로 저장
//	세션 객체에 이름을 저장할 떄마다, 1씩 증가 => 서블릿 컨텍스트 객체에 "total"이라는 이름으로 저장된 값을 1씩 증가
	
// 		HttpSession session = req.getSession(); //현재 요청에 속한 세션 객체 가져오기
// 		AtomicInteger scnt = (AtomicInteger) session.getAttribute("sesCnt");
// 		if(scnt == null) {
// 			scnt = new AtomicInteger(0);
// 		}
// 		scnt.incrementAndGet();
// 		session.setAttribute("sesCnt", scnt);
	
	String nickParam = request.getParameter("nick");
	
	String nickSession = (String)session.getAttribute("userNick");
	
	//파라미터 값이 넘어오고 세션은 없을 때만 처리
	if(nickSession == null && nickParam != null){
		session.setAttribute("userNick", nickParam);

		AtomicInteger totalVal = (AtomicInteger)application.getAttribute("total");
		if(totalVal == null){
			totalVal = new AtomicInteger(0);
			application.setAttribute("total", totalVal);
		}
		totalVal.incrementAndGet();
	}
	
%>		    

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>속성 저장 연습</title>
</head>
<body>
<!-- 세션에 "userNick" 이름으로 저장된 속성값이 없는 사용자인 경우 -->

	<c:if test="${sessionScope.userNick == null}">
		<form action="${pageContext.request.contextPath}/exattr.jsp">
			 이름 : <input type="text" name="nick" />
			 	<input type="submit" />   	
		</form>
	</c:if>

<!-- 세션에 "userNick" 이름으로 저장된 속성값이 있는 사용자인 경우 -->

	<c:if test="${userNick != null}">
 		<h1>${userNick}님, 안녕하세요</h1>
 	</c:if>
 	
<!-- 모든 사용자에게 다음을 출력 -->
	<h1>총 사용자 : ${applicationScope.total} 명</h1>
 
</body>
</html>