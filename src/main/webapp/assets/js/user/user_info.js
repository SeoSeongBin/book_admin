$("document").ready(function(){

    $(".user_modify").click(function(){
        $.ajax({
            url:"/api/user/info?seq="+$(this).attr("data-seq"),
            type:"get",
            success:function(r) {
                $(".mod_popup").show();
                $("#ui_id").val(r.ui_id).prop("disabled", true);
                $("#ui_name").val(r.ui_name);
                $("#ui_nickname").val(r.ui_nickname);
                $("#ui_bir_dt").val(r.ui_bir_dt);
                $(".gen input").eq(r.ui_gen-1).prop("checked", true);
                $("#ui_status").val(r.ui_status);
                $("#modify").attr("data-seq", r.ui_seq);
            }
        })
    });

    $("#cancel").click(function(){
        if(!confirm("취소하시겠습니까?")) return;
        $(".mod_popup").hide();
        $("#ui_id").val("").prop("disabled", false);
        $("#ui_name").val("");
        $("#ui_nickname").val("");
        $("#ui_bir_dt").val("");
        $(".gen input").eq("").prop("checked", false);
        $("#ui_status").val("");
        $("#modify").attr("");
    });

    $("#modify").click(function(){
        if(isEmpty($("#ui_id").val())) {
            alert("아이디를 올바르게 입력하세요");
            return;
        }
        if(isEmpty($("#ui_pwd").val())) {
            alert("비밀번호를 올바르게 입력하세요");
            return;
        }
        if(isEmpty($("#ui_name").val())) {
            alert("이름을 올바르게 입력하세요");
            return;
        }

        if(!confirm("수정하시겠습니까?")) return;
        let data = {
            ui_seq:$(this).attr("data-seq"),
            ui_id:$("#ui_id").val(),
            ui_name:$("#ui_name").val(),
            ui_pwd:$("#ui_nickname").val(),
            ui_bir_str:$("#ui_bir_dt").val(),
            ui_nickname:$("#ui_nickname").val(),
            ui_gen:$(".gen input:checked").val(),
            ui_status:$("#ui_status option:selected").val()
        }

        console.log(data);

        $.ajax({
            url:"/api/user/update",
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
    });

    $(".delete").click(function(){
        alert($(this).attr("data-seq"));
        if(!confirm("삭제하시겠습니까?")) return;
        $.ajax({
            url:"/api/user/delete?seq="+$(this).attr("data-seq"),
            type:"delete",
            success:function(r) {
                alert(r.message);
                location.reload();
            }
        })
    });

    $("#ui_bir_dt").datepicker({
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