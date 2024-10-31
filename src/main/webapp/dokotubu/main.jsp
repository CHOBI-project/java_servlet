<%@ page import="io.github.java_servlet.instance.User" %>
<%@ page import="io.github.java_servlet.instance.Mutter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User loginUser = (User)session.getAttribute("loginUser");
    List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
    String errorMsg = (String) request.getAttribute("errorMsg");
%>
<html>
<head>
    <title>どこつぶ</title>
</head>
<body>
  <h1>どこつぶメイン</h1>
  <p>
      <%= loginUser.getName() %>さん、ログイン中
      <a href="./Logout">ログアウト</a>
  </p>

  <p><a href="./Main">更新</a></p>
  <form action="./Main" method="post">
      <label><input type="text" name="text"></label>
      <label><input type="submit" value="つぶやく"></label>
  </form>

  <% if (errorMsg != null) { %>
  <p><%= errorMsg %></p>
  <% } %>

<% for (Mutter mutter : mutterList) { %>
  <p><%= mutter.getUserName() %> : <%= mutter.getText() %></p>
<% } %>
</body>
</html>
