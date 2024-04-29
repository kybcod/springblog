<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원가입</h1>

<form action="" method="post">
    <div>
        <input type="text" name="member_id" placeholder="아이디">
    </div>
    <div>
            <input type="password" name="password" placeholder="비밀번호">
    </div>
    <div>
        <input type="password" name="passwordCheck" placeholder="비밀번호 확인">
        <button>비밀번호 확인</button>
        <c:if test="${not empty message1}">
            ${message1}
        </c:if>

    <div>
            <input type="text" name="email1" placeholder="이메일 주소"> @
            <select name="email2">
                <option value="naver.com">naver.com</option>
                <option value="daum.net">daum.net</option>
                <option value="gmail.com">gmail.com</option>
                <option value="kakao.com">kakao.com</option>
                <option value="hanmail.net">hanmail.net</option>
            </select>
    </div>
    <div>
        <input type="text" name="birth" placeholder="생년월일 8자리">
    </div>
    <div>
        <input type="text" name="phone" placeholder="휴대전화번호">
    </div>
    <div>
        <input type="submit" value="회원가입">
    </div>
    <div>
    </div>




</form>
</body>
</html>