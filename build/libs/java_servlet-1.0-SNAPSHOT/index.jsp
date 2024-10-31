<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP_Servlet Home</title>
</head>
<body>
<h1>Servlet Practice</h1><br/>

<h3>Project URL</h3>
<ul>
    <li>
        <a href="./Uranai">Uranai Servlet</a>
        <p>servletで占い(Servlet Only)</p>
    </li>
    <li>
        <a href="uranai/uranai.jsp">Uranai JSP</a>
        <p>jspで占い(JSP Only)</p>
    </li>
    <li>
        <a href="employee.jsp">javaインスタンス化・JSP</a>
        <p>javaのEmployeeクラスをインスタンス化/jspで表示(java・JSP)</p>
    </li>
    <li>
        <a href="servletForm.jsp">Fromデータの取得・表示</a>
        <p>jspでフォームを作成・送信/servletで取得データを表示(jsp・servlet)</p>
    </li>
    <li>
        <a href="./ServletForward">処理の転送する</a>
        <p>処理を他のservlet/jspに転送する(jsp・servlet)</p>
    </li>
    <li>
        <a href="./ServletRequestScope">リクエストスコープ</a>
        <p>servletで宣言した変数をjspで受け取り表示する(jsp・servlet)</p>
    </li>
    <li>
        <a href="./RegisterUser">ユーザー登録画面/セッションスコープ</a>
        <p>RegisterUserが保持データと遷移先を選択している(java・servlet・jsp)</p>
    </li>
    <li>
        <a href="./MinatoIndex">アプリケーションスコープ</a>
        <p>applicationScopeを使って遷移先にデータを送る(java・servlet・jsp)</p>
    </li>
    <li>
        <a href="dokotubu/dokotubu.jsp">ログイン画面・投稿画面</a>
        <p>ログイン画面と投稿画面を作成(java・servlet・jsp)</p>
    </li>
    <li>
        <a href="./CounterServlet">init()・destroy()</a>
        <p>init()とdestroyの使い方(servlet)</p>
    </li>
    <li>
        <a href="includePage/includeDynamicPage.jsp">include(dynamic)</a>
        <p>動的インクルード(jsp)</p>
    </li>
    <li>
        <a href="includePage/includeStaticPage.jsp">include(static)</a>
        <p>静的インクルード(jsp)</p>
    </li>
    <li>
        <a href="./ELSaveServlet">EL式</a>
        <p>EL式を使用してscope内の変数を利用する(jsp)</p>
    </li>
</ul>
</body>
</html>
