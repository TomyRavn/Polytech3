<!-- sqp.date와 다르게 -->
<!-- util.date는 시간도 저장 가능 -->
<!-- 하지만 오류가 있어 원칙적으로는 자바 8에서 localdatetime 을 쓰는게 맞음-->
<%@page import="java.util.Date"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--     prefix : 기본 태그와 차이를 두기위해서 접두어를 뭘로 붙일지 정함 . 보통 코어는 core -> c -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	a, a:visited{
		text-decoration:none;
		color:blue;
	}
</style>

</head>
<body>
	<%
		int n = 70;
	if(n >= 60){
	%>
		통과
	<%
	}else{
	%>
		실패
	<%
	}
	%>
	
	<%
		request.setAttribute("n", n);
	%>
	
<!-- 	조건이 참이 될 경우에만 출력 -->
	<c:if test="<%=n>=70%>">통과</c:if>
	<c:if test="<%=n<70%>">실패</c:if>
	
	
<!-- 	실행되지않음 -> int n이 안먹히기 때문 -> setAttribute 필요 -->
	<c:if test="${n>=70}">통과</c:if>
	<c:if test="${n<70}">실패</c:if>
	
<!-- 	choose - when - otherwise : if - else if -  else -->
	<c:choose>
		<c:when test="${n>=60}">통과</c:when>
		<c:otherwise>실패</c:otherwise>
	</c:choose>
	
<!-- 	begin, end, step 속성 -->
<!-- 	0부터 시작해서 10까지 2씩 증가시키면서 반복하라는 뜻 -->
	<c:forEach begin="0" end="10" step="2">
		[반복출력]
	</c:forEach>
	
	<%
		ArrayList<String> list = new ArrayList<String>();
		list.add("짜장");
		list.add("짬뽕");
		list.add("탕수육");
		
		request.setAttribute("foodList", list);
	%>
	
<!-- 	items에 있는 것을 var로 하나씩 꺼냄 -->
<%-- var에 들어간 이름은 <%= %>에서 쓰는 것이 아니라 EL에서 쓰는 이름 --%>
<%-- 		<%=food%> --%>

<!-- 	items에 지정한 배열/리스트의 값들을 하나씩 꺼내서 -->
<!-- 	var에 지정한 이름의 변수 넣으면서 반복 -->
<!-- 	"짜장면", "짬뽕", "탕수육"이 목록형태로 출력되도록 고치시오. -->

<!-- 	ul : 순서없는애,  ol : 순서있는애, dl : 사전식 -->
	<ul>
		<c:forEach var="food" items="${foodList}">
			<li>
				${food}
			</li>
		</c:forEach>
	</ul>
	
	
	<%
		request.setAttribute("s", "<h1>Hello</h1>");
	%>
	
	${s}
	
<!-- 	escapeXml 을 true 또는 적어주지 않을 시 <>를 특수한 표현으로 바꿔 표현, &lt &gt 등(escape 시킴) -->
<!-- 	보안상 중요. 예) <script></script> 등으로 들어올 수 있음 (c:out 태그 사용시 막을수 있다) -->
	<c:out value="${s}" escapeXml="false"></c:out></br>

<!-- 		다른 HTML, JSP, 서블릿 등의 내용을 포함(중간에) -->	
	<div>
		<c:import url="hello.jsp"></c:import>
<%-- 		<c:import url="http://google.com"></c:import> --%>
	</div>
	
<!-- 	폴더를 주소로 한 경우, 폴더를 통째로 보낼 수 없기 때문에 WEB-INF > web.xml에서 초기파일 설정해줄 수 있음 (일치하는 애가 있으면 실행) -->
	
<!-- 	아래 "헬로JSP로 가는 링크"를 클릭하면 hello.jsp 파일로 이동하도록 링크를 구현	 -->
<!-- 	주소창에 칠때는 WebContent가 최상위다 -->
	<a href='${pageContext.request.contextPath}/hello.jsp'>헬로JSP로 가는 링크</a></br></br>
	<a href='/ex_web/hello.jsp'>헬로JSP로 가는 링크</a></br></br>
<!-- 	c:url을 쓰면 알아서 자동으로 contextPath를 붙여줌 -->
	<a href='<c:url value='/hello.jsp'></c:url>'>헬로JSP로 가는 링크</a></br></br>
	<a href='<c:url value='/hello.jsp' />'>헬로JSP로 가는 링크</a></br></br>
	
	<%
		Date d = new Date();
		request.setAttribute("now", d);
		double num = 12345678.9876;
		request.setAttribute("doub", num);
	%>
	
<!-- 	Date타입을 문자열로 바꾸는 게 포맷팅formatting -->
<!-- 	문자열을 Date타입으로 바꾸는게 파싱parsing -->
	
	<div>
		현재 시간 : ${now}</br>
		
<!-- 		fmt:formatDate태그를 사용하여 날짜/시간 데이터를 문자열로 변환 -->
<!-- 		pattern 속성에 자바의 SimpleDateFormat에서 사용하는 패턴으로 원하는 문자열 지정 -->
		현재 시간 : <fmt:formatDate value="${now}" pattern="yyyy/MM/dd HH:mm:ss"/></br>
		현재 시간 : <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/></br>
	</div>
	<div>num 값 : ${doub}</div>
	<div>num 값 : <fmt:formatNumber value="${doub}" pattern="#,###.##"></fmt:formatNumber></div>
	<div>num 값 : <fmt:formatNumber value="${doub}" pattern="000,000,000.00"></fmt:formatNumber></div>
<!-- 	#과 0의 차이는 #은 숫자가 있으면 쓰고 없으면 안씀, 0은 없으면 채워줌 -->
	
</body>
</html>