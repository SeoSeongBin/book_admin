$("document").ready(function(){
    $(".delete").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;

        $.ajax({
            url:"/api/admin/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    })
})