<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <jsp:include page="includes/header.jsp" />
   <h3>register_form.jsp</h3>
	<form action='addBoard.do' method = 'post'> <!-- from에서 action은 전달할 페이지  // method 요청방식 post는 주소표시줄에 보이지 않음, get은 보임 -->
		<table class='table' border='1'>
			<tr>
				<th class= "table-primary">제목</th>
				<td><input type='text' required name='title' class="form-control"></td>
			</tr>
			<tr>
				<th class= "table-primary">작성자</th>
				<td><input type='text' required name='writer' class="form-control"></td>
			</tr>
			<tr>
				<th class= "table-primary">내용</th>
				<td><textarea required name='content' class="form-control"></textarea></td>
			</tr>
			<tr>
				<td colspan='2' align='center' ><input type='submit' value ='등록' class = 'btn btn-primary'></td>
			</tr>
		</table>
	</form>
	<jsp:include page="includes/footer.jsp" />