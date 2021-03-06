$(document).ready(function() {
    var walkthrough = {
      index: 0,
      
      nextScreen() {
        if (this.index <= this.indexMax()) {
          this.index++;
          if(this.index > 4){
            this.index = 0
          }
          return this.updateScreen();
        }
      },
  
      prevScreen() {
        if (this.index >= 0) {
          this.index--;
          if(this.index < 0){
            this.index = 4
          }
          return this.updateScreen();
        }
      },
          
      updateScreen() {
        this.reset();
        this.goTo(this.index);
        return this.setBtns();
      },

      firstScreen(){
        this.index = 0;
        return this.updateScreen();
      },

    /*lastToFirst(){
      if (this.index >= 4) {
        this.index = 0;
        return this.updateScreen();
      }
       },*/

    /*lastScreen(){
      if (this.index < 1) {
        this.index = 4;
        return this.updateScreen();
      }
       },*/
        
      setBtns() {
        const $nextBtn = $('.next-screen');
        const $prevBtn = $('.prev-screen');
        const $lastBtn = $('.finish');
        
        if (walkthrough.index === walkthrough.indexMax()) {
          $nextBtn.prop('disabled', false);
          $prevBtn.prop('disabled', false);
          return $lastBtn.addClass('active').prop('disabled', false);
          
        } else if (walkthrough.index === 0) {
          $nextBtn.prop('disabled', false);
          $prevBtn.prop('disabled', false);
          return $lastBtn.removeClass('active').prop('disabled', true);
          
        } else {
          $nextBtn.prop('disabled', false);
          $prevBtn.prop('disabled', false);
          return $lastBtn.removeClass('active').prop('disabled', true);
        }
      },
  
  
      goTo(index) {
        $('.screen').eq(index).addClass('active');
        return $('.dot').eq(index).addClass('active');
      },
  
      reset() {
        return $('.screen, .dot').removeClass('active');
      },
  
      indexMax() {
        return $('.screen').length - 1;
      },
  
     /*closeModal() {
        $('.walkthrough, .shade').removeClass('reveal');
        return setTimeout((() => {
          $('.walkthrough, .shade').removeClass('show');
          this.index = 0;
          return this.updateScreen();
        }
        ), 200);
      },
  
      openModal() {
        $('.walkthrough, .shade').addClass('show');
        setTimeout((() => {
          return $('.walkthrough, .shade').addClass('reveal');
        }
        ), 200);
        return this.updateScreen();
      }*/

      

    };
  
    
    $('.next-screen').click(() => walkthrough.nextScreen());

    /*$('.next-screen').click(() => walkthrough.lastToFirst());*/
  
    $('.prev-screen').click(() => walkthrough.prevScreen());

    /*$('.prev-screen').click(() => walkthrough.lastScreen());*/
  
    $('.close').click(() => walkthrough.firstScreen());
   
    // Optionally use arrow keys to navigate walkthrough
    return $(document).keydown(function(e) {
      switch (e.which) {
        case 37:
          // left
          walkthrough.prevScreen();
          break;
        case 38:
          // up
          walkthrough.openModal();
          break;
        case 39:
          // right
          walkthrough.nextScreen();
          break;
        case 40:
          // down
          walkthrough.closeModal();
          break;
        default:
          return;
      }
      e.preventDefault();
    });
  });