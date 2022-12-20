<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sign-in navbar -->
<div class = "account-navbar">
	<div class = "account-nav-wrap px-3">
		<div class = "account-nav-content">
			Sign in
		</div>
	</div>
</div>
<!-- sign in wrap -->
<div class = "sign-in-wrap mt-5">
	<div class = "sign-in-form-wrap mb-5">
		<form id = "signInForm">
			<!-- ID -->
			<div class="form-floating mb-2">
			  <input type="text" name = "userEmail" class="form-control" id="inputEmail" placeholder="EMAIL">
			  <label for="inputEmail">이메일</label>
			</div>
			
			<!-- PW -->
			<div class="form-floating mb-2">
			  <input type="password" name = "password" class="form-control" id="inputPw" placeholder="PW">
			  <label for="inputPw">암호</label>
			</div>
		</form>
	</div>
	
	<div class = "sign-in-btn">
		<button class = "btn btn-primary w-100" id = "joinBtn">Sign in</button>
	</div>
	
	<div class = "forgot-password-area mt-4">
		<div align = "center">
			<span class = "forgot-password pointer" data-bs-toggle="modal" data-bs-target="#exampleModalFullscreen">암호를 잊으셨습니까?</span>
		</div>
	</div>
</div>


<!-- 비밀번호 찾기  Modal -->
<div class="modal fade" id="exampleModalFullscreen" tabindex="-1"
	aria-labelledby="exampleModalFullscreenLabel" aria-hidden="true">
	<div class="modal-dialog modal-fullscreen">
		<div class="modal-content">
			<div class="modal-header" style = "justify-content: center;">
				<h5 class="modal-title h4" id="exampleModalFullscreenLabel">비밀번호 찾기</h5>
				<!-- <button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button> -->
			</div>
			<div class="modal-body" style = "text-align: center;margin: auto;width: 360px;height: 400px;margin-top:7rem;">
				<p class = "mb-3"style = "font-size : 15px;margin: 0;line-height: 1.6;">
					가입하신 이메일을 정확히 입력해 주세요.<br>
					이메일을 통해 비밀번호 수정 링크가 전송됩니다.
				</p>
				<div class="form-floating mb-3">
				  <input type="email" class="form-control" id="findpw-email" placeholder=" " aria-describedby="findpw-emailHelp">
				  <label for="findpw-email">Email</label>
				  <div id = "findpw-emailHelp" class="form-error-text findpw-form-error-email">
				   		이메일 형식에 맞지 않습니다.
				   </div>
				</div>
				<input type = "button" id = "findpw-Button" class = "w-100 btn btn-lg" style = "background-color: #495057;color : white;" value = "이메일 전송하기">
			</div>
			<div class="modal-footer">
				<button type="button" id = "findpw-close-btn" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>