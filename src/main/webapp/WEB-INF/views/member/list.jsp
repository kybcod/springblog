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
        <div class="col-6">
            <h3 class="mt-4 mb-4">회원 목록</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>NO</th>
                    <th>이메일</th>
                    <th>닉네임</th>
                    <th>가입일자</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">
                <c:forEach items="${memberList}" var="member" varStatus="status">
                    <c:url value="/member" var="viewMember">
                        <c:param name="id" value="${member.id}"/>
                    </c:url>
                    <tr onclick="location.href='${viewMember}'">
                        <td style="color: blue">
                                ${(memberInfo.totalMember) - (memberInfo.currentPage - 1) * 10 -status.index}
                        </td>
                        <td>
                                ${member.email}
                        </td>
                        <td>${member.nickName}</td>
                        <td>${member.inserted}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">


                    <c:if test="${memberInfo.currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link" href="list?page=1">
                                <span aria-hidden="true">&laquo;&laquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <c:if test="${memberInfo.prevPage > 0 }">
                        <li class="page-item">
                            <a class="page-link" href="list?page=${memberInfo.prevPage}">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                    </c:if>


                    <c:forEach var="pageNumber" begin="${memberInfo.beginPage}" end="${memberInfo.endPage}">
                        <li class="page-item ${memberInfo.currentPage eq pageNumber ? 'active' : ''}">
                            <a class="page-link" href="list?page=${pageNumber}">${pageNumber}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${memberInfo.nextPage < memberInfo.lastPage}">
                        <li class="page-item">
                            <a class="page-link" href="list?page=${memberInfo.nextPage}">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${memberInfo.currentPage < memberInfo.lastPage}">
                        <li class="page-item">
                            <a class="page-link" href="list?page=${memberInfo.lastPage}">
                                <span aria-hidden="true">&raquo;&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>

        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
