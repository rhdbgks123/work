<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<jsp:forward page="boardList.do"></jsp:forward>
	<h3>Hello, JSP</h3>
	<c:set var="name" value="홍길동" />
	<!-- String name = "홍길동" 과 같은기능 -->
	<c:out value="${name}" />
	
	<c:choose>
		<c:when test="${name == '홍길동'}">
			<p>정답</p>
		</c:when>
		<c:otherwise>
			<p>오답</p>
		</c:otherwise>
	</c:choose>

	<c:set var="age" value="23" />

	<c:if test="${age >= 20}">
		<p>당신은 성년입니다.</p>
	</c:if>
	
	<!-- if else는 사용 불가능하여 c:choose when otherwise로 사용해야함 -->
	<c:choose>
		<c:when test="${age >= 30}">
			<p style = "color:red;">성년</p>
		</c:when>
		<c:when test="${age >= 20}">
			<p style = "color:red;">청년</p>
		</c:when>
		<c:otherwise>
			<p style = "color:green;">미성년</p>
		</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin = "2" end ="10" step="2">
		<p>2*${i } = ${2*i } </p>
	</c:forEach>

	<!-- JSP에서는꺽쇠 % 안에 JAVA 코드 사용 가능 -->
	<!-- 
	<%
	String msg = "Hello, World";
	System.out.println(msg);
	int age = 20;
	%>
	<p>여기는 HTML 영역입니다</p>
	<%
	if (age >= 20) {
	%>
	<p>성년입니다</p>
	<%
	} else {
	%>
	<p>미성년입니다</p>
	<%
	}
	%>
	 -->
</body>

</html>