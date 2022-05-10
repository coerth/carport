<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hvore
  Date: 06-05-2022
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Byg selv carport</title>
</head>
<body>

<form action="fc/quickbuild" method="post">
    <input type="hidden" name="command" value="quickbuild"/>
    <label for="width">Bredde (min 240 cm og max 600 cm:</label><br>
    <input type="number" id="width" name="width" placeholder="Vælg bredde" min="240" max="600" step="30">
    <br>
    <label for="length">Længde (min 240 cm og max 780 cm:</label><br>
    <input type="number" id="length" name="length" placeholder="Vælg længde" min="240" max="780" step="30">
    <br>
    <label for="roof">Vælg tag-type:</label><br>
    <select type="text" id="roof" name="roof">
        <option value ="Plasttrapezplader">
            Plasttrapezplader
        </option>
        <option value ="Tegltag">
            Tegltag
        </option>
    </select>
    <br>

    <input type="checkbox" id="shedOrNoShed" name = "shedOrNoShed" value ="false" >
    <label for="shedOrNoShed"> Ønskes skur? Klik her! </label>
    <br>
    <label for="shedWidth">Skurbredde (min 210 cm og max 720 cm:</label><br>
    <input type="number" id="shedWidth" name ="shedWidth" placeholder="Vælg bredde på dit skur" min="210" max="720" step="30">
    <br>
    <label for="shedLength">Længde (min 150 cm og max 690 cm:</label><br>
    <input type="number" id="shedLength" name ="shedLength" placeholder="Vælg længde på dit skur" min="150" max="690" step="30">

    <input type="submit" value="Vælg">



</form>
</body>
</html>
