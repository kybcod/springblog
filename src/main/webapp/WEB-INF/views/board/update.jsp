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

<div class="container">
    <div class="row justify-content-center">
        <div class="col-4">
            <h3 class="mb-4"></h3>
            <form action="/update" method="post">
                <input type="hidden" name="id" value="${board.id}">
                <div class="mb-3">
                    <label for="InputTitle" class="form-label">제목</label>
                    <input id="InputTitle" type="text" class="form-control" name="title" value="${board.title}">
                </div>
                <div class="mb-3">
                    <label for="InputContent" class="form-label">본문</label>
                    <textarea id="InputContent" class="form-control" name="content" cols="30"
                              rows="10">${board.content}</textarea>
                </div>
                <div class="mb-3">
                    <label for="InputInserted" class="form-label">작성일</label>
                    <input id="InputInserted" type="text" class="form-control" name="inserted" value="${board.inserted}"
                           disabled>
                </div>
                <div class="mb-3">
                    <button class="btn btn-primary">게시글 수정</button>
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
