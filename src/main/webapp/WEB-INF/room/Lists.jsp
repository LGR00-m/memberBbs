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
	<h2>게시판 목록</h2>
		<div class="my-2 text-end">
			<a href="<c:url value="/room/make"/>" class="btn btn-danger">게시글 등록</a>
		</div>
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

				<c:if test="${empty records}" var="isEmpty">
					<tr>
						<td colspan="5">등록된 자료가 없습니다.</td>
					</tr>

				</c:if>
				<c:if test="${! isEmpty }">
						<c:forEach var="record" items="${records }">
							<tr>
							<td>${record.id}</td>
							<td class="text-start"><a href="<c:url value="/room/moveView?id=${record.id }"/>">${record.title}</a></td>
							<td>${record.username}</td>
							<td>${record.hitcount}</td>
							<td>${record.postDate}</td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>





	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
