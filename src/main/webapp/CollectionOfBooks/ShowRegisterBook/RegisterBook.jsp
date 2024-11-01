<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>蔵書新規登録画面</title>
    <style>
      <%@include file="../style.css" %>
    </style>
</head>

<body>
<h1>新規蔵書登録</h1>
<p>メッセージ出力エリア</p>

<form action="./RegisterBookServlet" method="post">
    <p>
        <label>
            タイトル : <input type="text" name="title" value="">
        </label>
    </p>
    <p>
        <label>
            著者 : <input type="text" name="author" value="">
        </label>
    </p>
    <p>
        <label>
            出版社 : <input type="text" name="publisher" value="">
        </label>
    </p>
    <p>
        <label>
            出版日 : <input type="date" name="publish-date" value="">
        </label>
    </p>
    <input type="submit" value="登録">
</form>

<a href="./BookListServlet">蔵書一覧に戻る</a>
</body>
</html>
