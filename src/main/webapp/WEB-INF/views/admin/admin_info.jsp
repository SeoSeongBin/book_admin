<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/admin/admin_info.css">
    <script src="/assets/js/admin/admin_info.js"></script>
</head>
<body>
    <main>
        <div class="page_header">
            <h2>관리자 관리</h2>
            <a href="/admin/admin_form"><button class="add_btn">추가</button></a>
        </div>

        <table class="admin_table">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>아이디</td>
                    <td>이름</td>
                    <td>등록일</td>
                    <td>상태</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.ai_seq}</td>
                        <td>${item.ai_id}</td>
                        <td>${item.ai_name}</td>
                        <td>
                            <fmt:formatDate value="${item.ai_reg_dt}" pattern="yyyy-MM-dd"></fmt:formatDate>
                            
                        </td>
                        <td>
                            <c:if test="${item.ai_status == 99}">마스터관리자</c:if> 
                            <c:if test="${item.ai_status != 99}">일반관리자</c:if> 
                        </td>
                        <td>
                            <button class="modify" data-seq="${item.ai_seq}">수정</button>
                            <button class="delete" data-seq="${item.ai_seq}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
                
                    
            </tbody>
        </table>

        <c:forEach begin="1" end="${pageCnt}" var="i">
                <c:if test="${country != null}">
                    <a href="/admin/admin_info?page=${i}&keyword=${keyword}&country=${country}"
                        <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
                </c:if>
                <c:if test="${country == null}">
                    <a href="/admin/admin_info?page=${i}&keyword=${keyword}"
                    <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
                </c:if>
            </c:forEach>

            <form class="search_area" action="/admin/admin_info">
                <input type="text" name="keyword" placeholder="아이디검색" value="${keyword}">
                <button type="submit">검색</button>
            </form>

            <div class="modify_popup">
                <div class="modify_box">
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
                <form id="book_img_form">
                    <input type="file" id="ai_profile_file" name="file" hidden accept="image/gif, image/jpeg, image/png">
                </form>
                <div class="profile_img">
                </div>
                <button id="add_image" onclick="document.getElementById('ai_profile_file').click()">이미지 선택</button>
            </div>
                    </div>
                    <div class="btn_area">
                        <button class="admin_modify">수정</button>
                        <button class="cancel">취소</button>
                    </div>
                </div>
            </div>
    </main>

    
</body>
</html>