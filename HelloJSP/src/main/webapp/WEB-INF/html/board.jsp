<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>

<%
BoardVO board = (BoardVO) request.getAttribute("board_info");
%>
<table border = '2' class = 'table'> 
  <tr> 
    <th>글번호</th> 
    <td><%=board.getBoardNo()%></td> 
    <th>조회수</th> 
    <td><%=board.getViewCnt()%></td> 
  </tr> 
  <tr> 
    <th>제목</th> 
    <td colspan='3'><%=board.getTitle()%></td> 
  </tr> 
  <tr> 
    <th>내용</th> 
    <td colspan='3'><%=board.getContent()%></td> 
  </tr> 
  <tr> 
    <th>작성자</th> 
    <td colspan='3'><%=board.getWriter()%></td> 
  </tr> 
  <tr> 
    <th>작성일자</th> 
    <td colspan='3'><%=board.getCreateDate()%></td> 
  </tr> 
</table> 
<a href = 'remove.do?bno=<%=board.getBoardNo()%>'>글삭제</a>
<a href = 'boardList.do'>글목록</a>



<jsp:include page="includes/footer.jsp"></jsp:include>