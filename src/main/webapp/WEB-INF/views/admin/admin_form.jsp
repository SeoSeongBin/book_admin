<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/admin/admin_form.css">
    <script src="/assets/js/admin/admin_form.js"></script>
</head>
<body>
    <main>
        <div class="page_header">
            <h2>관리자 추가</h2>
        </div>

        <div class="add_admin_form">
            <div class="admin_id">
                <h3>아이디</h3>
                <input type="text" id="ai_id" placeholder="아이디 입력">
            </div>
            <div class="admin_pwd">
                <h3>비밀번호</h3>
                <input type="password" id="ai_pwd" placeholder="비밀번호입력">
            </div>
            <div class="admin_name">
                <h3>이름</h3>
                <input type="text" id="ai_name" placeholder="이름입력">
            </div>
            <div class="admin_file">
                <h3>프로필 사진</h3>
                <input type="file" id="ai_profile_file">
                <div class="profile_img"></div>
            </div>
        </div>
        <div class="btn_area">
            <button class="admin_add">등록</button>
            <button class="cancel">취소</button>
        </div>
    </main>
</body>
</html>