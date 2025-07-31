<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="includes/header.jsp"></jsp:include>

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



<jsp:include page="includes/footer.jsp"></jsp:include>