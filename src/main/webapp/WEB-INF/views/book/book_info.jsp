<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/book/book_info.css">
</head>
<body>
    <main>
        <div class="page_header">
            <h2>도서 관리</h2>
            <button class="add_btn">추가</button>
        </div>
        <div class="book_section">
            <div class="book_box">
                <div class="book_img">

                </div>
                <h3>도서명</h3>
                <p>줄거리길게</p>
                <button class="modify">수정</button>
                <button class="delete">삭제</button>
            </div>
        </div>
    </main>
</body>
</html>