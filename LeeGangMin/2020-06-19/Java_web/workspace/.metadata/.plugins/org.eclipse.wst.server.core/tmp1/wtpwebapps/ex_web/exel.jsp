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
		<%="문자열" %> ${"문자열"}
		
<%-- 		자바에서는 <%= ' ' %> 안되고 EL에서는 됨 --%>
<%-- 		<%='문자열' %>  --%>
		${'문자열'}
		
		<%=123 %>	${123}
		<%=true %>	${true}
	</div>
	
	<div>
		<%=8+4%> <%=8-4%> <%=8*4%> <%=8/4%>
		${8+4} ${8-4} ${8*4} ${8/4} ${8 div 4} ${8 mod 4}
	</div>
	<div>
		<%=3==4%> <%=3!=4%> <%=3<4%> <%=3>4%>
		${3==4} ${3!=4} ${3<4} ${3>4}
		${3 eq 4} ${3 ne 4} ${3 lt 4} ${3 gt 4}
<!-- 		lt : less than / gt : greater than  -->
	</div>
	<div>
		<%
			//따옴표 없이 쓰면 변수로서 여김(abc)
// 			String s = abc;
		%>
<!-- 		기본 객체라는 것은 변수 선언없이 변수처럼 쓸 수 있는 것들을 말함 -->
<%-- 		${문자열} --%>
	</div>
	
	<div>
		<%
			String s = "Hello, EL";
		%>
		<%=s %></br>
<%-- 	중요!!	${s } //실행 불가 --%>

		
		x 파라미터 값 : 
		<%
			String xparam = request.getParameter("x");
			out.println(xparam);
		%></br>
		x 파라미터 값 : <%= request.getParameter("x") %></br>
		x 파라미터 값 : ${param.x} </br>
		x 파라미터 값 : ${param["x"]} </br>
<!-- 		getParameterValues : 체크박스와 같이 값이 여러 개 일 때 배열로 값을 반환해줌 -->
<!-- 		paramValues도 동일한 기능 -->


		User-Agent 헤더 값 : <%= request.getHeader("User-Agent") %> </br>
		User-Agent 헤더 값 : ${header["User-Agent"]} </br>
<!-- 		User-Agent는 변수규칙에 어긋나므로 배열처럼 []를 써서 묶은 후 문자 ""로 설정 -->
<!-- 		.표현을 쓰지 못함 -->
<!-- 		자바에서는 .만 가능하지만 EL에서는 []대괄호에 ""로 속성명을 적어 속성 접근이 가능 -->
<!-- 		JSP 기본객체 (request, response, session, application, ...) 는 pageContext에 포함되어 있으므로 꺼내서 사용 가능 -->
		현재 웹 애플리케이션(프로젝트)의 고유경로(컨텍스트 패스) : <%=request.getContextPath()%> </br>
		현재 웹 애플리케이션(프로젝트)의 고유경로(컨텍스트 패스) : ${pageContext.request.getContextPath()} </br>
		현재 웹 애플리케이션(프로젝트)의 고유경로(컨텍스트 패스) : ${pageContext.request.contextPath} </br>
<%-- 		${} 내부에서는 getXxx() 메서드 대신 .xxx와 같이 속성(변수)이름만 사용하는 것도 가능 (%--jsp 주석, html주석은 jsp입장에서 그냥 글자이고 실행함. 크롬에가서 크롬이 감춰서 안보이게 함)--%>
<%-- 		따라서 사용자에게 감춰야할 내용은 jsp주석을 달아놔야함 (p/w 등) --%>
		
		<%
// 			자바 웹 애플리케이션에서 데이터를 저장할 수 있는 공간(객체)/4개의 공간, 용도에 따라 골라서 저장 
			pageContext.setAttribute("a", 1213213);		//pageContext는 '현재 jsp파일' 안에서만 사용가능	/ jsp하나 당 하나로 씀(유지기간이 request에 비해 짧음)
			request.setAttribute("b", "asbda");			//request는 '현재 요청이 처리되는 동안'에만 사용가능
														//한 번 요청이 되어서 실행이 되는 동안(요청 객체 하나로 돌려씀, forward등으로 공유가 됨)
			session.setAttribute("c", "as123124");
			application.setAttribute("d", "123124aa");
			
			//테스트용
			pageContext.setAttribute("z", 1213213);
			request.setAttribute("z", "asbda");
			session.setAttribute("z", "as123124");
			application.setAttribute("z", "123124aa");
		%>
		pageContext에 "a"라는 이름으로 저장한 값 : <%=pageContext.getAttribute("a")%></br>
		pageContext에 "a"라는 이름으로 저장한 값 : ${pageScope.a}</br>
		pageContext에 "a"라는 이름으로 저장한 값 : ${pageScope["a"]}</br>
		pageContext에 "a"라는 이름으로 저장한 값 : ${a}</br>
<!-- 		a라고만 써도 되는 이유 : pageContext, ... 에 순서대로 a로 저장된 게 있냐 자동으로 검색해서 있는 경우 실행-->
<!-- 		하지만 같은 이름으로 저장한 경우 문제 발생 -->
		
		request에 "b"라는 이름으로 저장한 값 : <%=request.getAttribute("b")%></br>
		request에 "b"라는 이름으로 저장한 값 : ${requestScope.b}</br>
		request에 "b"라는 이름으로 저장한 값 : ${b}</br>
		session에 "c"라는 이름으로 저장한 값 : <%=session.getAttribute("c")%></br>
		session에 "c"라는 이름으로 저장한 값 : ${sessionScope.c}</br>
		session에 "c"라는 이름으로 저장한 값 : ${c}</br>
		application에 "d"라는 이름으로 저장한 값 : <%=application.getAttribute("d")%></br>
		application에 "d"라는 이름으로 저장한 값 : ${applicationScope.d}</br>
		application에 "d"라는 이름으로 저장한 값 : ${d}</br>
		
		"z"라는 이름으로 저장한 값 : ${z}</br>
<!-- 	Scope로 지정해주지 않고 출력할 시 순서대로 가져옴, if-else if와 같은 느낌 / 세션은 서버 떠있는동안 계속 유지되므로 서버를 재시작하면 바뀜 -->
<!-- 	가급적이면 다른이름으로 저장하는 것이 좋다 -->
	</div>
		
</body>
</html>