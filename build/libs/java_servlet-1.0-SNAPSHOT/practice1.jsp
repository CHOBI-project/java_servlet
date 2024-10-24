<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jsp practice1</h1>

<h2>記述方法１</h2>
<%
    String name = "chobi";
    int age = 20;
%>
    <p>名前：<%= name %></p>
    <p>年齢：<%= age %></p><hr>

<h2>記述方法２</h2>
<%
    int rand = (int)(Math.random() * 10);

    for (int i = 0; i < rand; i++) {
%>
<p><%= i %>: Hello World!!</p>
<% } %>
</body>
</html>
