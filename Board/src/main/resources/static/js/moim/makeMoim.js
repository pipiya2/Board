autosize($("textArea"));


$("#testBtn").click(()=>{
	if(!isBlank()){
		var form = $('#board-write-form')[0];
		var formData = new FormData(form);
		// '<' or '>' or ',' filter
		formData.set('subject',xssFilter(formData.get('subject')));
		formData.set('content',xssFilter(formData.get('content')));
		$.ajax({
			url : "/make-class",
			type : "post",
			data : formData,
			processData: false, // formdata 넘길때 작성해야함 이유 모름 찾아봐야함
			contentType : false, // formdata 넘길때 작성해야함 이유 모름 찾아봐야함
			beforeSend : ()=>{
				openOverlay();
			},
			success : result=>{
				const returnUrl = result.RETURNURL;
				const returnMessage = result.RETURNMESSAGE;
				
				alert(returnMessage);
				if(!returnMessage.includes('SYSTEM')){
					location.href = returnUrl;
				}
			},
			error : e=>{
				console.log(e);
			},
			complete : ()=>{
				closeOverlay();
			}
		})
	}
})

function xssFilter(contents){
	contents = contents.replace(/</g,'&lt;');
	return contents.replace(/>/g,'&gt;');
}

function isBlank(){
	let subject = $("#boardSubject").val().trim().length;
	let content = $("#boardContent").val().trim().length;
	
	if(subject == 0){
		alert("글제목은 필수 입력사항 입니다.");
		$('#boardSubject').focus();
		return true;
	}
	
	if(subject < 5){
		alert("제목은 최소 5글자 이상이여야 합니다.");
		$('#boardSubject').focus();
		return true;
	}
	
	if(content == 0){
		alert("글내용은 필수 입력사항 입니다.");
		$('#boardContent').focus();
		return true;
	}
	
	return false;
}
