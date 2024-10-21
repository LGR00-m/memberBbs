<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/Config.jsp" />
<title>List.jsp</title>
</head>
<body>

	<jsp:include page="/layout/Header.jsp" />
	<!-- 컨텐츠 시작 -->


	<div class="container mt-3" style="margin-top: 80px">
		<h2>게시판 목록</h2>
	

		<table class="table">
			<thead class="table-active">
				<tr>
					<th class="col-1">번호</th>
					<th class="col-auto">제목</th>
					<th class="col-2">작성자</th>
					<th class="col-1">조회수</th>
					<th class="col-2">작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2</td>
					<td>제목입니다</td>
					<td>홍길동</td>
					<td>7</td>
					<td>2024-06-23</td>
				</tr>
			</tbody>
		</table>
	</div>





	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
