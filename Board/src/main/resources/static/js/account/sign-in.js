$(".forgot-password").click(e=>{
	let targetDiv = e.currentTarget;
	let targetUrl = targetDiv.dataset.targetUrl;
	location.href = targetUrl;
})