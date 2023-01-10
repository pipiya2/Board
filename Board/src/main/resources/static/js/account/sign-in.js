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
				openOverlay();
			},
			success : result =>{
				if(!result.ISSUCCESS){
					alert(result.ERRORMESSAGE);
					$("#inputPw").val("");
					$("#inputEmail").focus();
				}else{
					console.log(result.PREURL);
					let prevUrl = result.PREURL != null ? result.PREURL : "/";
					location.href = prevUrl;
				}
			},
			error : e=>{
				alert(e.messaage);
			},
			complete : ()=>{
				closeOverlay();
			}
		})
	}
})


// 비밀번호찾기 메일전송
$("#findpw-Button").click(()=>{
	if(findEmailCheck){
		// 중복전송 방지
		$("#findpw-Button").attr('disabled','disabled');
		
		$.ajax({
			url : "/password/verify",
			type : 'post',
			data : {
				userEmail : $("#findpw-email").val()
			},
			beforeSend : ()=>{
				openOverlay();
			},
			success : result =>{
				let message = result.ISSUCCESS ?  '이메일로 비밀번호 변경 링크를 보냈습니다' : result.ERRORMESSAGE;
				alert(message);
			},
			error : e=>{
				alert(e.message);
			},
			complete : ()=>{
				closeOverlay();
				$("#findpw-Button").attr('disabled',false);
			}
		})
	}else{
		$("#findpw-email").focus();
	}
})