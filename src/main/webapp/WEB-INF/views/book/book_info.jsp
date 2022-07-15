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
                    <button class="modify" data-seq="${item.bi_seq}">수정</button>
                    <button class="delete" data-seq="${item.bi_seq}">삭제</button>
                </div>
            </c:forEach>
        </div>
        
        <div class="book_popup">
            <div class="book_popup_box">
                <div class="book_name_area">
                    <p>도서명</p>
                    <input type="text" id="book_name">
                </div>

                <div class="book_cate_area">
                    <p>카테고리</p>
                    <select id="ci_name">
                        <c:forEach items="${cateList}" var="item">
                            <option value="${item.ci_seq}">${item.ci_name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="book_library_area">
                    <p>도서관</p>
                    <select id="li_name">
                        <c:forEach items="${liList}" var="item">
                            <option value="${item.li_seq}">${item.li_name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="book_author_area">
                    <p>저자</p>
                    <input type="text" id="bi_author">
                </div>

                <div class="book_publisher_area">
                    <p>출판사</p>
                    <input type="text" id="bi_publisher">
                </div>

                <div class="book_publication_area">
                    <p>출간일</p>
                    <input type="text" id="bi_publication_dt">
                </div>

                <div class="book_status_area">
                    <p>상태</p>
                    <select id="bi_status">
                            <option value="1">보유중</option>
                            <option value="2">입고예정</option>
                            <option value="2">분실</option>
                    </select>
                </div>

                <div class="book_summary_area">
                    <p>줄거리</p>
                    <textarea id="si_summary" cols="30" rows="10"></textarea>
                </div>

                <div class="book_img_area">
                    <p>도서 이미지</p>
                    <input type="file" id="bi_img">
                    <div class="bi_img_view">

                    </div>
                </div>

                <div class="btn_area">
                    <button id="add">등록</button>
                    <button class="cancel">취소</button>
                </div>
            </div>
        </div>
    </main>
</body>
</html>