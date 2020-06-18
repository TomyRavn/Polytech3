<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
<!-- 다른 JSP 파일(또는 서블릿출력)을 현재 위치에 포함 -->
<%-- <%@include %>: 다른 JSP파일의 내용을 복사하여 현재위치에 붙여넣기한 것과 동일 --%>
<%-- <%@include file="/WEB-INF/jsp/comm/menu.jsp" %> --%>
<%--<jsp:include>:다른 JSP파일로 이동하여 실행한 후 다시 현재 위치로 돌아옴 --%>
<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
<%-- <c:import>:<jsp:include>와 유사하지만, 외부의 다른 사이트까지 포함 가능--%>
<%-- <c:import url="/WEB-INF/jsp/comm/menu.jsp"></c:import> --%>

<h1>회원목록</h1>
<%-- <a href='<%=request.getContextPath()%>/member/addform.do'>회원가입</a><br/> --%>
<a href='${pageContext.request.contextPath}/member/add.do'>회원가입</a><br/>
			
	<c:forEach var="vo" items="${memList}">
	<a href='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'>${vo.memId}</a>	
	:${vo.memPass}:${vo.memName}:${vo.memPoint}
	<br/>
	</c:forEach>
			
</body>
</html>
