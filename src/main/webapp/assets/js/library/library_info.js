let library_img = new Array();

$("document").ready(function(){

    $(".add_btn").click(function(){
        $(".popup").show();
        $("#add").show();
        $("#modify_btn").hide();
        $("#li_name").val("");
        $("#li_file_name").val("");
    })

    $(".cancel").click(function(){
        if(!confirm("취소하시겠습니까?")) return;

        $(".popup").hide();
    })

    $("#add").click(function(){
        let data = {
            li_img_file:library_img,
            li_name:$("#li_name").val()
        }

        $.ajax({
            url:"/api/library/add",
            type:"put",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r) {
                alert(r.message);
                // location.reload();
                console.log(r.data);
            },
            error:function(err) {
                alert(err.responseJSON.message);
            }
        })
    })

    $(".modify").click(function(){
        $(".popup").show();
        $.ajax({
            url:"/api/library/info?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                $("#modify_btn").show();
                $("#add").hide();
                $("#modify_btn").attr("data-seq", r.li_seq);
                $("#li_name").val(r.li_name);
                // $("#li_file_name").val(r.li_img_file);
                let tag = 
                '<img src="/img/library/'+r.li_img_file+'" alt="프로필 사진">';
                library_img = r.file;
                $(".li_img_view").append(tag);
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
            li_img_file:library_img
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

    $("#li_file_name").change(function(){
        let form = $("#library_img_form")
        let formData = new FormData(form[0]);
        if($(this).val() == '' || $(this).val() == null) return;

        $.ajax({
            url:"/img/upload/library",
            type:"put",
            data:formData,
            contentType:false,
            processData:false,
            success:function(r) {
                if(r.status) {
                    alert(r.message);
                    return;
                }
                // deleteProfileImg(library_img);
                
                let tag = 
                '<img src="/img/library/'+r.file+'" alt="프로필 사진">';
                library_img = r.file;
                $(".li_img_view").html("");
                $(".li_img_view").append(tag);
            }
        })
    })
})


function deleteProfileImg(filename) {
    $.ajax({
        url:"/img/delete/admin/"+filename,
        type:"delete",
        success:function(r) {
            console.log(r.message);
        }
    })
}