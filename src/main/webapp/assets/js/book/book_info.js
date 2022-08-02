let book_imgs = new Array();
let book_summary = new Array();

$("document").ready(function(){
    $('.summary').each(function(){

        let str = $(this).html();
        // Cutstring
        if(str.length > 100) {
            var textCut = $(this).text().substring( 0, 100 );
            $(this).html(textCut+"...");
        }
    });

    $('.book_box h3').each(function(){

        let str = $(this).html();
        // Cutstring
        if(str.length > 7) {
            var textCut = $(this).text().substring( 0, 7 );
            $(this).html(textCut+"...");
        }
    });

    $(".add_btn").click(function(){
        $(".book_popup").show();
        let order = $(".desc_text_box").length + 1;
        
        let tag = 
        '<div class="desc_text_box">'+
        '<textarea id="text"></textarea>'+
        '</div>';
        $(".book_summary_area").append(tag);
    })

    $("#bi_img").change(function(){
        let form = $("#book_img_form")
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url:"/img/upload/book",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(r) {
                if(r.status) {
                    alert(r.message);
                    return;
                }
                deleteProfileImg(book_imgs);
                let tag = 
                '<img src="/img/book/'+r.file+'" filename="'+r.file+'" alt="프로필 사진">';
                book_imgs = r.file;
                $(".bi_img_view").html("");
                $(".bi_img_view").append(tag);
            }
        })
    })

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
                book_info:{
                    bi_ci_seq:$("#ci_name option:selected").val(),
                    bi_li_seq:$("#li_name option:selected").val(),
                    bi_name:$("#book_name").val(),
                    bi_author:$("#bi_author").val(),
                    bi_publisher:$("#bi_publisher").val(),
                    bi_publication_dt:$("#bi_publication_dt").val(),
                    bi_status:$("#bi_status option:selected").val()
                },
                book_img:{
                    bimg_file_name:book_imgs
                },
                book_summary:{
                    si_summary:$("#text").val()
                }
            }

        $.ajax({
            url:"/api/book/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.reload();
            },
            error:function(err) {
                console.log(data)
            }
        })
    });

    $(".modify").click(function(){
        $.ajax({
            url:"/api/book/info?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                $(".book_popup").show()
                $("#book_name").val(r.bi_name);
                $("#ci_name option:selected").attr("value", r.bi_ci_seq);
                // $("#li_name option:selected").attr(r.bi_li_seq);
                $("#bi_author").val(r.bi_author);
                $("#bi_publisher").val(r.bi_publisher);
                $("#bi_publication_dt").val(r.bi_publication_dt);
                // $("#bi_status option:selected").attr(r.bi_status);
                let tag = 
                '<img src="/img/book/'+r.bimg_file_name+'" filename="'+r.bimg_file_name+'" alt="프로필 사진">';
                book_imgs = r.bimg_file_name;
                $(".bi_img_view").html("");
                $(".bi_img_view").append(tag);

                let tag1 = 
                '<div class="desc_text_box">'+
                '<textarea id="text">'+r.si_summary+'</textarea>'+
                '</div>';
                $(".book_summary_area").append(tag1);

                $("#modify").attr("data-seq", r.bi_seq);
            }
        })
    })

    $("#modify").click(function(){
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

        if(!confirm("수정하시겠습니까?")) return;

        let data = {
            book_info:{
                bi_seq:$(this).attr("data-seq"),
                bi_ci_seq:$("#ci_name option:selected").val(),
                bi_li_seq:$("#li_name option:selected").val(),
                bi_name:$("#book_name").val(),
                bi_author:$("#bi_author").val(),
                bi_publisher:$("#bi_publisher").val(),
                bi_publication_str:$("#bi_publication_dt").val(),
                bi_status:$("#bi_status option:selected").val()
            },
            book_img:{
                seq:$(this).attr("data-seq"),
                bimg_file_name:book_imgs
            },
            book_summary:{
                si_summary:$("#text").val()
            }
        }
        $.ajax({
            url:"/api/book/update",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
            }
        })
    })


    $(".cancel").click(function(){
        if(!confirm("취소하시겠습니까?")) return;
        deleteProfileImg(book_imgs);
        
        $(".book_popup").hide();
        $("#ci_name option:eq(0)").prop("selected", true);
        $("#li_name option:eq(0)").prop("selected", true);
        $("#book_name").val("");
        $("#bi_author").val("");
        $("#bi_publisher").val("");
        $("#bi_publication_dt").val("");
        $("#bi_status option:eq(0)").prop("selected", true);
        $(".desc_text_box").remove();
        $(".bi_img_view").html("");
        // book_imgs = new Array();
    })

    $(".delete").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;

        $.ajax({
            url:"/api/book/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
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

function deleteProfileImg(filename) {
    $.ajax({
        url:"/img/delete/book/"+filename,
        type:"delete",
        success:function(r) {
            console.log(r.message);
        }
    })
}