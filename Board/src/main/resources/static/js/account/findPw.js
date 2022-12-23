let pwCheck = false;
let pwReCheck = false;
 $(document).ready(()=>{
	// 비밀번호 유효성 검사
	$('#change-password').keyup(key=>{
		if(key.keyCode == 13){
			$("#change-password-check").focus();
			return;
		}
		let pw = $("#change-password").val();
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
	$('#change-password-check').keyup(key=>{
		if(key.keyCode == 13){
			$("#changPassword_btn").click();
			return;
		}
		pwReCheck = false;
		let pw = $('#change-password-check').val();
		$('.form-error-pw-check').show();
		if($("#change-password").val().length != 0 && pw == $("#change-password").val()){
			$('.form-error-pw-check').hide();
			pwReCheck = true;
		}
	})
	
	$('#change-password').focus(()=>{
		$('.form-error-pw').show();
	})
	
	$('#change-password').blur(()=>{
		$('.form-error-pw').hide();
	})
	
	$("#changPassword_btn").click(()=>{
		//pwCheck && pwReCheck
		if(pwCheck && pwReCheck){
			let token = window.location.href;
			token = token.substring(token.lastIndexOf('/')+1);
			
			let data ={
				"password" : $("#change-password").val(),
				"findPwToken" : token
			}
			
			$("#change-password").val("");
			$("#change-password-check").val("");
			
			$.ajax({
				url : "/change",
				type : "post",
				data : data,
				beforeSend : ()=>{
					openOverlay();
				},
				success : result=>{
					if(result.ISSUCCESS){
						alert("비밀번호가 변경되었습니다. 변경된 비밀번호로 로그인 해주세요.");
						location.href = "/sign-in";
					}else{
						alert(result.EXCEPTIONMESSAGE);
						location.reload();
					}
				},
				error : e=>{
					alert(e);
				},
				complete : ()=>{
					closeOverlay();
				}
			})
		}else{
			if(!pwCheck){
				$("#change-password").focus();
			}else{
				$("#change-password-check").focus();
			}
		}
	})
})