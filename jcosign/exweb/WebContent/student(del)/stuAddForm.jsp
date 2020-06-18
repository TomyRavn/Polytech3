<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>                
<html>                         
<head>                         
<meta charset='UTF-8'>         
<title>회원관리</title> 
</head>                        
<body>                         

<h1>회원추가</h1>
<form action='<%= request.getContextPath() %>/student/stuAdd.jsp' method='post'>
	아이디: <input type='text' name='stuNo' />  <br />
	이름: <input type='text' name='stuName' />  <br />
	포인트: <input type='text' name='stuScore' />  <br />
<input type='submit' value='저장' />
</form>

</body>                          
</html>                          
