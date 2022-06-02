var body = document.body,
    html = document.documentElement;

var height = Math.max( body.scrollHeight, body.offsetHeight, 
                       html.clientHeight, html.scrollHeight, html.offsetHeight );

console.log(height);


$(window).scroll(function(){
    var y = window.scrollY;
    /*console.log(y);*/
    var diferencia = 1000 - y;
   /*console.log("top " + "max de 120 y " + diferencia);*/

  if(height > 3400){
      if(diferencia > 95){
        $(".my-div-fixed").css("top",Math.max(120,1050-$(this).scrollTop()));
      } else if(diferencia < 1000){
        $(".my-div-fixed").css("top",Math.min(120,2600-$(this).scrollTop()));
      }
  } else if(height > 3250){
    if(diferencia > 100){
      $(".my-div-fixed").css("top",Math.max(120,900-$(this).scrollTop()));
    } else if(diferencia < 1000){
      $(".my-div-fixed").css("top",Math.min(120,2200-$(this).scrollTop()));
    }
  } else if(height > 3100){
      if(diferencia > 100){
        $(".my-div-fixed").css("top",Math.max(120,1000-$(this).scrollTop()));
      } else if(diferencia < 1000){
        $(".my-div-fixed").css("top",Math.min(120,2400-$(this).scrollTop()));
      }
  } else if (height > 2700){
      if(diferencia > 99){
        $(".my-div-fixed").css("top",Math.max(120,850-$(this).scrollTop()));
      } else if(diferencia < 999){
        $(".my-div-fixed").css("top",Math.min(120,2100-$(this).scrollTop()));
      }
  } 

})