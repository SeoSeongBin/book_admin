$("document").ready(function(){
    $(".save").click(function(){
        if (isEmpty($("#cate_name").val())) {
            alert("카테고리를 올바르게 입력해주세요")
            return;
        }

        $.ajax({
            url:"/api/category/add?name="+ $("#cate_name").val(),
            type:"put",
            success:function(r) {
                alert(r.message);
                if(r.status)
                location.reload();
            }
        })
    })
    $(".add_btn").click(function(){
        $(".add").show();
    })
    $(".delete").click(function(){
        if(!confirm("삭제하시겠습니까?")) return;
        $.ajax({
            url:"/api/category/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r) {
                alert(r.message);
                if(r.status)
                location.reload();
            }
        })
    })

    $(".modify").click(function(){
        $(".modify_popup").show();
        $(".update").attr("data-seq", $(this).attr("data-seq"));
        $.ajax({
            url:"/api/category/name?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                console.log(r)
                $("#modify_name").val(r.name);
                $(".before").html(r.name);
            }
        })
    })

    $(".update").click(function(){
        if(!confirm("수정하시겠습니까?")) return;
        $.ajax({
            url:"/api/category/modify?seq="+$(this).attr("data-seq")+"&name="+$("#modify_name").val(),
            type:"patch",
            success:function(r) {
                alert(r.message);
                if(r.status)
                location.reload();
            }
        })
    })

    $(".cancel").click(function(){
        if(!confirm("취소하시겠습니까?")) return;
        $("#cate_name").val("");
        $("#modify_name").val("");
        $(".cate_popup").hide();
    })
})