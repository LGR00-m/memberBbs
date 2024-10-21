<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/Config.jsp" />
<title>LoginProcess.jsp</title>

<style>
	form {
		background-color: lightgray;
	}
</style>

</head>
<body>
	<jsp:include page="/layout/Header.jsp" />
	<!-- 컨텐츠 시작 -->
	<div class="container mt-3 text-center" style="margin-top: 80px">
		<h6>LoginProcess</h6>

		<hr />
		로그인 성공
		<input type="text" class="form-control" name="username"
						style="display: inline-block; width: auto;" value="${claims.get("sub")}">
						
		
</div>
	
	<!-- 컨텐츠 끝 -->
	<jsp:include page="/layout/Footer.jsp" /> 
</body>
</html>
