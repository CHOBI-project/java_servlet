<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<%
  Date date = new Date();
  SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
  String today = formatter.format(date);
%>
<html>
<head>
    <title>静的インクルード</title>
</head>
<body>
  <h1>静的includeページ</h1>
  <h3><%= today %></h3>
  <p><%= user.getId()%></p>
  <p><%= user.getName()%></p>
  <p><%= user.getPass()%></p>
</body>
</html>
