<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>

	<h1>로그인</h1>
	<form action="${pageContext.request.contextPath }/member/Login.do" method="post">
<!-- 	${pageContext.request.contextPath }를 넣어 컴퓨터 주소를 생략한다. 	-->
		아이디: <input type="text" name="memId" value='${memVo.memId}'placeholder="id를 입력하시오" /> <br />
		비밀번호: <input type="password" name="memPass" value='${memVo.memPass}' placeholder="pw를 입력하시오" /> <br />
		<br /><input type="submit" value="로그인"/><br /><br /><br /><br />
		<h3>아직 회원이 아니십니까?</h3><h6>그렇다면 어서오세요!</h6>
		<a href='${pageContext.request.contextPath}/member/add.do'>회원가입</a><br />
		
	</form>
</body>
</html>