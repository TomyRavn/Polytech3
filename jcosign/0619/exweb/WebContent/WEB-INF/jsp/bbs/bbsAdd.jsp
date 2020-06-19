<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
	
	<h1>새 글 쓰기</h1>
	<form action="${pageContext.request.contextPath}/bbs/add.do" method="post">
	<table border="1">
		<tbody>
			<tr><th>제목</th><td><input type="text" name="bbsTitle"></td></tr>
			<tr><th>내용</th><td><textarea name="bbsContent" rows="10" cols="30"></textarea></td></tr>
<%-- 		<tr><th>작성자</th><td><input type="text" name="bbsWriter" value="${loginUser.memId}" readonly="readonly"></td></tr> --%>
			<!-- "${sessionScope.loginUser.memId}"를 "${loginUser.memId}"로 줄여 넣은 것 -->
			<!-- 보안은 화면이 아닌 백엔드. 자바 코드에서 구현해야 한다. readonly를 넣어도 f12-console-'document.quarySelector('[name="bbsWriter"]')'등으로 바꿀 수 있다.
			사용자 편의를 위한 것이지, 보안은 취약하다. servlet에서 강제로 넣어야 한다.-->
		</tbody>
	</table>
		<input type="submit" value="저장">
	</form>
</body>
</html>