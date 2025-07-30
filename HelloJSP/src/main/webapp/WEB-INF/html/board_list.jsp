<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="includes/header.jsp" />
<!-- request.getAttribute는 무조건 Object타입, 그래서 원하는 형식으로 변경 가능 -->
<!-- 검색 -->
<div class="center">
	<form action="boardList.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${search.searchCondition == 'T' ? 'selected' : ''}>제목</option>
					<option value="W" ${search.searchCondition == 'W' ? 'selected' : ''}>작성자</option>
					<option value="TW" ${search.searchCondition == 'TW' ? 'selected' : ''}>제목&작성자</option>
				</select>
			</div>
			<div class="col-sm-5">
				<input type="text" name="keyword" class="form-control" value = "${search.keyword}" >
			</div>
			<div class="col-sm-3">
				<input type="submit" value="조회" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>
<!--검색-->
<table border='2' class='table table-striped'>
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="board" items="${board_list}">
		<!-- for(BoardVO board : list) 와 동일  --> 
			<tr>
				<td align='center'><c:out value = "${board.boardNo}" /></td>
				<td><a href='board.do?bno=<c:out value = "${board.boardNo}" />'><c:out value = "${board.title}" /></a></td>
				<td><c:out value = "${board.writer}" /></td>
				<td><c:out value = "${board.viewCnt}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${paging.prev }">
				<li class="page-item"><a class="page-link" href="boardList.do?page=${paging.start - 1}&searchCondition=${search.searchCondition}&keyword=${search.keyword}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Previous</a></li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="p" begin="${paging.start}" end ="${paging.end }">
			<c:choose>
				<c:when test="${paging.curPage == p}">
					<li class="page-item active" aria-current="page"><span class="page-link">${p}</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="boardList.do?page=${p}&searchCondition=${search.searchCondition}&keyword=${search.keyword}">${p}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${paging.next }">
				<li class="page-item"><a class="page-link" href="boardList.do?page=${paging.end + 1}&searchCondition=${search.searchCondition}&keyword=${search.keyword}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Next</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</nav>
<form action = 'register.do'>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
<button class="btn btn-primary" type="submit">신규</button>
</div>
</form>
<jsp:include page="includes/footer.jsp" />