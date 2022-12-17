// 비밀번호찾기 이메일 유효성 검사
$('#findpw-email').keyup(()=>{
	let email = $("#findpw-email").val();
	findEmailCheck = false;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(!exptext.test(email)){
		$('.findpw-form-error-email').show();
	}else{
		$('.findpw-form-error-email').hide();
		findEmailCheck = true;
	}
})

$('#findpw-email').on('keyup',key=>{
	if(key.keyCode == 13){
		$('#findpw-Button').click();
	}
})


// 빈칸 유효성
function isBlank(){
	let email = $("#inputEmail").val().length;
	let pw = $("#inputPw").val().length;
	if(email == 0 || pw == 0){
		if(email == 0) $("#inputEmail").focus();
		else $("#inputPw").focus();
		return true;
	}
	
	return false;
}