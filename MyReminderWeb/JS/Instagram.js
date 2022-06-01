$('#instagram').hover(function() {
    var target = $('#instagram');
    if (!target.hasClass('hide')) {
      target.removeClass('show');
      target.addClass('hide');
      target.addClass('colorinstagram');
    }
    
  })

  $('#style').click(function() {
    var target = $('#instagram');
    if (!target.hasClass('show')) {
        target.removeClass('hide');
        target.addClass('show');
        target.removeClass('colorinstagram');
    }
  })