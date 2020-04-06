$(document).ready(function() {
  $('li.active').removeClass('active');
  var currentPath = location.pathname.split("/")[2];
  currentPath = currentPath.split(".")[0];
  $.each($(".navbar-nav").find("a"), function(){
	  var currentPage = $(this).attr("href");
	  if(currentPage.indexOf(currentPath)>-1){
		  $(this).closest('li').addClass('active'); 
	  }
  }); 
});