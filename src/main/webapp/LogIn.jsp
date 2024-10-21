<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/Config.jsp" />
<title>Login.jsp</title>
</head>
<body>

	<div class="container mt-3" style="margin-top: 80px">
		<h2>게시판을 이용하시려면 로그인 해주세요.</h2>

		<form>
			<div class="row">

				<button type="submit" class="btn btn-primary mt-3">LogIn</button>
				<button type="button" class="btn btn-dark btn-block mt-3">회원가입</button>
			</div>


		</form>
	</div>


	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" />
</body>
</html>
