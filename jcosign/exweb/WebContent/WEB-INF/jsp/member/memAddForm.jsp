<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>                
<html>                         
<head>                         
<meta charset="UTF-8">         
<title>회원관리</title> 
</head>                        
<body>                  
	<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
		
	<h1>회원추가</h1>
	<form action="${pageContext.request.contextPath }/member/add.do" method="post">
		아이디: <input type="text" name="memId" />  <br />
		비밀번호: <input type="text" name="memPass" />  <br />
		이름: <input type="text" name="memName" />  <br />
		포인트: <input type="text" name="memPoint" />  <br />
	<input type="submit" value="저장" />
</form>

</body>                          
</html>                          
