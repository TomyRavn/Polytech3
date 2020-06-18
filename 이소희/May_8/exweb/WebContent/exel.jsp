<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습</title>
</head>
<body>
	<div>
	<%="문자열"%> ${"문자열"} ${'문자열'}
<%-- 	<%='문자열'%>  --%>
	<%=123%> ${123}
	<%=true%> ${true}
	</div>
	
	<div>
	<%= 8+4 %> <%= 8-4 %> <%= 8*4 %> <%= 8/4 %>
	${8+4} ${8-4} ${8*4} ${8/4}
	</div>
	
	<div>
	<%=3 == 4%> <%=3 != 4%> <%=3 < 4%> <%=3 > 4%>
	${3 == 4} ${3 != 4} ${3 < 4} ${3 > 4}
	${3 eq 4} ${3 ne 4} ${3 lt 4} ${3 gt 4}
	</div>
	
	<div>
	<%
	String s = "Hello, EL";
	%>
	<%=s%>
	<%-- 	${s} --%>
	<br / >
	x 파라미터 값 : <%=request.getParameter("x")%><br/>
	x 파라미터 값 : ${param.x} <br/>
	x 파라미터 값 : ${param["x"]} <br/>
	User-Agent 헤더 값 : <%=request.getHeader("User-Agent") %> <br/>
	User-Agent 헤더 값 : ${header["User-Agent"]} <br/>
	
<!-- 	JSP 기본객체 (request, response, session, application, ...)는 pageContext에 포함되어 있으므로 꺼내서 사용 가능 -->
	현재 웹애프리케이션(프로젝트)의 고유 경로 (컨텍스트 패스): <%=request.getContextPath()%> <br/>
	현재 웹애프리케이션(프로젝트)의 고유 경로 (컨텍스트 패스): ${pageContext.request.getContextPath()} <br/>
	현재 웹애프리케이션(프로젝트)의 고유 경로 (컨텍스트 패스): ${pageContext.request.contextPath} <br/>
<%-- 	${} 내부에서는 .getXxx() 메서드 대신 .xxx 와 같이 속성(변수) 이름만 사용 가능 --%>

	</div>
	
	<div>
	<%
	//자바웹애플리케이션에서 데이터를 저장할 수 있는 공간(객체)
	pageContext.setAttribute("a", 1); //pageContext는 현재 JSP 파일 안에서만 사용 가능
	request.setAttribute("b", 2); //request는 현재 요청이 처리되는 동안에만 사용 가능
	session.setAttribute("c", 3); 
	application.setAttribute("d", 4);
	
// 	pageContext.setAttribute("z", 5);
// 	request.setAttribute("z", 6);
// 	session.setAttribute("z", 7); 
	application.setAttribute("z", 8);
	%>
	
	pageContext에 "a" 라는 이름으로 저장한 값 : <%=pageContext.getAttribute("a") %> <br/>
	pageContext에 "a" 라는 이름으로 저장한 값 :${pageScope.a} <br/>
	pageContext에 "a" 라는 이름으로 저장한 값 :${a} <br/>
	
	request에 "b" 라는 이름으로 저장한 값 : <%=request.getAttribute("b") %> <br/>
	request에 "b" 라는 이름으로 저장한 값 : ${requestScope.b} <br/>
	request에 "b" 라는 이름으로 저장한 값 : ${b} <br/>
	
	session에 "c" 라는 이름으로 저장한 값 : <%=session.getAttribute("c") %> <br/>
	session에 "c" 라는 이름으로 저장한 값 : ${sessionScope.c} <br/>
	session에 "c" 라는 이름으로 저장한 값 : ${c} <br/>
	
	application에 "d" 라는 이름으로 저장한 값 : <%=application.getAttribute("d") %> <br/>
	application에 "d" 라는 이름으로 저장한 값 : ${applicationScope.d}<br/>
	application에 "d" 라는 이름으로 저장한 값 : ${d}<br/>
	
	"z" 라는 이름으로 저장한 값 : ${z}<br/>
	</div>
	
	
</body>
</html>