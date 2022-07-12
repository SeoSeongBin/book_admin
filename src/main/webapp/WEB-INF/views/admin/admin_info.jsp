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
    </main>
</body>
</html>