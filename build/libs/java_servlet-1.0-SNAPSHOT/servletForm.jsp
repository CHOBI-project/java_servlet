<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formの入力データを取得・表示する</title>
</head>
<body>
    <h1>ユーザー登録画面</h1>
    <form action="./servlet-form" method="post">
        <label>name: <input type="text" name="name"></label><br>
        <label>man: <input type="radio" name="gender" value="0"></label><br>
        <label>woman: <input type="radio" name="gender" value="1"></label><br>
        <input type="submit" value="登録">
    </form>
</body>
</html>
