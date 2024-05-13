<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<c:import url="/WEB-INF/fragment/navbar.jsp"/>

<div class="container" style="font-family: 'TTHakgyoansimUndongjangL'">
    <div class="row justify-content-center">
        <div class="col-12 col-xl-5">
            <h3 class="mt-4 mb-4">로그인</h3>
            <form action="/member/login" method="post">
                <div class="mb-3">
                    <label for="InputEmail" class="form-label">이메일</label>
                    <input type="email" class="form-control" id="InputEmail" name="username">
                </div>
                <div class="mb-3">
                    <label for="InputPassword" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="InputPassword" name="password">
                </div>
                <div class="mb-3">
                    <button class="btn btn-primary">로그인</button>
                </div>
                <div>
                    <a href="/oauth2/authorization/naver">
                        <img src="https://i.namu.wiki/i/wC4Xv_cwLVa_AT5XLk0Ma6Wuog1jFLfsGXI3h120K2UHnW9iKG2O50vfs5BlmN0xGrYpmJGCWFAnoxozTpgBVSS0sJKRphiQjuLqpjLCC-oKBKKqbn_sDRyH6lcRhcFKabiHokaKNDlqPpovYc0jpA.svg"
                             width="50px" height="50px"
                             alt="네이버 로그인">
                    </a>
                    <%--                    <a href="/oauth2/authorization/kakao">--%>
                    <%--                        <img src="https://developers.kakao.com/tool/resource/static/img/button/login/full/ko/kakao_login_medium_narrow.png"--%>
                    <%--                             alt="카카오 로그인">--%>
                    <%--                    </a>--%>
                </div>
            </form>

        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
