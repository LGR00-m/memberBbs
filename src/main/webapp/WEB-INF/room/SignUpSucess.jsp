<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/Config.jsp" />
<title>SignUp.jsp</title>

<style>
fieldset {
	background-color: lightgray;
}
</style>

</head>
<body>

	<div class="container mt-3" style="margin-top: 80px">
		<div class="p-5 bg-dark text-white">
			<h1>회원가입 완료</h1>
		</div>
		<fieldset class="border rounded-3 p-3">
			<legend>아래 정보들을 입력해서 가입 해주세요.</legend>

			<hr />
			<form action="<c:url value="/room/inroom"/>" method="get">
				<div class="mb-3 mt-3">
					<label for="name" class="form-label">이름</label> <input type="text"
						class="form-control" id="name" placeholder="이름 입력" name="name" value="${param.name}">
				</div>
				<div class="mb-3 mt-3">
					<label for="username" class="form-label">아이디</label> <input
						type="text" class="form-control" id="username"
						placeholder="아이디 입력" name="username" value="${param.username}">
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">비밀번호</label> <input
						type="password" class="form-control" id="password"
						placeholder="비밀번호 입력" name="password" value="${param.password}">
				</div>

				<div class="mb-3">
					<label class="form-label">성별</label>
					<div class="d-flex">
						<div class="form-check">
							<input type="radio" class="form-check-input" id="radio1"
								name="gender" value="남자"> <label
								class="form-check-label" for="radio1">남자</label>
						</div>
						<div class="form-check mx-3">
							<input type="radio" class="form-check-input" id="radio2"
								name="gender" value="여자"> <label
								class="form-check-label" for="radio2">여자</label>
						</div>
					</div>
					<div class="my-3">
						<label class="form-label">관심사항</label>
						<div class="d-flex">
							<div class="form-check">
								<input type="checkbox" class="form-check-input" id="check1"
									name="inter" value="정치"> <label
									class="form-check-label" for="check1">정치</label>
							</div>
							<div class="form-check mx-3">
								<input type="checkbox" class="form-check-input" id="check2"
									name="inter" value="경제"> <label
									class="form-check-label" for="check2">경제</label>
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" id="check3"
									name="inter" value="스포츠"> <label
									class="form-check-label" for="check3">스포츠</label>
							</div>
							<div class="form-check mx-3">
								<input type="checkbox" class="form-check-input" id="check4"
									name="inter" value="연예"> <label
									class="form-check-label" for="check4">연예</label>
							</div>
						</div>
					</div>
					<label for="sel1" class="form-label">학력사항</label> <select
						class="form-select" id="sel1" name="grade">
						<option value="">학력을 선택하세요</option>
						<option value="ele">초등학교</option>
						<option value="mid">중학교</option>
						<option value="hig">고등학교</option>
						<option value="uni">대학교</option>
					</select>
					<div class="my-3">
						<label for="files" class="form-label">첨부파일</label> <input
							type="file" class="form-control" id="files" name="files" multiple>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">게시판 가기</button>
			</form>
	</div>
	</fieldset>
	</div>
	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
	

	
	
	
	
</body>


</html>
