describe("Validator", function() {
  var dom = document.createElement('input');
  dom.setAttribute('type', 'text'); 

  beforeEach(function() {
  });


  it("should be able to play a Song", function() {
    // console.log($());
    $('input').val("as");
    $('input').keyup();
    $('input').validate("as");

    expect($('input').hasClass('invalid')).toBeFalsy();

    $('input').val("aqqaa");
    $('input').keyup();

    var hclass = $('input').hasClass('invalid');
    console.log(hclass);

    expect(hclass).toBeTruthy();
  });

});
