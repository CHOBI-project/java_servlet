<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>占い</title>
</head>
<body>
<%
  String[] luckArray = {"超ラッキー", "ラッキー", "最悪"};
  int index = (int)(Math.random() * 3);

  Date date = new Date();
  SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
  String today = formatter.format(date);
%>

<h1>占い結果</h1>
<p><%= today %>の運勢は、<%= luckArray[index] %>です！</p>
</body>
</html>
