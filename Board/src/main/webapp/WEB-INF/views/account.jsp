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
		  <input type="text" class="form-control" maxlength="10" id="inputName" placeholder="이름">
		  <label for="inputName">이름</label>
		</div>
		<!-- // 생년월일 -->
		<div class="form-floating mb-5">
		  <input type="date" class="form-control" id="inputBirth" placeholder="생년월일">
		  <label for="inputBirth">생년월일</label>
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
		  <div class="form-error-text form-error-pw mt-1">
		   		<span id = "f_valid">특수문자(`~!@#$%^&*.|'";:/?), 숫자 포함</span><br>
		   		<span id = "s_valid">8자 이상 32자 이하 입력</span><br>
		   		<span id = "t_valid">연속 3자 이상 동일한 문자/숫자 제외</span>
		   </div>
		</div>
		<!-- // 암호 재확인 -->
		<div class="form-floating">
		  <input type="password" class="form-control" id="inputPasswordCheck" placeholder="암호 확인">
		  <label for="inputPasswordCheck">암호 확인</label>
		  <div class="form-error-text form-error-pw-check mt-1">
		   		비밀번호가 일치하지 않습니다.
		   </div>
		</div>
	</div>
	
	<div style = "max-width : 100px;margin : auto">
		<button class = "btn btn-primary w-100" id = "joinBtn">가입</button>
	</div>
</div>
