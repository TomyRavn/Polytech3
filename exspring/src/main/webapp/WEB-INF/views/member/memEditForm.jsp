<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
<h1>회원 정보 변경</h1>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
		
<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
아아디:<input type='text'name='memId'value='${memVo.memId}'readonly /><br/>
이름:<input type='text' name='memName' value='${memVo.memName}'/><br/>
포인트:<input type='text' name='memPoint' value='${memVo.memPoint}'/><br/>
<input type='submit' value='저장'/><br/>
<form/>
<a href='${pageContext.request.contextPath}/member/del.do?memId=${memVo.memId}'><button type='button'>삭제</button></a><br/>
</body>
</html>
