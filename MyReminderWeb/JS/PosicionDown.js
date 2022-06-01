$(window).scroll(function() {
    $("#logo-fixed").css("bottom", Math.max(-100, 900 - ($(document).height() - $(window).scrollTop() - $(window).height())));
});
