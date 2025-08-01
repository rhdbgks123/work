<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = '2' class = 'table'> 

	<thead>
		<tr>
			<th align='center'>ID</th>
			<th align='center'>이름</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="member" items="${member_list}">
		<!-- for(BoardVO board : list) 와 동일  --> 
			<tr>
				<td align='center'>${member.userId}</td>
				<td align='center'>${member.userName}</td>
			</tr>
		</c:forEach>
	</tbody>
</table> 
</body>
</html>