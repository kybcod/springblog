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
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <form action="/member/modify" method="post">
                <input type="hidden" name="id" value="${member.id}">
                <div class="mb-3">
                    <label for="InputEmail" class="form-label">이메일</label>
                    <input id="InputEmail" type="text" class="form-control" name="email" value="${member.email}" disabled>
                </div>
                <div class="mb-3">
                    <label for="InputPassword" class="form-label">비밀번호</label>
                    <input id="InputPassword" type="text" class="form-control" name="password" value="${member.password}">
                </div>
                <div class="mb-3">
                    <label for="InputCheckPassword" class="form-label">비밀번호 확인</label>
                    <input id="InputCheckPassword" type="text" class="form-control" name="passwordCheck" value="${member.passwordCheck}">
                </div>
                <div class="mb-3">
                    <label for="InputNickName" class="form-label">닉네임</label>
                    <input id="InputNickName" type="text" class="form-control" name="nickName" value="${member.nickName}">
                </div>
                <div class="mb-3">
                    <label for="InputInserted" class="form-label">가입일자</label>
                    <input id="InputInserted" type="text" class="form-control" name="inserted" value="${member.inserted}">
                </div>
                <div class="mb-3">
                    <button class="btn btn-secondary">수정</button>
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
