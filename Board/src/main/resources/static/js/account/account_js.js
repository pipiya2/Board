let pwCheck;
let pwReCheck;
// 비밀번호 유효성 검사
$('#inputPassword').keyup(()=>{
	let pw = $("#inputPassword").val();
	var num = pw.search(/[0-9]/g);
	var eng = pw.search(/[a-z]/ig);
	var spe = pw.search(/[`~!@@#$%^&*.|₩₩₩'₩";:₩/?]/gi);
	let checkCount = 0;
	pwCheck = false;
	// pw.length ==> 0일경우 세가지 유효성 검사 초기화
	if(pw.length == 0){
		$("#f_valid").removeClass('valid-fail');
		$("#s_valid").removeClass('valid-fail');
		$("#t_valid").removeClass('valid-fail');
		
		$("#f_valid").removeClass('valid-pass');
		$("#s_valid").removeClass('valid-pass');
		$("#t_valid").removeClass('valid-pass');
		return;
	}
	// 영문/숫자/특수문자중 2가지 이상 포함
	if(spe == -1 || num == -1){
		$("#f_valid").addClass('valid-fail');
	}else{
		$("#f_valid").removeClass('valid-fail');
		$("#f_valid").addClass('valid-pass');
		checkCount += 1;
	}
	
	// 8자이상 32자 이하
	if(pw.length < 8 || pw.length > 20){
		$("#s_valid").addClass('valid-fail');
	}else{
		$("#s_valid").removeClass('valid-fail');
		$("#s_valid").addClass('valid-pass');
		checkCount += 1;
	}
	
	// 연속 3자 이상 동일한 문자/숫자
	if(/(\w)\1\1/.test(pw)){
		$("#t_valid").addClass('valid-fail');
	}else{
		$("#t_valid").removeClass('valid-fail');
		$("#t_valid").addClass("valid-pass");
		checkCount += 1;
	}
	
	if(checkCount == 3){
		pwCheck = true;
	}
})

// 비밀번호 재확인 검사
$('#inputPasswordCheck').keyup(()=>{
	pwReCheck = false;
	let pw = $('#inputPasswordCheck').val();
	$('.form-error-pw-check').show();
	if($("#inputPassword").val().length != 0 && pw == $("#inputPassword").val()){
		$('.form-error-pw-check').hide();
		pwReCheck = true;
	}
})

// 이메일 유효성 검사
$('#inputEmail').keyup(()=>{
	let email = $("#inputEmail").val();
	emailCheck = false;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(!exptext.test(email)){
		$('.form-error-email').show();
	}else{
		$('.form-error-email').hide();
		emailCheck = true;
	}
})

$("#joinBtn").click(()=>{
	
})