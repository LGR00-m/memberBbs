<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<h2>게시판 등록</h2>

	<form action="<c:url value="/room/makeok"/>" method="post">
				<div class="mb-3 mt-3">
					<label for="title" class="form-label">제목</label> <input
						type="text" class="form-control" id="title"
						placeholder="제목 입력?" name="title">
				</div>
				<label for="content" class="form-label">내용</label>
				<textarea placeholder="내용 입력?" class="form-control" rows="5" id="content" name="content"></textarea>
				<button type="submit" class="btn btn-dark mt-2">등록</button>
			</form>

	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
