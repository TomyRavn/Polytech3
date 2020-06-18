<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
		<html>                           
		<!DOCTYPE html>                  
		<head>                           
		<meta charset='UTF-8'>           
		<title>게시판</title> 
		<style>
			a, a:visited{
				text-decoration: none;
				color:blue;
			}
			table{
				border: 1px solid #ccc;
				color:black;
				border-collapse:collapse;
			}
			th {
				text-align:center;
				border: 1px solid #ccc;
				color:black;
			}
		</style>
		</head>
		            
		<body align="center" bgcolor=#66FFCC>
		
			<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
			                           
			<h1>[ 게시글 목록 ]</h1>
		
			<a href='${pageContext.request.contextPath}/bbs/add.do'><button>글 작성</button></a></br></br>
			
			<table align="center">
				<thead>
					<tr><th>글번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>최종 수정일</th><th>조회수</th>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${bbsList}">
						<tr>
							<th>${vo.bbsNo}</th> <th><a href='${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}'><b> ${vo.bbsTitle} </b></a></th> <th>${vo.bbsWriter}</th> <th><fmt:formatDate value="${vo.bbsRegDate}" pattern="yyyy/MM/dd HH:mm:ss"/></th> <th><fmt:formatDate value="${vo.bbsEditDate}" pattern="yyyy/MM/dd HH:mm:ss"/></th> <th>${vo.bbsCount}</th>
 						</tr>
 					</c:forEach>
				</tbody>
			</table>
		
		</body>   
	</html>