<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.box {
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 4;
    -webkit-box-orient: vertical;
}
.slice-text{
		text-overflow : ellipsis;
		overflow : hidden;
		white-space : nowrap;
	}
</style>
<div class="container mt-5">
    <div class = "area row">
    	<c:forEach var = "board" items="${ boardList }">
    		<div class="col-lg-3 col-md-4 col-12 mb-3">
	            <div class="card" style = "cursor : pointer;" onclick="location.href='/moim/post/${board.boardNo}'">
	                <div class="card-body">
	                  <h5 class="card-title slice-text" style = 'user-select: none;'>${board.subject }</h5>
	                  <div class="card-text slice-text" style = 'user-select: none;'>모임종류 : 스터디</div>
	                  <div class="card-text slice-text" style = 'user-select: none;'>마감기한 : ${ board.deadlineDate }</div>
	                </div>
	            </div>
	        </div>
    	</c:forEach>
    </div>
</div>

<%-- <c:forEach var = "board" items="${ boardList }">
	${board.subject }<br>
	${board.content }<br>
	${board.category }<br>
	${board.userEmail }
</c:forEach> --%>