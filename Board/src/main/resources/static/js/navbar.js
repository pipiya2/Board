/// 상단바 메뉴이동
$(".go-flag").click(e=>{
	let targetDiv = e.currentTarget;
	let targetUrl = targetDiv.dataset.targeturl;
	location.href = targetUrl;
})