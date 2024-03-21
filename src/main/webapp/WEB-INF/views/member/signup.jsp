<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/member/signup" method="post">
            <div class="container">
                <h1>회원 가입</h1>
                <div>
                    <label for="name">이름</label>
                    <input type="text" id="name" name="name" placeholder="user NAME">
                </div>
                <div>
                    <label for="id">아이디</label>
                    <input type="text" id="id" name="id" placeholder="user ID">
                </div>
                <div>
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" placeholder="user PASSWORD">
                </div>
                <div>
                    <label for="password_check">비밀번호 확인</label>
                    <input type="password" id="password_check" name="password_check" placeholder="PASSWORD CHECK">
                </div>
                <div>
                    <label for="phone">전화번호</label>
                    <input type="text" id="phone" name="phone" placeholder="user PHONE">
                </div>
            </div>
            <button type="submit">가입하기</button>

        </form>
    </div>
</body>
<script>

</script>
</html>