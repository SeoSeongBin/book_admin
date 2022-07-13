<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/user/user_info.css">
    <script src="/assets/js/user/user_info.js"></script>
</head>
<body>
    <main>
        <div class="page_header">
            <h2>유저 관리</h2>
        </div>

        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>아이디</td>
                    <td>이름</td>
                    <td>닉네임</td>
                    <td>생년월일</td>
                    <td>성별</td>
                    <td>가입일</td>
                    <td>상태</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.ui_seq}</td>
                        <td>${item.ui_id}</td>
                        <td>${item.ui_name}</td>
                        <td>
                            <c:if test="${item.ui_nickname == null}">null</c:if>
                            <c:if test="${item.ui_nickname != null}">${item.ui_nickname}</c:if>
                            
                        </td>
                        <td>
                            <fmt:formatDate value="${item.ui_bir_dt}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${item.ui_gen == 1}">남자</c:when>
                                <c:when test="${item.ui_gen == 2}">여자</c:when>
                            </c:choose>
                        </td>
                        <td>
                            <fmt:formatDate value="${item.ui_reg_dt}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${item.ui_status == 1}">정상</c:when>
                                <c:when test="${item.ui_status == 2}">정지</c:when>
                                <c:when test="${item.ui_status == 3}">탈퇴대기</c:when>
                                <c:when test="${item.ui_status == 4}">탈퇴</c:when>
                            </c:choose>
                            
                        </td>
                        <td>
                            <button class="user_modify" data-seq="${item.ui_seq}">수정</button>
                            <button class="delete" data-seq="${item.ui_seq}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:forEach begin="1" end="${pageCnt}" var="i">
                <c:if test="${country != null}">
                    <a href="/user/user_info?page=${i}&keyword=${keyword}&country=${country}"
                        <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
                </c:if>
                <c:if test="${country == null}">
                    <a href="/user/user_info?page=${i}&keyword=${keyword}"
                    <c:if test="${page == i}">class="current"</c:if>
                    >${i}</a>
                </c:if>
            </c:forEach>


            <div class="mod_popup">
                <div class="mod_popup_box">
                    <h2>유저 수정</h2>
                    <div class="id">
                        <p>아이디</p>
                        <input type="text" id="ui_id" placeholder="아이디">
                    </div>
                    <div class="pwd">
                        <p>비밀번호</p>
                        <input type="password" id="ui_pwd" placeholder="비밀번호">
                    </div>
                    <div class="name">    
                        <p>이름</p>
                        <input type="text" id="ui_name" placeholder="이름">
                    </div>
                    <div class="nickname">
                        <p>닉네임</p>
                        <input type="text" id="ui_nickname" placeholder="닉네임">
                    </div>
                    <div class="birth">
                        <p>생년월일</p>
                        <input type="text" id="ui_bir_dt" placeholder="생년월일" autocomplete='off'>
                    </div>
                    <div class="gen">
                        <p>성별</p>
                        <input type="radio" name="gen" value="1">남자
                        <input type="radio" name="gen" value="2">여자
                        <input type="radio" name="gen" value="3">선택안함
                    </div>
                    <div class="status">
                        <p>상태</p>
                        <select id="ui_status">
                            <option value="1">정상</option>
                            <option value="2">정지</option>
                            <option value="3">탈퇴대기</option>
                            <option value="4">탈퇴</option>
                        </select>
                    </div>
                    <div class="btn_area">
                        <button id="modify">수정</button>
                        <button id="cancel">취소</button>
                    </div>
                </div>
            </div>
    </main>
</body>
</html>