<%--
  Created by IntelliJ IDEA.
  User: adria
  Date: 16.10.2020
  Time: 00:48
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="style.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logginn</title>
</head>
<body>
<form action="handleliste" method="post">
    <h2>Skriv inn passord:</h2>
    <span class="errorText">${feilmelding}</span>
    <div class="input-field">
        <label for="passord">Passord:</label>
        <input id="passord" type="password" name="passord"/>

    </div>
    <br>
    <br>


    <div >
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
