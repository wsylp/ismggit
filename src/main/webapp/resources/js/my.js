$(".navbar-nav > li").click(function(){
  $(".navbar-nav > li").removeClass("active");
  $(".navbar-nav > li").removeClass("open");
  $(".navbar-nav > li").removeClass("selected");
  $(".navbar-nav > li > li").removeClass("active");
  $(this).addClass("active");
  $(this).addClass("open");
  $(this).addClass("selected");
  // $(this).attr('class', ' active open selected');
});

