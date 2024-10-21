<%@page import="util.JWTokens"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 상단 네비게이션 바 -->
<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown"><i class="fa-solid fa-house"></i></a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">게시글 등록</a></li>
					<li><a class="dropdown-item" href="<c:url value="/room/indexs" />">전체 게시글</a></li>
				</ul>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown"><i class="fa-solid fa-file"></i></a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">자료실 등록</a></li>
					<li><a class="dropdown-item" href="#">전체 자료실</a></li>
				</ul>
			</li>
		</ul>
		<div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
			<ul class="navbar-nav">
		
		<c:choose>
		<c:when test="${not empty cookie['TOKEN-NAME'] }">
				<li class="nav-item"><a class="nav-link" href="<c:url value="/room/inroom"/>">
				<i class="fa-solid fa-user"></i> LogIn
				</a></li>
		</c:when>
		<c:otherwise>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/room/outroom"/>">
				<i class="fa-solid fa-user"></i> LogOut		
				</a></li>
		</c:otherwise>
		</c:choose>
			</ul>
		</div>
	</div>
</nav>

	<div class="container-fluid" style="margin-top: 80px">
		<h3></h3>
	</div>

<!-- 하단 네비게이션 바 -->

<nav class="navbar navbar-expand-sm bg-light navbar-light fixed-bottom">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Fixed bottom</a>
	</div>
</nav>