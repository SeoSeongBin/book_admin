$("document").ready(function(){

    $(".add_btn").click(function(){
        $("#add").show();
        $("#modify_btn").hide();
        $("#li_name").val("");
        $("#li_file_name").val("");
    })

    $("#add").click(function(){
        let data = {
            li_img_file:$("#li_file_name").val(),
            li_name:$("#li_name").val()
        }

        $.ajax({
            url:"/api/library/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.reload();
            },
            error:function(err) {
                alert(err.responseJSON.message);
            }
        })
    })

    $(".modify").click(function(){
        $.ajax({
            url:"/api/library/info?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                $("#modify_btn").show();
                $("#add").hide();
                $("#modify_btn").attr("data-seq", r.li_seq);
                $("#li_name").val(r.li_name);
                // $("#li_file_name").val(r.li_img_file);
            }
        })
    })

    $("#modify_btn").click(function(){
        if(isEmpty($("#li_name").val())) {
            alert("도서명을 올바르게 입력하세요");
            return;
        }
        if(!confirm("수정하시겠습니까?")) return;

        let data = {
            li_seq:$(this).attr("data-seq"),
            li_name:$("#li_name").val(),
            li_img_file:$("#li_file_name").val()
        }

        $.ajax({
            url:"/api/library/modify",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.reload();
                console.log(data);
            },
            error:function(err) {
                alert(err.responseJSON.message);
            }
        })
    })

    $(".delete").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;

        $.ajax({
            url:"/api/library/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })
})