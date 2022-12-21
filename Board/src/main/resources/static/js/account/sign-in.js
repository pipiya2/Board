$("#inputEmail").focus();
let findEmailCheck = false;
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

//엔터처리
$('#findpw-email, #inputPw').on('keyup',key=>{
	if(key.keyCode == 13){
		if(key.target.id == "inputPw"){
			$('#joinBtn').click();
		}else{
			$('#findpw-Button').click();
		}
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

// 로그인
$("#joinBtn").click(()=>{
	if(!isBlank()){
		$.ajax({
			url : "/sign-in",
			type : "post",
			data : $("#signInForm").serialize(),
			beforeSend : ()=>{
				
			},
			success : result =>{
				console.log("result.ISSUCCESS",result.ISSUCCESS);
				if(!result.ISSUCCESS){
					alert(result.ERRORMESSAGE);
					$("#inputPw").val("");
					$("#inputEmail").focus();
				}else{
					location.href = result.PREURL;
				}
			},
			error : e=>{
				alert(e.messaage);
			},
			complete : ()=>{
				
			}
		})
	}
})


// 비밀번호 찾기
$("#findpw-Button").click(()=>{
	if(findEmailCheck){
		$.ajax({
			url : "/password/verify",
			type : 'post',
			data : {
				userEmail : $("#findpw-email").val()
			},
			beforeSend : ()=>{
				
			},
			success : result =>{
				console.log(result);
			},
			error : e=>{
				alert(e.message);
			},
			complete : ()=>{
				
			}
		})
	}else{
		$("#findpw-email").focus();
	}
})