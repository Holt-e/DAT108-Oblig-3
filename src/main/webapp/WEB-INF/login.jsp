<%--
  Created by IntelliJ IDEA.
  User: adria
  Date: 16.10.2020
  Time: 00:48
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="style.css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logginn</title>
</head>
<body>
<form action="login" method="post">
    <h2>Skriv inn passord:</h2>
    <div class="input-field">
        <label for="password">Passord</label>
        <input id="password" type="password" name="password"/>

    </div>
    <br>
    <br>
    <span class="red-text">${loginMessage}</span>

    <div class="card-action">
        <button class="waves-effect waves-light btn" type="button"
                onclick="window.location.href = 'handleliste';">Login
        </button>
</form>
</body>
</html>
