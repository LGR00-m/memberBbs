<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/Config.jsp" />
<title>Views.jsp</title>

<style>
th {
	text-align: center;
}
</style>
</head>
<body>

	<jsp:include page="/layout/Header.jsp" />
	<!-- 컨텐츠 시작 -->


	<div class="container mt-3" style="margin-top: 80px">
		<h2>게시판 상세</h2>

 <table class="table table-hover">
        <c:if test="${not empty record}">
            <tbody>
                    <tr>
                        <th class="bg-dark w-25 text-white">번호</th>
                       <td>${record.id}</td>
                    </tr>
                    <tr>
                        <th class="bg-dark w-25 text-white">작성자</th>
                       <td>${record.username}</td>
                    </tr>
                    <tr>
                        <th class="bg-dark w-25 text-white">등록일</th>
                       <td>${record.postDate}</td>
                    </tr>
                    <tr>
                        <th class="bg-dark w-25 text-white">다운수</th>
                        <td id="downCount">${record.hitcount}</td>
                    </tr>
                    <tr>
                        <th class="bg-dark w-25 text-white">제목</th>
                        <td>${record.title}</td>
                    </tr>
                    <tr>
                        <th class="bg-dark w-25 text-white">자료 파일</th>
                        <td>
                            <ul class="list-unstyled">
                                <li></li>
                            </ul>
                        </td>
                    </tr>
                    <tr>
                        <th class="bg-dark text-white" colspan="2">내용</th>
                    </tr>
                    <tr>
                        <td colspan="2">${record.content}</td>
                    </tr>

            </tbody>
        </c:if>
        <c:if test="${empty record}">
            <tbody>
                <tr>
                    <td colspan="2">No records found.</td>
                </tr>
            </tbody>
        </c:if>
    </table>

		<!-- 수정/삭제/목록 컨트롤 버튼 -->
		<div class="text-center">

			<a href="<c:url value='/room/edit?id=${record.id}' />" class="btn btn-primary">수정</a>
			<!-- data-bs-toggle="modal"은 생략. 왜냐하면 삭제시 사용자가 Confirm창에서 확인버튼을 클릭시에만 띄우자 -->
			<a href="#" class="btn btn-primary password-button"
				data-bs-target="#myModal">삭제</a> <a
				href="<c:url value="/room/indexs"/>" class="btn btn-primary">목록</a>
		</div>



		<!-- 컨텐츠 끝 -->
		<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
