$('#instagram').hover(function() {
    var target = $('#instagram');
    if (!target.hasClass('hide')) {
      target.removeClass('show');
        target.addClass('hide');
    }
    
  })

  $('#style').click(function() {
    var target = $('#instagram');
    if (!target.hasClass('show')) {
        target.removeClass('hide');
        target.addClass('show');
    }
  })