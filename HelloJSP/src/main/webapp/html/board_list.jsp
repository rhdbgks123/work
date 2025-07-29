<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<%
	BoardService srv = new BoardServiceImpl();
	List<BoardVO> list = srv.boardList();
	%>
	<table border = '2'>
	  <thead> 
	    <tr> 
	      <th>글번호</th> 
	      <th>글제목</th> 
	      <th>작성자</th> 
	      <th>조회수</th> 
	    </tr> 
	  </thead> 
	  <tbody> 
	<%
	for(BoardVO board : list)
	{
	%>
	<tr> 
	  <td align='center'><a href = '../board?board_no=<%=board.getBoardNo()%>'><%=board.getBoardNo()%></a></td> 
	  <td><%=board.getTitle()%></td> 
	  <td><%=board.getWriter()%></td> 
	  <td><%=board.getViewCnt()%></td> 
	</tr>
	<% 
	}
	%>
	  </tbody> 
	</table> 
	<a href = '/HelloJSP/html/register_form.html'>신규</a>
	
</body>
</html>