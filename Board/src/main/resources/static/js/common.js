// ajax 호출할때 beforeSend 부분에 작성 (모래시계 오픈)
function openOverlay(){
	$('#overlay').addClass("is-open");
	$('body').addClass("overlay-open");
}

// ajax 호출할때 complete 부분에 작성 (모래시계 클로즈)
function closeOverlay(){
	$('#overlay').removeClass("is-open");
	$('body').removeClass("overlay-open");
}