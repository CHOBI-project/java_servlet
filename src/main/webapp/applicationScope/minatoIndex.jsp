<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="io.github.java_servlet.instance.SiteEV" %>
<% SiteEV siteEV = (SiteEV)application.getAttribute("siteEV"); %>
<html>
<head>
    <title>湊くんのページ</title>
</head>
<body>
    <h1>湊くんのページにようこそ</h1>
    <p>
        <a href="./MinatoIndex?action=like">よいね</a>:
        <%= siteEV.getLike() %>人
        <a href="./MinatoIndex?action=dislike">よくないね</a>:
        <%= siteEV.getDislike() %>人
    </p>

    <h2>湊くんとは？</h2>
    <p>・・・</p>
</body>
</html>
