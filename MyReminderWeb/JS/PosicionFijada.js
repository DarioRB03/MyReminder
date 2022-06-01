$(window).scroll(function(){
    var y = window.scrollY;
    var diferencia = 1000 - y;
  console.log(y);
  console.log("top " + "max de 120 y " + diferencia);

  if(diferencia > 300){
    $(".my-div-fixed").css("top",Math.max(120,800-$(this).scrollTop()));
  } else if(diferencia < -230){
    $(".my-div-fixed").css("top",Math.min(120,1600-$(this).scrollTop()));
  }

})