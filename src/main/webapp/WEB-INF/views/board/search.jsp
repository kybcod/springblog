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
        <div class="col-4">
            <h3 class="mb-4"></h3>
            <table class="table">
                <thead>
                <tr>
                    <th>NO</th>
                    <th>제목</th>
                    <th>작성자</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">
                <c:forEach var="search" items="${searchTitle}" varStatus="status">
                    <c:url var="link" value="board/search">
                        <c:param name="title" value="${search.title}"/>
                    </c:url>
                    <tr onclick="location.href='${link}'">
                        <td style="color: blue">${pageInfo.totalBoard - (pageInfo.currentPage - 1) * 10 - status.index}</td>
                        <td>${search.title}</td>
                        <td>${search.writer}</td>
                        <td>${search.inserted}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>

</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>



