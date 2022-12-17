<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class = "navbar">
   <div class = "contents px-3">
   	<!-- pc -->
       <div class="pc-area">
       	<!-- 사이트 메뉴 공간 -->
           <div style = "display : flex;">
               <div class="pointer pc-homeIcon go-flag" data-targetUrl = '/'>
                   <svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                       <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146ZM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5Z"/>
                   </svg>
               </div>
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/all'>모든모임</div>
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/study'>스터디</div>
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/health'>운동</div>
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/meal'>식사</div>
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/alcohol'>술자리</div>
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/make'>모임만들기</div>
           </div>
           
           <!-- 회원정보,로그인 공간 -->
           <div style = "display : flex;">
               <div class="pc-menu-item menu-name pointer go-flag" data-targetUrl = '/sign-in'>
                   <!-- <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-person" aria-expanded="true" viewBox="0 0 16 16">
                       <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                   </svg> -->
                   로그인
               </div>
               <div class = "pc-menu-item menu-name pointer go-flag" data-targetUrl = '/account'>
               	회원가입
               </div>
           </div>
           <!-- <div class="menu-item">내모임</div>
           <div class="menu-item">로그인</div>
           <div class="menu-item">회원가입</div>
           <div class="menu-item">회원정보수정</div> -->
       </div>
       
       <!-- 모바일 -->
        <div class="mobile-area">
        	<!-- menu -->
        	<div class = "mobile-left">
				<svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-list pointer" viewBox="0 0 16 16">
				  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
				</svg>
			</div>
			<!-- home -->
            <div class="mobile-header">
     	       <svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" data-targetUrl = '/' class="bi bi-house-door pointer go-flag" viewBox="0 0 16 16">
	               <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146ZM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5Z"/>
               </svg>
         	</div>
            <!-- 회원정보,로그인 공간 -->
           <div class = "mobile-right">
               <div class = "mobile-menu-item menu-name pointer go-flag" data-targetUrl = '/sign-in'>
                   로그인
               </div>
               <div class = "mobile-menu-item menu-name pointer go-flag" data-targetUrl = '/account'>
               	회원가입
               </div>
           </div>
           <!-- <div class="menu-item">내모임</div>
           <div class="menu-item">로그인</div>
           <div class="menu-item">회원가입</div>
           <div class="menu-item">회원정보수정</div> -->
        </div>
    </div>
</nav>