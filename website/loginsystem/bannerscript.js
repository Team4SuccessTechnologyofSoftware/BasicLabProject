  let bannerImages = document.querySelectorAll(".imgban"),
  arrowLeft = document.querySelector(".imgbanbtn-prev"),
  arrowRight = document.querySelector(".imgbanbtn-next"),
  current = 0;
  var slideIndex = 0;
  var bannerTimer = 4000;

// Clear all images
function reset() {
  for (let i = 0; i < bannerImages.length; i++) {
    bannerImages[i].style.display = "none";
  }
}

// Init slider
function startBannerSlide() {
  reset();
  bannerImages[0].style.display = "block";
  carousel();
}

function carousel() {
  var i;
  var x = document.querySelectorAll(".imgban");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }

  slideIndex++;
  if (slideIndex > x.length) {
    slideIndex = 1;
  }
  x[slideIndex - 1].style.display = "block";
  setTimeout(carousel, bannerTimer);
}

// Show prev
function slideLeft() {
  reset();
  bannerImages[current - 1].style.display = "block";
  current--;
}

// Show next
function slideRight() {
  reset();
  bannerImages[current + 1].style.display = "block";
  current++;
}

// Left arrow click
arrowLeft.addEventListener("click", function() {
  if (current === 0) {
    current = bannerImages.length;
  }
  slideLeft();
});

// Right arrow click
arrowRight.addEventListener("click", function() {
  if (current === bannerImages.length - 1) {
    current = -1;
  }
  slideRight();
});

startBannerSlide();
