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
    <input type="number" id="width" name="width" placeholder="Vælg bredde" min="240" max="600">
    <br>
    <label for="length">Længde (min 240 cm og max 780 cm:</label><br>
    <input type="number" id="length" name="length" placeholder="Vælg længde" min="240" max="780">
    <br>
    <label for="roof">Længde (min 240 cm og max 780 cm:</label><br>
    <select type="text" id="roof" name="roof" placeholder="Vælg længde" min="240" max="780">
        <option value ="Vælg tagtype">
            Plasttrapezplader
        </option>
    </select>
    <br>

    <input type="checkbox" id="shedOrNoShed" name = "shedOrNoShed" value ="true" onclick=IWantAShed()
     ><label for="shedOrNoShed"> Ønskes skur? Klik her! </label>


</form>
</body>
</html>
