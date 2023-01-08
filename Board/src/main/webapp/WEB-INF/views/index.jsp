<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모임</title>
    <link rel = "icon" href = "/css/img/free-icon-meeting-4144517.png">
    <!-- index css -->
    <link rel = "stylesheet" href = "/css/common.css">
    <!-- navbar css -->
    <link rel = "stylesheet" href = "/css/navbar.css">
    <!-- mainContents css -->
    <link rel = "stylesheet" href = "/css/${ mainCss }.css">
    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"/>
</head>
<body>
	<div id = "overlay">
		<div class="spinner-border spinner" role="status">
		  <span class="visually-hidden"></span>
		</div>
	</div>

	<!-- 네이게이션 바 -->
    <jsp:include page="navbar.jsp"></jsp:include>
    <!-- 메인 컨텐츠 네비바 -->
	<div class = "main-contents-navbar">
		<div class = "main-contents-nav-wrap px-3">
			<div class = "main-contents-nav-content">
				${ pageName }
			</div>
		</div>
	</div>
	<!-- 메인 컨텐츠 -->
    <jsp:include page="${ mainContents }.jsp"></jsp:include>
    <!-- footer -->
    <!-- <div class = "mt-5" style = "background-color: rgb(51, 51, 51);width : 100%;height : 200px;"></div> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.2.min.js"></script>
    <!-- 스와이프 js -->
	<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
    <script src = "/js/common.js"></script>
	<script src = "/js/navbar.js"></script>
	<script src = "/js/${ mainJs }.js"></script>
</body>
</html>