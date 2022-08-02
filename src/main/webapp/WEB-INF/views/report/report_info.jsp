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
    <script src="/assets/js/report/report.js"></script>
</head>
<body>
    <main>
        <div class="page_header">
            <h2>신고 관리</h2>
        </div>

        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>신고당한사람</td>
                    <td>사유</td>
                    <td>내용</td>
                    <td>신고일자</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.cr_seq}</td>
                        <td>${item.ui_id}</td>
                        <td>
                            <c:if test="${item.cr_reason == 1}">비속어사용</c:if> 
                            <c:if test="${item.cr_reason == 2}">정치발언</c:if>
                            <c:if test="${item.cr_reason == 3}">비하발언</c:if>
                        </td>
                        <td>${item.cmi_summary}</td>
                        <td>
                            <fmt:formatDate value="${item.cr_reg_dt}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                            <button class="judge" data-seq="${item.cr_ui_seq}">제제</button>
                            <button class="delete" data-seq="${item.cr_seq}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="pager_area">
            <c:forEach begin="1" end="${pageCnt}" var="i">
                <a href="/report/report_info?page=${i}" <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
            </c:forEach>
        </div>
        <form class="search_area" action="/report/report_info">
            <input type="text" name="keyword" placeholder="" value="${keyword}">
            <button type="submit">검색</button>
        </form>

        <div class="popup">
            <div class="popup_box">
                <select id="ui_status">
                    <option value="1">정상</option>
                    <option value="2">정지</option>
                    <option value="3">탈퇴대기</option>
                    <option value="4">탈퇴</option>
                </select>
                <button id="judge">재제</button>
            </div>
        </div>
    </main>
</body>
</html>