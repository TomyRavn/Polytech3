<%@page import="kr.ac.kopo.member.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
		<html>                           
		<!DOCTYPE html>                  
		<head>                           
		<meta charset='UTF-8'>           
		<title>회원관리</title> 
		<style>
		a, a:visited{
		text-decoration: none;
		color:black;
		}
		</style>
		</head>                          
		<body>                           
			<h1>회원목록</h1>     
		
		<a href='<%= request.getContextPath() %>/member/addform.do'><button>회원가입</button></a></br></br>
		
		<%
		ArrayList<MemberVo> memberList = (ArrayList<MemberVo>)request.getAttribute("memList");	//요청객체에 "memList"라는 이름으로 저장되어 있는 데이터 가져오기
		
		
		for (MemberVo vo : memberList) {
		%>
			<a href='<%= request.getContextPath() %>/member/editform.do?memId=<%=vo.getMemId()%>'><b> <%=vo.getMemId()%> </b></a> : <%= vo.getMemPass() %> :  <%=  vo.getMemName() %> : <%= vo.getMemPoint() %> </br>
		<% 
		}
		%>
		===================================
		
		</body>                          
		</html>                          