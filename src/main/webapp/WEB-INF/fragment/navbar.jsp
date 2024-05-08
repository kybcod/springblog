<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        @font-face {
            font-family: 'TTHakgyoansimUndongjangL';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2402_keris@1.0/TTHakgyoansimUndongjangL.woff2') format('woff2');
            font-weight: 300;
            font-style: normal;
        }

    </style>
</head>
<body>

<nav class="navbar" style="background-color: skyblue; font-family: 'TTHakgyoansimUndongjangL'">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">YBK</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/member/list">회원 목록</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/member?id=${member.id}">내 정보</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="not isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/member/join">회원가입</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/insert">게시글 쓰기</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="not isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/member/login">로그인</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">로그아웃</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>

<%--로그인 권한 : home, memberList,board Insert--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</body>
</html>
