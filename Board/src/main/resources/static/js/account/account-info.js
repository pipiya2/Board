let swiper = new Swiper('.swiper', {
	  	slidesPerView: 5,
		freeMode: true,
		followFinger : true, // 손가락이 멈춰있으면 안넘어감,
		observer: true,
		observeParents: true,
});