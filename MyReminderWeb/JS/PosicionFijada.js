$(window).scroll(function(){
    $("#logo-fixed").css("top",Math.max(120,1000-$(this).scrollTop()));
});

$(window).scroll(function(){
    $("#card-fixed").css("top",Math.max(120,1000-$(this).scrollTop()));
});

/*window.onscroll = function() {
    var y = window.scrollY;
  console.log(y);
  
      var target = $('logo-sticky');
      if(y > 680){
          target.removeClass('logo-sticky');
          target.addClass('logo-fixed');
      }
}*/