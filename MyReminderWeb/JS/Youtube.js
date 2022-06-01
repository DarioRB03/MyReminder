$('#youtube').hover(function() {
    var target = $('#youtube');
    if (!target.hasClass('hide')) {
      target.removeClass('show');
      target.addClass('hide');
      target.addClass('coloryoutube');
    }
    
  })

  $('#style').click(function() {
    var target = $('#youtube');
    if (!target.hasClass('show')) {
        target.removeClass('hide');
        target.addClass('show');
        target.removeClass('coloryoutube');
    }
  })