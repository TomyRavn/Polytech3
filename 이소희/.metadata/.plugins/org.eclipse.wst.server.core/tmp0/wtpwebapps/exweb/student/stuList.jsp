<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.student.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

      <!DOCTYPE html>
      <html>
      <head>
      <meta charset='UTF-8'>
      <title>학생 관리</title>
      </head>
      <body>
      
      <h1>학생 목록</h1>
      <a href='<%=request.getContextPath()%>/student/addform.do'>학생 추가</a><br/>
  <% ArrayList<StudentVo> list  = (ArrayList<StudentVo>)request.getAttribute("stuList"); 
	for (StudentVo vo : list) {
		%>
		
		<a href='<%=request.getContextPath()%>/student/editform.do?stu_no=<%=vo.getStuNo()%>'>
		<%=vo.getStuNo()%></a>
      	: <%=vo.getStuName()%> : <%=vo.getStuScore()%>
      	<br/>
	<%		
}  
	%>
      </body>
      </html>
