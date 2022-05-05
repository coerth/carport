<%--
  Created by IntelliJ IDEA.
  User: yelon
  Date: 05-05-2022
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrering</title>
</head>
<body>
<form action="fc/Register">
    <label for="name">Navn:</label><br>
    <input type="text" id="name" name="name" placeholder="Skriv dit navn"><br>
    <label for="adr">Adresse:</label><br>
    <input type="text" id="adr" name="adr" placeholder="Adresse"><br><br>
    <label for="city">By:</label><br>
    <input type="text" id="city" name="city" placeholder="By"><br><br>
    <label for="zip">Postnummer:</label><br>
    <input type="number" min="4" max="4" id="zip" name="zip" placeholder="Postnummer"><br><br>
    <label for="mobile">Mobil:</label><br>
    <input type="text" id="mobile" name="mobile" placeholder="Mobil"><br><br>
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" placeholder="Email"><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" placeholder="Password"><br><br>
    <input type="submit" value="Godkend">
</form>
</body>
</html>
