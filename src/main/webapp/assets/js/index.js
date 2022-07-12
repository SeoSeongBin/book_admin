$("document").ready(function(){
    $("#login_btn").click(function(){
        if(isEmpty($("#ai_id").val())) {
            alert("아이디를입력해주세요")
        }
        if(isEmpty($("#ai_pwd").val())) {
            alert("비밀번호를 입력해주세요")
        }

        let data = {
            ai_id:$("#ai_id").val(),
            ai_pwd:$("#ai_pwd").val()
        }
        $.ajax({
            url:"/api/admin/login",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                console.log(r);
                alert(r.message);
                if(r.status) {
                    location.href = "/admin/admin_info"
                }
            },
            error:function(err) {
                alert(err.responseJSON.message);
            }
        })
    })
})