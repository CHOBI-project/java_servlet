<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ログイン成功</title>
    <style>
        <%@ include file="style.css" %>
    </style>
</head>

<body>
<%-- ログイン成功画面(ユーザー表示機能付き) --%>
<h1>ログインが成功しました</h1>
<p>ようこそ${requestScope.name}さん</p>
<a href="./BookListServlet"> 蔵書一覧閲覧画面へ</a>
</body>
</html>
