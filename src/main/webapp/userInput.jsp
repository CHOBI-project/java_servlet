<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>ユーザー登録</title>
</head>
<body>
  <h1>ユーザー登録画面</h1>
  <form action="./register-user" method="post">
    <label>ログインID: <input type="text" name="id"></label><br>
    <label>パスワード: <input type="password" name="pass"></label><br>
    <label>名前:      <input type="text" name="name"></label>
    <input type="submit" value="登録">
  </form>
</body>
</html>
