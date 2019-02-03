(function( $ ) {

  $.fn.validate = function(regex) {
    if (regex === undefined) {
      return this;
    } 

    this.each(
      function(index) {
        $(this).keyup(function (event) {
          // console.log(event.target);
          patt = new RegExp(regex);
          valid = patt.test(this.value);
          // console.count(valid);
    
          if(event.target.classList.contains('invalid') == valid){
            event.target.classList.toggle('invalid');
          }
        })
      }
    )

  };

}( jQuery ));

$('input').validate("as");
