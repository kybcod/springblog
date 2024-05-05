<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<div class="container" >
    <div class="row justify-content-center">
        <div class="col-4">
                <div class="mb-3">
                    <label for="InputTitle" class="form-label">제목</label>
                    <input id="InputTitle" type="text" class="form-control" name="title" value="${board.title}" readonly>
                </div>
                <div class="mb-3">
                    <label for="InputContent" class="form-label">본문</label>
                    <textarea id="InputContent" class="form-control" name="content" cols="30" rows="10" readonly>${board.content}</textarea>
                </div>
                <div class="mb-3">
                    <label for="InputWriter" class="form-label">작성자</label>
                    <input id="InputWriter" type="text" class="form-control" name="writer" value="${board.writer}" readonly>
                </div>
                <div class="mb-3">
                    <label for="InputInserted" class="form-label">작성자</label>
                    <input id="InputInserted" type="text" class="form-control" name="inserted" value="${board.inserted}" readonly>
                </div>
                <div class="mb-3">
                    <form action="/board/delete" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?')">
                        <input type="hidden" name="id" value="${board.id}">
                        <button class="btn btn-primary">게시글 삭제</button>
                    </form>
                    <a href="/board/update" class="btn btn-secondary">게시글 수정</a>
                </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
