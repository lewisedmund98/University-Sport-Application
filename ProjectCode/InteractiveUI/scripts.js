

var topnavContainer = document.getElementById("nav");
var pages = topnavContainer.getElementsByClassName("link");

for (var i = 0; i < pages.length; i++) {
  pages[i].addEventListener("click", function() {
    var curr = document.getElementsByClassName("active");
    if (curr.length > 0) {
      curr[0].className = curr[0].className.replace(" active", "");
    }
    this.className += " active"
  });
}