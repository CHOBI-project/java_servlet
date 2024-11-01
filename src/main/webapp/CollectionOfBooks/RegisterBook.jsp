<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>蔵書新規登録画面</title>
    <style>
      <%@include file="style.css" %>
    </style>
</head>

<body>
<h1>新規蔵書登録</h1>
<div class="errorMsg">
    <p>${requestScope.titleError}</p>
    <p>${requestScope.authorError}</p>
    <p>${requestScope.publisherError}</p>
    <p>${requestScope.publishDateError}</p>
</div>

<form action="./RegisterBookServlet" method="post">
    <p>
        <label>
            タイトル : <input type="text" name="title" value="${requestScope.title}">
        </label>
    </p>
    <p>
        <label>
            著者 : <input type="text" name="author" value="${requestScope.author}">
        </label>
    </p>
    <p>
        <label>
            出版社 : <input type="text" name="publisher" value="${requestScope.publisher}">
        </label>
    </p>
    <p>
        <label>
            出版日 : <input type="date" name="publish-date" value="${requestScope.publishDate}">
        </label>
    </p>
    <input type="submit" value="登録">
</form>

<a href="./BookListServlet">蔵書一覧に戻る</a>
</body>
</html>
