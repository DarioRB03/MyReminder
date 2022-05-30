/*
 * decaffeinate suggestions:
 * DS102: Remove unnecessary code created because of implicit returns
 * Full docs: https://github.com/decaffeinate/decaffeinate/blob/master/docs/suggestions.md
 */
$(document).ready(function() {
    var walkthrough = {
      index: 0,
      
      nextScreen() {
        if (this.index < this.indexMax()) {
          this.index++;
          return this.updateScreen();
        }
      },
  
      prevScreen() {
        if (this.index > 0) {
          this.index--;
          return this.updateScreen();
        }
      },
          
      updateScreen() {
        this.reset();
        this.goTo(this.index);
        return this.setBtns();
      },
        
      setBtns() {
        const $nextBtn = $('.next-screen');
        const $prevBtn = $('.prev-screen');
        const $lastBtn = $('.finish');
        
        if (walkthrough.index === walkthrough.indexMax()) {
          $nextBtn.prop('disabled', true);
          $prevBtn.prop('disabled', false);
          return $lastBtn.addClass('active').prop('disabled', false);
          
        } else if (walkthrough.index === 0) {
          $nextBtn.prop('disabled', false);
          $prevBtn.prop('disabled', true);
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

      firstScreen(){
        if (this.index > 0) {
            this.index = 0;
            return this.updateScreen();
          }
      }
      

    };
  
    $('.next-screen').click(() => walkthrough.nextScreen());
  
    $('.prev-screen').click(() => walkthrough.prevScreen());
  
    $('.close').click(() => walkthrough.firstScreen());
      
      
    walkthrough.openModal();
   
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