<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <%BoardVO board = (BoardVO) request.getAttribute("board_info");%> -->
<h3>글 상세 화면</h3>

<c:if test="${!empty msg }">
	<div style = "color:red;">${msg }</div>
</c:if>

<form action="modifyForm.do">
	<input type="hidden" value="${board_info.boardNo }" name ="bno">
	<input type="hidden" value="${page}" name ="page">
	<table border = '2' class = 'table'> 
	  <tr> 
	    <th>글번호</th> 
	    <!-- <td><%=board.getBoardNo()%></td> -->
	    <td><c:out value="${board_info.boardNo }" /></td> 
	    <th>조회수</th> 
	    <td><c:out value="${board_info.viewCnt}" /></td> 
	  </tr> 
	  <tr> 
	    <th>제목</th> 
	    <td colspan='3'><c:out value="${board_info.title}" /></td>
	    <c:choose>
	    	<c:when test="${!empty board_info.image }">
			    <td rowspan='2'><img width="130px" height="100px" alt="" src="upload/${board_info.image }"></td> 
	    	</c:when>
	    	<c:otherwise>
	    	    <td rowspan='2'><img alt="" src="https://dummyimage.com/130X100/000/fff&text=no+image"></td>
	    	</c:otherwise>
	    </c:choose>
	  </tr> 
	  <tr> 
	    <th>내용</th> 
	    <td colspan='3'><c:out value="${board_info.content}" /></td> 
	  </tr> 
	  <tr> 
	    <th>작성자</th> 
	    <td colspan='3'><c:out value="${board_info.writer}" /></td> 
	  </tr> 
	  <tr> 
	    <th>작성일자</th> 
	    <td colspan='3'><c:out value="${board_info.createDate}" /></td> 
	  </tr>
	  <tr>
		  <td colspan = "4" align="center">
		  <input type ="submit" value = "수정" class = "btn btn-success">
		  <button type ="button" onclick="location.href='remove.do?bno=${board_info.boardNo}'" class = "btn btn-danger" ${logId eq board_info.writer ? '' : 'disabled' }>삭제</button>
		  </td>  	
	  </tr>
	</table> 
</form>

<!-- 댓글 달기 -->
<style>
span 
{
	display : inline-block;
}
ul
{
	list-style-type: none;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {
  background-color: #ddd;
  border-radius: 5px;
}
</style>
<div class="container reply">
	<!-- 댓글 등록 -->

	<div class ="header">
		<input type="text" id="reply" class="col-sm-8">
		<button id="registerReply" class="btn btn-secondary">댓글등록</button>
	</div>

	<!-- 댓글 목록 -->

	<div class = "content">
		<ul>
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="con-sm-1">삭제</span>
			</li>
			<li><hr /></li>
		</ul>
	</div>

	<!-- 댓글 페이징 -->

	<div class ="footer">
	<div class="pagination">
	  <a href="#">&laquo;</a>
	  <a href="#">1</a>
	  <a href="#" class="active">2</a>
	  <a href="#">3</a>
	  <a href="#">4</a>
	  <a href="#">5</a>
	  <a href="#">6</a>
	  <a href="#">&raquo;</a>
	</div>
	</div>
</div>
<!-- js에서는 바로 변수값을 받을 수 없어서 jsp 페이지에서 script로 별도 변수 선언 필요 -->
<!-- 달러중괄호 정보는 jsp 페이지 안에서만 처리 가능해서 아래 변수 선언 -->
<script>
	const bno = "${board_info.boardNo }";
	const logId = "${logId}";
</script>

<script type="text/javascript" src = "js/boardService.js"></script>
<script type="text/javascript" src = "js/board.js"></script>
