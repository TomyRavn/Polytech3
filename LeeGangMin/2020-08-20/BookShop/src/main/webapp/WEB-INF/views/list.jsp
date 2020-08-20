<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.active{
	background-color: red;
}
</style>
</head>
<body>
	<div>
		<h1>도서목록</h1>
		<div>
			<form method="get" action="">
				<span>
<!-- 				value값을 컬럼명과 동일한 방식으로 설정하여 back에 있는 것을 유추할 수 있게 하면 보안상 위험  -->
					<select name="search">
						<option value="0">선택</option>
						<option value="1" ${pager.search == 1? 'selected' : ''}>도서번호</option>
						<option value="2" ${pager.search == 2? 'selected' : ''}>도서명</option>
						<option value="3" ${pager.search == 3? 'selected' : ''}>출판사</option>
						<option value="4" ${pager.search == 4? 'selected' : ''}>가격</option>
					</select>
				</span>
				<span>
					<input type="text" name="keyword" placeholder="검색어를 입력해주세요" value="${pager.keyword}">
				</span>
				<span>
					<input type="submit" value="검색">
				</span>
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th><a href="?page=${pager.page}&${pager.query}&header=1&order=${pager.header == 1 ? (pager.order + 1) % 2 : 0}">도서번호</a></th>
						<th><a href="?page=${pager.page}&${pager.query}&header=2&order=${pager.header == 2 ? (pager.order + 1) % 2 : 0}">도서명</a></th>
						<th><a href="?page=${pager.page}&${pager.query}&header=3&order=${pager.header == 3 ? (pager.order + 1) % 2 : 0}">출판사</a></th>
						<th><a href="?page=${pager.page}&${pager.query}&header=4&order=${pager.header == 4 ? (pager.order + 1) % 2 : 0}">가격</a></th>
						<th>관리</th>	
					</tr>
				</thead>
				<tbody>
<!-- 				choose : 있는지 없는지 판단 / if for 구조보다 깔끔하다?-->
					<c:choose>
						<c:when test="${list.size() > 0}">
							<c:forEach var="item" items="${list}">
								<tr>
									<td>${item.bookid}</td>
									<td>${item.bookname}</td>
									<td>${item.publisher}</td>
									<td>${item.price}</td>
									<td><a href="${item.bookid}/delete">삭제</a> <a href="${item.bookid}/update">변경</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5">등록된 도서가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			<div>
				<div><a href="?page=1&${pager.query}&${pager.sort}">처음</a></div>
				<div><a href="?page=${pager.prev}&${pager.query}&${pager.sort}">이전</a></div>
				<ul>
					<c:forEach var="page" items="${pager.list}">
						<li class="${ page == pager.page ? 'active' : '' }"><a href="?page=${page}&${pager.query}&${pager.sort}">[${page}]</a></li>
					</c:forEach>
				</ul>
				<div><a href="?page=${pager.next}&${pager.query}&${pager.sort}">다음</a></div>
				<div><a href="?page=${pager.last}&${pager.query}&${pager.sort}">마지막</a></div>
			</div>
		</div>
		
		<div>
			<a href="add">등록</a>
		</div>
		<div>
			<a href="dummy">대량등록</a>
		</div>
		<div>
			<a href="init">초기화</a>
		</div>
	</div>
</body>
</html>