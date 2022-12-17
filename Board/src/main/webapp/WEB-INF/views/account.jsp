<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- account navbar -->
<div class = "join-navbar">
	<div class = "join-nav-wrap px-3">
		<div class = "join-nav-content">
			JOIN
		</div>
	</div>
</div>
<!-- account wrap -->
<div class = "join-wrap mt-5">
	<div class = "join-form-wrap mb-5">
		<!-- // 이름 -->
		<div class="form-floating mb-2">
		  <input type="text" class="form-control" id="inputName" placeholder="이름">
		  <label for="inputName">이름</label>
		</div>
		<!-- // 생년월일 -->
		<div class="form-floating mb-2">
		  <input type="text" class="form-control" id="inputBirth" placeholder="생년월일">
		  <label for="inputBirth">생년월일</label>
		</div>
		<!-- // 전화번호 -->
		<div class="form-floating mb-5">
		  <input type="number" class="form-control" id="inputPhone" placeholder="전화번호">
		  <label for="inputPhone">전화번호</label>
		</div>
		<!-- // 이메일 -->
		<div class="form-floating mb-2">
		  <input type="email" class="form-control" id="inputEmail" placeholder="example@ex.ex">
		  <label for="inputEmail">이메일</label>
		</div>
		<!-- // 암호 -->
		<div class="form-floating mb-2">
		  <input type="password" class="form-control" id="inputPassword" placeholder="암호">
		  <label for="inputPassword">암호</label>
		</div>
		<!-- // 암호 재확인 -->
		<div class="form-floating">
		  <input type="password" class="form-control" id="inputPasswordCheck" placeholder="암호 확인">
		  <label for="inputPasswordCheck">암호 확인</label>
		</div>
	</div>
	
	<div style = "max-width : 100px;margin : auto">
		<button class = "btn btn-primary w-100">가입</button>
	</div>
</div>
