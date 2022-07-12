
let img_files = new Array();

$("document").ready(function(){
    $(".admin_add").click(function(){
        let id = $("#ai_id").val();
        let pwd = $("#ai_pwd").val();
        let name = $("#ai_name").val();
        if (isEmpty($("#ai_id").val())) {
            alert("아이디를 올바르게 입력해주세요")
            return;
        }
        if (isEmpty($("#ai_pwd").val())) {
            alert("아이디를 올바르게 입력해주세요")
            return;
        }
        if (isEmpty($("#ai_name").val())) {
            alert("이름을 올바르게 입력해주세요")
            return;
        }

        let data = {
            ai_id:id,
            ai_pwd:pwd,
            ai_name:name
        }
        $.ajax({
            url:"/api/admin/add",
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
})