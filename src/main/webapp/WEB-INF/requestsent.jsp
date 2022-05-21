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


        Din forespørgsel indeholder følgende data:
        ${sessionScope.newCarportRequest}

        <label for="svgTegning">Klik her for at se din carport</label>
        <input type="button" value="Klik her" id="svgTegning" onclick="myFunction()"><br><br>

        <div id="carportSVG" name="${requestScope.newCarportRequest}">hej med dig</div>
        <script>
            function myFunction() {
                var button = document.getElementById("svgTegning");
                if (button.click() === true) {
                    carportSVG.style.display = "block";
                } else {
                    carportSVG.style.display = "none";
                }
            }
        </script>


        Din forespørgsel indeholder følgende data:
        ${requestScope.newCarportRequest}

    </jsp:body>
</t:pagetemplate>
