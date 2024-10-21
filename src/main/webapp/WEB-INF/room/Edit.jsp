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
		<h2>게시판 수정</h2>

	<form action="<c:url value="/room/updateOk"/>" method="post">
				<div class="mb-3 mt-3">
					<label for="title" class="form-label">제목</label>
					<input type="text" class="form-control" id="title"
					name="title" value="${record.title}">
				</div>
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" rows="5" id="content" name="content" >${record.content}</textarea>
				<button type="submit" class="btn btn-dark mt-2">수정</button>
			</form>

	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
