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

    $(".modify").click(function(){
        $.ajax({
            url:"/api/admin/info?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                $(".modify_popup").show();
                $("#ai_id").val(r.ai_id).prop("disabled", true);
                $("#ai_name").val(r.ai_name);
                $(".admin_modify").attr("data-seq", r.ai_seq);
            }
        })
    })

    $(".admin_modify").click(function(){
        if(isEmpty($("#ai_id").val())) {
            alert("아이디를 올바르게 입력하세요");
            return;
        }
        if(isEmpty($("#ai_pwd").val())) {
            alert("비밀번호를 올바르게 입력하세요");
            return;
        }
        if(isEmpty($("#ai_name").val())) {
            alert("이름을 올바르게 입력하세요");
            return;
        }

        if(!confirm("수정하시겠습니까?")) return;

        let data = {
            ai_seq:$(this).attr("data-seq"),
            ai_pwd:$("#ai_pwd").val(),
            ai_name:$("#ai_name").val()
        }

        console.log(data);

        $.ajax({
            url:"/api/admin/modify",
            type:"patch",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.reload();
            },
            error:function(err) {
                alert(err.message);
            }
        })
    })

    $(".cancel").click(function(){
        if(!confirm("취소하시겠습니까?")) return;
        $(".modify_popup").hide();
    })
})