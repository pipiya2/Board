<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class = "container changePassword-wrap">
	<h3 class = "mb-5">비밀번호 변경</h3>
	<form class = "changePassword-form">
		<div class="mb-3">
		   <label for="change-password" class="form-label">비밀번호</label>
		   <input type="password" autocomplete="one-time-code" placeholder= "*******" class="form-control" name = "userPassword" id="change-password">
		   <div class="form-text form-error-pw">
		   		<span id = "f_valid">영문/숫자/특수문자 2가지 이상 포함</span><br>
		   		<span id = "s_valid">8자 이상 32자 이하 입력 (공백 제외)</span><br>
		   		<span id = "t_valid">연속 3자 이상 동일한 문자/숫자 제외</span>
		   </div>
		 </div>
		 
		 <div class="mb-3">
		   <label for="change-password-check" class="form-label">비밀번호 확인</label>
		   <input type="password" autocomplete="one-time-code" placeholder= "*******" class="form-control" id="change-password-check">
		   <div class="form-text text-muted form-error-pw-check">
		   		비밀번호가 일치하지 않습니다.
		   </div>
		 </div>
		 <input type="button" id = "changPassword_btn" class="btn w-100 mt-3" style = "background-color: #d52424;color : white;font-weight: bold" value = "비밀번호 변경하기">
	</form>
</div>