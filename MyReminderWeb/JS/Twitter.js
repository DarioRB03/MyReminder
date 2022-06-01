$('#twitter').hover(function() {
    var target = $('#twitter');
    if (!target.hasClass('hide')) {
      target.removeClass('show');
      target.addClass('hide');
      target.addClass('colortwitter');
    }
    
  })

  $('#style').click(function() {
    var target = $('#twitter');
    if (!target.hasClass('show')) {
        target.removeClass('hide');
        target.addClass('show');
        target.removeClass('colortwitter');
    }
  })