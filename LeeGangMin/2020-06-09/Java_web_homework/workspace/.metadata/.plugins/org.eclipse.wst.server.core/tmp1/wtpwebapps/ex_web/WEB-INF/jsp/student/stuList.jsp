<%@page import="kr.ac.kopo.student.StudentVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
		<html>                           
		<!DOCTYPE html>                  
		<head>                           
		<meta charset='UTF-8'>           
		<title>학생관리</title> 
		<style>
		a, a:visited{
		text-decoration: none;
		color:black;
		}
		</style>
		</head>                          
		<body>                           
			<h1>학생목록</h1>     
		
		<a href='<%= request.getContextPath() %>/student/addform.do'><button>학생추가</button></a></br></br>
		
		<%
		ArrayList<StudentVo> studentList = (ArrayList<StudentVo>)request.getAttribute("stuList");	//요청객체에 "stuList"라는 이름으로 저장되어 있는 데이터 가져오기
		
		
		for (StudentVo vo : studentList) {
		%>
			<a href='<%= request.getContextPath() %>/student/editform.do?stuNo=<%=vo.getStuNo()%>'><b> <%=vo.getStuNo()%> </b></a> : <%=  vo.getStuName() %> : <%= vo.getStuScore() %> </br>
		<% 
		}
		%>
		===================================
		
		</body>                          
		</html>                          