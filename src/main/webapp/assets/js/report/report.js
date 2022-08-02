$("document").ready(function(){
    $(".delete").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;
        $.ajax({
            url:"/api/comment/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r) {
                alert(r.msg);
                location.reload();
            }
        })
    })

    $(".judge").click(function(){
        $.ajax({
            url:"/api/comment/report_info?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                console.log(r);
                $("#judge").attr("data-seq", r.cr_ui_seq);
                $("#ui_status").val(r.ui_status).prop();
            }
        })
    })

    $("#judge").click(function(){
        let data = {
            ui_seq:$(this).attr("data-seq"),
            ui_status:$("#ui_status option:selected").val()
        }
        $.ajax({
            url:"/api/comment/judge",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.msg);
                location.reload();
            }
        })
    })
})