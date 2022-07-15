
let admin_img = new Array();

$("document").ready(function(){

    $("#ai_profile_file").change(function(){
        let form = $("#book_img_form")
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url:"/img/upload/admin",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(r) {
                if(r.status) {
                    alert(r.message);
                    return;
                }
                let tag = 
                '<img src="/img/admin/'+r.file+'" alt="프로필 사진">';
                admin_img = r.file;
                $(".profile_img").html("");
                $(".profile_img").append(tag);
            }
        })
    })
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
            ai_name:name,
            ai_profile_file:admin_img
        }
        $.ajax({
            url:"/api/admin/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                location.href="/admin/admin_info";
            },
            error:function(err) {
                alert(err.responseJSON.message);
            }
        })
        // $("#ai_id").val("");
        // $("#ai_pwd").val("");
        // $("#ai_name").val("");
        // $(".profile_img").html("");
        // admin_img = new Array();
    })
})