<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sign-in navbar -->
<div class = "sign-in-navbar">
	<div class = "sign-in-nav-wrap px-3">
		<div class = "sign-in-nav-content">
			Sign in
		</div>
	</div>
</div>
<!-- sign in wrap -->
<div class = "sign-in-wrap mt-5">
	<div class = "sign-in-form-wrap mb-5">
		<!-- ID -->
		<div class="form-floating mb-2">
		  <input type="text" class="form-control" maxlength="10" id="inputId" placeholder="ID">
		  <label for="inputId">ID</label>
		</div>
		
		<!-- PW -->
		<div class="form-floating mb-2">
		  <input type="password" class="form-control" maxlength="10" id="inputPw" placeholder="PW">
		  <label for="inputPw">PW</label>
		</div>
		
	</div>
	
	<div class = "sign-in-btn">
		<button class = "btn btn-primary w-100" id = "joinBtn">sign in</button>
	</div>
	
	<div class = "forgot-password-area mt-4">
		<div align = "center">
			<span class = "forgot-password pointer" data-target-url = "/forgotPassword">암호를 잊으셨습니까?</span>
		</div>
	</div>
</div>