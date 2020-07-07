
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생 관리</title>
</head>
<body>
	<jsp:include page="/META-INF/jsp/comm/menu.jsp"></jsp:include>
	<h1>학생 정보 수정</h1>


	<form action='${pageContext.request.contextPath}/student/edit.do'
		method='post'>

		학번: <input text='text' name='stu_no' value='${stuVo.stuNo}' /><br />
		이름: <input text='text' name='stu_name' value='${stuVo.stuName}' /><br />
		성적: <input text='text' name='stu_score' value='${stuVo.stuScore}' /><br />
		<input type='submit' value='저장' /> <a
			href='${pageContext.request.contextPath}/student/del.do?stu_no=${stuVo.stuNo}'><button
				type='button'>삭제</button></a><br />
	</form>

</body>
</html>

