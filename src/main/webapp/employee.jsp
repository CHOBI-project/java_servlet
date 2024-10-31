<%@ page import="io.github.java_servlet.instance.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>インスタンス化・表示</title>
</head>
<body>
<h1>クラスファイルをインスタンス化して生成したものを表示</h1>
<% for (int i = 0; i < 10; i++) {
    Employee human = new Employee(i, "tanaka");

    if (i % 3 == 0) { %>
     <p style="color: red">id：<%= human.getId() %></p>
     <p style="color: red">name：<%= human.getName() %></p>
<%  } else { %>
     <p>id：<%= human.getId() %></p>
     <p>name：<%= human.getName() %></p>
<%  } %>
<% } %>
</body>
</html>
