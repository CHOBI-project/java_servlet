<%@ page import="io.github.java_servlet.instance.User" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>ユーザー登録確認画面</title>
</head>
<body>
<%
  User registerUser = (User)session.getAttribute("registeredUser");
%>
<p>以下の登録内容でよろしいですか？</p>

<p>ログインID: <%= registerUser.getId() %></p>
<p>名前: <%= registerUser.getName() %></p>

<a href="./RegisterUser">戻る</a>
<a href="./RegisterUser?action=done">登録する</a>
</body>
</html>