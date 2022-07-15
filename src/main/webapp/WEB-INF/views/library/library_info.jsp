<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/library/library_info.css">
    <script src="/assets/js/library/library_info.js"></script>
</head>
<body>
    <main>
        <div class="page_header">
            <h2>도서관 관리</h2>
            <button class="add_btn">추가</button>
        </div>
        <div class="library_section">
            <c:forEach items="${list}" var="item">
                <div class="library_box">
                    <div class="library_img">
                        <img src="${item.li_img_file}" alt="도서관이미지">
                    </div>
                    <h3>${item.li_name}</h3>
                    <button class="modify" data-seq="${item.li_seq}" >수정</button>
                    <button class="delete" data-seq="${item.li_seq}" >삭제</button>
                </div>
            </c:forEach>
        </div>

        <c:forEach begin="1" end="${pageCnt}" var="i">
                <c:if test="${country != null}">
                    <a href="/library/library_info?page=${i}&keyword=${keyword}&country=${country}"
                        <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
                </c:if>
                <c:if test="${country == null}">
                    <a href="/library/library_info?page=${i}&keyword=${keyword}"
                    <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
                </c:if>
            </c:forEach>

            <form class="search_area" action="/library/library_info">
                <input type="text" name="keyword" placeholder="아이디검색" value="${keyword}">
                <button type="submit">검색</button>
            </form>

        <div class="popup">
            <div class="popup_box">
                <h2>도서관 정보추가</h2>

                <div class="library_name">
                    <p>도서관명</p>
                    <input type="text" id="li_name">
                </div>

                <div class="library_img">
                    <p>도서관이미지</p>
                    <input type="file" id="li_file_name">
                    <div class="li_img_view">
                        
                    </div>
                </div>

                <div class="btn_area">
                    <button id="add">추가</button>
                    <button id="modify_btn">수정</button>
                    <button class="cancel">취소</button>
                </div>
            </div>
        </div>
    </main>
</body>
</html>