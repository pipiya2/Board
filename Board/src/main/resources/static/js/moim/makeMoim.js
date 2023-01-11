autosize($("textArea"));


$("#testBtn").click(()=>{
	if(!isBlank()){
		$.ajax({
			url : "/make-class",
			type : "post",
			data : $("#board-write-form").serialize(),
			beforeSend : ()=>{
				openOverlay();
			},
			success : result=>{
				console.log(result);
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
