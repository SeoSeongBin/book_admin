let book_imgs = new Array();

$("document").ready(function(){
    $('.summary').each(function(){

        let str = $(this).html();
        // Cutstring
        if(str.length > 100) {
            var textCut = $(this).text().substring( 0, 100 );
            $(this).html(textCut+"...");
        }
    });

    $("#add").click(function(){
        if (isEmpty($("#book_name").val())) {
            alert("도서명을 올바르게 입력해주세요")
            return;
        }
        if (isEmpty($("#bi_author").val())) {
            alert("저자를 올바르게 입력해주세요")
            return;
        }
        if (isEmpty($("#bi_publisher").val())) {
            alert("출판사를 올바르게 입력해주세요")
            return;
        }
        if (isEmpty($("#bi_publication_dt").val())) {
            alert("출판일을 올바르게 입력해주세요")
            return;
        }

        if(!confirm("추가하시겠습니까?")) return;

        let data = {
                bi_ci_seq:$("#ci_name option:selected").val(),
                bi_li_seq:$("#li_name option:selected").val(),
                bi_name:$("#book_name").val(),
                bi_author:$("#bi_author").val(),
                bi_publisher:$("#bi_publisher").val(),
                bi_publication_dt:$("#bi_publication_dt").val(),
                bi_status:$("#bi_status option:selected").val(),
                si_summary:$("#si_summary").val()
                }

        $.ajax({
            url:"/api/book/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    });

    
    $(".add_btn").click(function(){
        $(".book_popup").show();
    })

    $(".cancel").click(function(){
        if(!confirm("취소하시겠습니까?")) return;

        $(".book_popup").hide();
        $("#ci_name option:eq(0)").prop("selected", true);
        $("#li_name option:eq(0)").prop("selected", true);
        $("#book_name").val("");
        $("#bi_author").val("");
        $("#bi_publisher").val("");
        $("#bi_publication_dt").val("");
        $("#bi_status option:eq(0)").prop("selected", true);
        $("#si_summary").val("")
    })

    $("#bi_img").change(function(){

    })


    $("#bi_publication_dt").datepicker({
        dateFormat:"yy-mm-dd",
        monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
        monthNamesShort:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
        dayNames:["일","월","화","수","목","금","토"],
        daynamesShort:["일","월","화","수","목","금","토"],
        dayNamesstun:["일","월","화","수","목","금","토"],
        yearSuffix:"년",
        showMonthAfterYear:true,
        changeYear:true,
        changeMonth:true
    });


})