<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>どこつぶ</title>
</head>
<body>
    <h1>どこつぶへようこそ</h1>
    <p>※pass: 1234 only</p>
    <form action="../Login" method="post">
        <label>ユーザー名: <input type="text" name="name"></label><br>
        <label>パスワード: <input type="text" name="pass"></label><br>
        <input type="submit" value="ログイン">
    </form>
</body>
</html>