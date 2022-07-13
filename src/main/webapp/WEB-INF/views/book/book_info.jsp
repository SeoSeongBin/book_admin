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
    <script src="/assets/js/book/book_info.js"></script>
</head>
<body>
    <main>
        ${list}
        <div class="page_header">
            <h2>도서 관리</h2>
            <button class="add_btn">추가</button>
        </div>
        <div class="book_section">
            <c:forEach items="${list}" var="item">
                <div class="book_box">
                    <div class="book_img">

                    </div>
                    <h3>${item.bi_name}</h3>
                    <p class="summary">
                        ${item.si_summary}
                    </p>
                    <button class="modify">수정</button>
                    <button class="delete">삭제</button>
                </div>
            </c:forEach>
        </div>
        <div class="book_popup">
            <div class="book_popup_box">
                
            </div>
        </div>
    </main>
</body>
</html>