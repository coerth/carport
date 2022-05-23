<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Din forespørgsel
    </jsp:attribute>

    <jsp:attribute name="footer">
            Forespørgsel

    </jsp:attribute>

    <jsp:body>


        <label for="svgTegning">Klik her for at se din carport</label>
        <input type="button" value="Klik her" id="svgTegning" onclick="myFunction()"><br><br>

        <button id="toggle" onclick="myFunction()">Vis carport tegning</button>
        <div id="carportSVG">${requestScope.newCarportRequest}</div>

        <script>
            const targetDiv = document.getElementById("carportSVG");
            const button = document.getElementById("toggle");
            button.onclick = function () {
                if (targetDiv.style.display !== "none") {
                    targetDiv.style.display = "none";
                } else {
                    targetDiv.style.display = "block";
                }
            };
        </script>



    </jsp:body>
</t:pagetemplate>
