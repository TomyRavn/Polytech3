<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--     <%@ %> : 디렉티브, 지시 정보(설정 정보)를 담고 있음, 어떻게 구성되는지, 어떤 클래스를 쓸것인지 등을 선언 --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>Hello JSP</h1>
	
<!-- 	JSP도 사실상 servlet -->
<%-- 1.% 스크립트식 : 자바코드 쓸 수 있게 해줌, JSP 내에서 실행하고 싶은 JAVA코드 들은 <% %> 태그 내부에 작성-->
<!-- HTML처럼 쓸 수도 있지만 기본적으로 JSP도 servlet을 변환하는 것이라는 것을 알아야함 -->
<%-- JSP 주석 --%>
	<%	/* 새로고침시마다 실행 */
		int a = 3;
		int b = 4;
		int c = a + b;
		//JSP 내에서는 별도의 선언없이 사용가능한 기본객체들이 존재
		//request 요청객체, response 응답객체, out 응답객체에 출력하는 스트림 등
		
		out.println("a + b = " + c);  // --> jsp는 out.println과 같은 것을 안쓰게 하려고 씀
	%>
	a + b = <% out.println(c); %> <%-- c는 변수인데 값을 담고 있다. 따라서 자바로 해석해서 출력하도록 만들어야 원하는 값이 나옴(out.println(c)) --%>
	a + b = <%= c %>
	
<%-- 2. 표현식 : JAVA 코드를 실행한 결과를 현재 위치에 출력하고 싶은 경우 <%= %> 사용 가능 --%>
	
<%-- 3.	요청이 올때마다 실행되는 service() 메서드 외부에 위치해야하는 자바코드는 <%! %> 사용 --%>
	<%!
// 		접근 제한자 붙는 변수는 메소드 밖에만 위치할 수 있다
		private int x = 10;
	%>
</body>
</html>