var body = document.body,
    html = document.documentElement;

var height = Math.max( body.scrollHeight, body.offsetHeight, 
                       html.clientHeight, html.scrollHeight, html.offsetHeight );

console.log(height);


$(window).scroll(function(){
    var y = window.scrollY;
    console.log(y);
    var diferencia = 1000 - y;
   /*console.log("top " + "max de 120 y " + diferencia);*/

  if(height > 3000){
    if(diferencia > 100){
      $(".my-div-fixed").css("top",Math.max(120,1000-$(this).scrollTop()));
    } else if(diferencia < 1000){
      $(".my-div-fixed").css("top",Math.min(120,2100-$(this).scrollTop()));
    }
  } else if (height > 2500){
    if(diferencia > 300){
      $(".my-div-fixed").css("top",Math.max(120,800-$(this).scrollTop()));
    } else if(diferencia < -250){
      $(".my-div-fixed").css("top",Math.min(120,1900-$(this).scrollTop()));
    }
  } 

})