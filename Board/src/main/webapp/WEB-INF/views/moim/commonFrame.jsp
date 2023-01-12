<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <div class = "area row">
    	<c:forEach begin="1" end="${ count }">
    		<div class="col-lg-3 col-md-4 col-12 mb-4"style="">
	            <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title">Card title</h5>
	                  <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
	                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	                </div>
	            </div>
	        </div>
    	</c:forEach>
    </div>
</div>