$("document").ready(function(){
    $('.summary').each(function(){
        // Cutstring
        if(this.html().length < 100) {
            var textCut = $(this).text().substring( 0, 100 );
            $(this).html(textCut+"...");
        }
    });

    $(".add_btn").click(function(){
        
    })
})