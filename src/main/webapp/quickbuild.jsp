<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="/error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Byg selv carport
    </jsp:attribute>

    <jsp:attribute name="footer">
            Byg selv carport
    </jsp:attribute>

    <jsp:body>

        <form action="fc/quickbuild" method="post">
            <input type="hidden" name="command" value="quickbuild"/>
            <label for="width">Bredde (min 240 cm og max 600 cm:</label><br>
            <input type="number" id="width" name="width" placeholder="Vælg bredde" min="240" max="600" step="30" required>
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

    </jsp:body>
</t:pagetemplate>

