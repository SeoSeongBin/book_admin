<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/category/category_info.css">
    <script src="/assets/js/category/category_info.js"></script>
</head>

<body>
    <main>
        <div class="page_header">
            <h2>카테고리 관리</h2>
            <button class="add_btn">추가</button>
        </div>
        <div class="category_section">
            <c:forEach items="${list}" var="item">
                <div class="cate_box">
                    <h3>${item.ci_name}</h3>
                    <p>${item.ci_count}권</p>
                    <button class="modify" data-seq="${item.ci_seq}">수정</button>
                    <button class="delete" data-seq="${item.ci_seq}">삭제</button>
                </div>
            </c:forEach>
        </div>

        <div class="pager_area">
            <c:forEach begin="1" end="${pageCount}" var="i">
                <a href="/category/category_info?page=${i}" <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
            </c:forEach>
        </div>

        <form class="search_area" action="/category/category_info">
            <input type="text" name="keyword" placeholder="아이디검색" value="${keyword}">
            <button type="submit">검색</button>
        </form>


        <div class="cate_popup add">
            <div class="cate_popup_box">
                <h2>카테고리 추가</h2>
    
                <input type="text" id="cate_name" placeholder="카테고리명을 입력해주세요">
                <button class="save">추가</button>
                <button class="cancel">취소</button>
            </div>
        </div>

        <div class="cate_popup modify_popup">
            <div class="cate_popup_box">
                <h2>카테고리 수정</h2>
                <p class="before"></p>
                <input type="text" id="modify_name" placeholder="카테고리명을 입력해주세요">
                <button class="update">수정</button>
                <button class="cancel">취소</button>
            </div>
        </div>
    </main>

</body>

</html>