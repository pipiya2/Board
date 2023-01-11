<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class = "makeMoim-wrap mt-5">

	<form id = "board-write-form" class = "board-write-form" enctype = "multipart/form-data">
		<div class = "category-area">
			<span style = "padding-right : 15px;">모임종류 :</span>
			
			<div class = "category-radio-area">
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="category" id="categoryStudy" value = 'study'checked>
				  <label class="form-check-label" for="categoryStudy">
				    스터디
				  </label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="category" id="categoryHealth" value = 'health'>
				  <label class="form-check-label" for="categoryHealth">
				    운동
				  </label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="category" id="categoryMeal" value = 'meal'>
				  <label class="form-check-label" for="categoryMeal">
				    식사
				  </label>
				</div>
				<div class="form-check form-check-inline" style = "margin-right : 0;">
				  <input class="form-check-input" type="radio" name="category" id="categoryAlcohol" value = 'alcohol'>
				  <label class="form-check-label" for="categoryAlcohol">
				    술자리
				  </label>
				</div>
			</div>
		</div>
		<input type = "text" placeholder = "제목" id = "boardSubject" name = "subject" class = "write-form-header">
		<div class="form-floating">
			<textarea rows = "13" id = "boardContent" name = "content" placeholder = "내용을 입력하세요"></textarea>	
		</div>
	</form>
	<button class = "btn btn-primary" id = 'testBtn'>test</button>
</div>
