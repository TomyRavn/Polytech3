<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello JSP</h1>
<%-- 스크립트릿 : JSP 내에서 실행하고 싶은 JAVA 코드들은 <% %> 태그 내부에서 작성 --%>
	<% 

	int a = 3;
	int b = 4;
	int c = a + b;
//	JSP에서는 별도의 선언 없이 사용 가능한 기본 객체들이 존재
// 	request(요청객체), response(응답객체), out(응답 객체에 출력하는 스트링) 등
	out.println("a + b = " +c);
	
	%>
	
	a + b = <% out.println(c); %>
	a + b = <%= c %>
<%-- 표현식: JAVA 코드를 실행한 결과를 현재 위치에 출력하고 싶은 경우<%= %> 사용 가능  --%>

<%-- 요청이 올 때마다 실행되는 servlet() 메서드 외부에 위치해야하는 자바코드는 <%! %> 사용 --%>
<%!
private int x = 10;
%>
</body>
</html>