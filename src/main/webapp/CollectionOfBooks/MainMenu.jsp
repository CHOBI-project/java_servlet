<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>メインメニュー画面</title>
    <style>
        <%@ include file="style.css" %>
    </style>
</head>

<body>
<h1>図書館蔵書検索</h1>
<form action="./LoginServlet" method="post">
    <P>
        <label>
            ユーザー名 : <input type="text" name="name">
        </label>
    </P>
    <P>
        <label>
            パスワード : <input type="text" name="pass">
        </label>
    </P>
    <button type="submit">ログイン</button>
</form>
</body>
</html>
