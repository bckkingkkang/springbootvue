<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <h1>로그인</h1>
    <button type="submit" onclick="location.href='/member/signup'">회원가입</button>
    <form id="login_form">
        <div>
            <input type="text" placeholder="user Id" name="id">
        </div>
        <div>
            <input type="password" placeholder="user Password" name="password">
        </div>
    </form>
</div>
</body>
<script>

</script>
</html>