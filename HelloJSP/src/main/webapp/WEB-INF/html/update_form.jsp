<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="includes/header.jsp"></jsp:include>

<h3>글 수정 화면</h3>
<form action="update.do">
<input type="hidden" value="${board_info.boardNo }" name ="bno">
<table border = '2' class = 'table'> 
  <tr> 
    <th>글번호</th> 
    <td><c:out value="${board_info.boardNo }" /></td> 
    <th>조회수</th> 
    <td><c:out value="${board_info.viewCnt}" /></td> 
  </tr> 
  <tr> 
    <th>제목</th> 
    <td colspan='3'><input type = "text" name ="title" value="${board_info.title}" class="form-control"/></td> 
  </tr> 
  <tr> 
    <th>내용</th> 
    <td colspan='3'><textarea name="content"class="form-control">${board_info.content}</textarea></td> 
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
  	<input type ="submit" value = "저장" class = "btn btn-success">
	<button type ="button" class = "btn btn-secondary">취소</button>
	</td>
</tr>
</table> 
</form>
<a href = 'remove.do?bno=<c:out value="${board_info.boardNo }" />'>글삭제</a>



<jsp:include page="includes/footer.jsp"></jsp:include>