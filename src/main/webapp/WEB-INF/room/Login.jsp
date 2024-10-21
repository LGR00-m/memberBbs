<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/Config.jsp" />
<title>Login.jsp</title>

<style>
	form {
		background-color: lightgray;
	}
</style>

</head>
<body>

	<div class="container mt-3 text-center" style="margin-top: 80px">
		<h6>게시판을 이용하시려면, 아이디와 비밀번호를 입력하신 후 로그인 버튼을 클릭해 주세요.</h6>

		<hr />

		<form action="<c:url value="/room/inroom"/>" method="post">
			<div class="row">
				<div class="col mt-3" style="display: inline-block;">
					<span><i class="fa-solid fa-user"></i></span> <input type="text"
						class="form-control" placeholder="아이디 입력?" name="username"
						style="display: inline-block; width: auto;">
				</div>
			</div>

			<div class="row">
				<div class="col mt-3" style="display: inline-block;">
					<span><i class="fa-solid fa-unlock"></i></span> <input
						type="password" class="form-control" placeholder="비밀번호 입력?"
						name="password" style="display: inline-block; width: auto;">
				</div>
			</div>
			
			<div>
				<button type="submit" class="btn btn-dark my-3">로그인</button>	
			</div>				
		</form>
		
	
		<div>
			<a class="btn btn-dark btn-block mt-3" href="<c:url value="/room/inmember"/>">회원가입</a>
		</div>
		
	
	</div>

	<hr/>
	
	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
