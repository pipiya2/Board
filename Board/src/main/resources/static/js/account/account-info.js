let swiper = new Swiper('.swiper', {
	  	//slidesPerView: 3,
		freeMode: true,
		followFinger : true, // 손가락이 멈춰있으면 안넘어감,
		observer: true,
		observeParents: true,
		// 반응형
		// 너비가 n 이상 시 slidesPerView: 3
		breakpoints : {
			300 : {
				slidesPerView: 1
			},
			600 : {
				slidesPerView: 2
			},
			700 : {
				slidesPerView: 3
			},
			1000: {
				slidesPerView: 5
			}
		}
});