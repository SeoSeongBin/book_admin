<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css" integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css" integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="/assets/js/common/util.js"></script>
    <link rel="stylesheet" href="/assets/css/header/header.css">
    <link rel="stylesheet" href="/assets/css/default.css">
    <title>Document</title>
    <script>
        $(function(){
            let pageURL = location.href;
            let pageURLSplit = pageURL.split("/");
            console.log(pageURLSplit);
            let realURL = "/";
            for(let i=3; i<pageURLSplit.length; i++) {
                realURL += pageURLSplit[i]
                if(i != pageURLSplit.length-1) realURL += "/";
            }
            realURL = realURL.split("?")[0];
            if(realURL == '/admin/admin_info') {
                $(".admin_a").addClass("on")
            }
            if(realURL == '/user/user_info') {
                $(".user_a").addClass("on")
            }
            if(realURL == '/report/report_info') {
                $(".report_a").addClass("on")
            }
            if(realURL == '/category/category_info') {
                $(".category_a").addClass("on")
            }
            // if(realURL == '/movie/list' || realURL == '/movie/add' || realURL == '/movie/detail') {
            //     $(".movie_list").addClass("on")
            // }
            if(realURL == '/book/book_info') {
                $(".book_a").addClass("on")
            }
            if(realURL == '/library/library_info') {
                $(".library_a").addClass("on")
            }
        })
    </script>
</head>
<body>
    <header>
        <div class="admin_info">
            <div class="damin_profile">
                <c:if test="${loginUser.ai_profile_file != null}">
                    <img src="/img/admin/${loginUser.ai_profile_file}" alt="">
                </c:if>
                <c:if test="${loginUser.ai_profile_file == null}">
                    <img src="/assets/img/admin/default.jpg" alt="">
                </c:if>
            </div>
            <p>${loginUser.ai_name}(${loginUser.ai_id})</p>
            <a href="/admin/logout">로그아웃</a>
        </div>
        <nav>
            <ul>
                <a href="/admin/admin_info" class="admin_a"><li>관리자 관리</li></a>
                <a href="/user/user_info" class="user_a"><li>유저 관리</li></a>
                <a href="/report/report_info" class="report_a"><li>신고 관리</li></a>
                <a href="/category/category_info" class="category_a"><li>카테고리 관리</li></a>
                <a href="/book/book_info" class="book_a"><li>도서 관리</li></a>
                <a href="/library/library_info" class="library_a"><li>도서관 관리</li></a>
            </ul>
        </nav>
    </header>
</body>
</html>