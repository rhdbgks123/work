<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <h3>register_form.jsp</h3>
	<form action='addBoard.do' method = 'post' enctype="multipart/form-data"> 
	<!-- from에서 action은 전달할 페이지  // method 요청방식 post는 주소표시줄에 보이지 않음, get은 보임 -->
	<!-- 파일 형식은 enctype="multipart/fom-data" 필수, method는 반드시 post로 등록해야함 get방식은 주소표시줄에 너무 큰 데이터가 넘어감 -->
	<input type='hidden' required name='writer' class="form-control" value ="${logId }">
		<table class='table' border='1'>
			<tr>
				<th class= "table-primary">제목</th>
				<td><input type='text' required name='title' class="form-control"></td>
			</tr>
			<tr>
				<th class= "table-primary">작성자</th>
				<td>${logId }</td>
			</tr>
			<tr>
				<th class= "table-primary">내용</th>
				<td><textarea required name='content' class="form-control"></textarea></td>
			</tr>
			<tr>
				<th class= "table-primary">이미지</th>
				<td><input type="file" name="images" class ='form-control'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit' value ='등록' class = 'btn btn-primary'></td>
			</tr>
		</table>
	</form>