<%@ page import="io.github.java_servlet.instance.Animal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  request.setAttribute("color", "青");
%>
<html>
<head>
    <title>EL式</title>
</head>
<body>
  <h1>EL式</h1>
  <div style="display: flex; justify-content: space-around">
    <p>pageScope</p>
    <p>requestScope</p>
    <p>sessionScope</p>
    <p>applicationScope</p>
  </div><hr>

  <p>color: ${color}</p><hr>

  <p>name: ${requestScope.cat.getName()}</p>
  <p>category: ${requestScope.cat.getCategory()}</p><hr>

  <p>name: ${requestScope.dog.getName()}</p>
  <p>category: ${requestScope.dog.getCategory()}</p><hr>
</body>
</html>
