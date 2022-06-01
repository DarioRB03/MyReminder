$('#code').hover(function() {
    var target = $('#code');
    if (!target.hasClass('hide')) {
      target.removeClass('show');
      target.addClass('hide');
      target.addClass('colorcode');
    }
    
  })

  $('#style').click(function() {
    var target = $('#code');
    if (!target.hasClass('show')) {
        target.removeClass('hide');
        target.addClass('show');
        target.removeClass('colorcode')
    }
  })