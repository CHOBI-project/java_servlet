<%@ page import="java.util.List" %>
<%@ page import="io.github.java_servlet.CollectionOfBooks.DAO.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<html>
<head>
    <title>蔵書一覧画面</title>
    <style>
        <%@ include file="../style.css" %>
    </style>
</head>

<body>
<h1>蔵書一覧</h1>
<button>
    <a href="./ShowRegisterBookServlet" class="button">新規蔵書登録</a>
</button>

<form action="./BookListServlet" method="post">
    <p>
        <label>
            タイトル : <input type="text" name="title" value="${requestScope.title}" placeholder="タイトルで検索">
        </label>
    </p>
    <p>
        <label>
            著者 : <input type="text" name="author" value="${requestScope.author}" placeholder="著者で検索">
        </label>
    </p>
    <p>
        <label>
            出版社 : <input type="text" name="publisher" value="${requestScope.publish}" placeholder="出版社で検索">
        </label>
    </p>
    <input type="submit" value="検索">
</form>

<p class="errorMsg">${requestScope.errorMsg}</p>

<button>
    <a href="./BookListServlet" class="button">一覧を表示</a>
</button>

<table border="1">
    <tr>
        <th>ID</th>
        <th>タイトル</th>
        <th>著者</th>
        <th>出版社</th>
        <th>出版日</th>
    </tr>

    <% for (int i = 0; i < books.size(); i++) { %>
    <tr>
        <td><%= books.get(i).getId() %></td>
        <td><a href="#"><%= books.get(i).getTitle() %></a></td>
        <td><%= books.get(i).getAuthor() %></td>
        <td><%= books.get(i).getPublisher() %></td>
        <td><%= books.get(i).getGetPublishDate() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
