// 상단바 메뉴이동
$(".menu-item").click(e=>{
	let targetDiv = e.currentTarget;
	let targetUrl = targetDiv.dataset.targeturl;
	location.href = targetUrl;
})