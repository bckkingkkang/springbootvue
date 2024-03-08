<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HOME</title>
</head>
<body>
    <h1>HOME</h1>

    <div>
    <form id="login_form">
        <div>
            <input type="text" placeholder="user Id" name="id">
        </div>
        <div>
            <input type="password" placeholder="user Password" name="password">
        </div>
    </form>
    </div>
    <div>
        <button type="submit" onclick="location.href='/main'">login</button>
        <button type="submit" onclick="location.href='/list'">board list</button>
    </div>
    <script>

    </script>
</body>
</html>