<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>

<h1>학생추가</h1>	
	<form action='<%=request.getContextPath()%>/Student/StudentAdd.jsp' method='post'>
		학번:<input type='text'name='stuNO' /><br/>
		이름:<input type='text' name='stuName'/><br/> 
		점수:<input type='text' name='stuScore'/><br/>	
	<input type='submit' value='저장'/><br/>	
	</form>	

</body>
</html>	