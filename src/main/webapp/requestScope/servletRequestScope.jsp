<%@ page import="io.github.java_servlet.instance.Animal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>リクエストスコープの値を取得</title>
</head>
<body>
<%
  Animal cat = (Animal) request.getAttribute("cat");
%>

<h1>リクエストスコープのデータ</h1>
<p>name: <%= cat.getName() %></p>
<p>category: <%= cat.getCategory() %></p>
</body>
</html>
