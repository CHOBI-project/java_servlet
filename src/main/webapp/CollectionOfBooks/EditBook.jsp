<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>情報更新画面</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>

<body>
<h1>蔵書情報更新</h1>
<div class="errorMsg">
    <p>${requestScope.titleError}</p>
    <p>${requestScope.authorError}</p>
    <p>${requestScope.publisherError}</p>
    <p>${requestScope.publishDateError}</p>
</div>

<form action="./UpdateBookServlet" method="post">
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
    <input type="hidden" name="id" value="${requestScope.id}">
    <input type="submit" value="更新">
</form>

<p>
    <button id="deleteButton">削除</button>
</p>

<a href="./BookListServlet">蔵書一覧に戻る</a>

<script>
    'use strict';

    const deleteButton = document.getElementById("deleteButton");

    deleteButton.addEventListener("click", () => {
        const flag = confirm("本当に削除しますか?");

        if (flag) {
            window.location.href = "./DeleteBookServlet?id=${requestScope.id}";
        }
    })
</script>
</body>
</html>
