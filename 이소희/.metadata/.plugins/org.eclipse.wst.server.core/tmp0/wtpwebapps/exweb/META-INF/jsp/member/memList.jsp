
<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!DOCTYPE html>          
		<html>                        
		<head>                        
		<meta charset='UTF-8'>        
		<title>회원 관리</title>;
		</head>                     
		<body>                 
		<h1>회원 목록</h1> 
		<a href='<%=request.getContextPath()%>/member/addform.do'>회원 추가</a><br/>
		
<% 		//요청 객체에 memList라는 이름으로 저장되어있는 데이터 가져오기
		ArrayList<MemberVo> list  = (ArrayList<MemberVo>)request.getAttribute("memList"); 
		for (MemberVo vo : list) {
%>

	<a href='<%=request.getContextPath()%>/member/editform.do?memId=<%=vo.getMemId()%>'><%=vo.getMemId()%></a>
				 : <%=vo.getMemPass() %> : <%=vo.getMemName()%> : <%=vo.getMemPoint()%>
				<br/>
				
<%
			}
		
%>
	</body>                        
	</html>                        


    

    