<%@ page import="io.github.java_servlet.instance.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loginUser = (User)session.getAttribute("loginUser"); %>

<html>
<head>
    <title>どこつぶ</title>
</head>
<body>
<% if (loginUser != null) { %>
  <p>ログインに成功しました</p>
  <p>ようこそ<%= loginUser.getName() %>さん</p>
  <a href="./Main">つぶやき投稿・閲覧へ</a>
<% } else { %>
  <p>ログインに失敗しました</p>
  <a href="./dokotubu.jsp">Topへ</a>
<% } %>
</body>
</html>
