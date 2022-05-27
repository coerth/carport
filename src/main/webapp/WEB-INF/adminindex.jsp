<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Admin side
    </jsp:attribute>

    <jsp:attribute name="footer">
            Admin side
    </jsp:attribute>

    <jsp:body>

        <h3>Se alle ordrer</h3>
        <form method="post" action="orderoverview">
            <input type="hidden" name="command" value="orderoverview">
            <button type="submit">Vælg</button>
        </form>

        <h3>Se alle forespørgsler</h3>
        <form method="post" action="requestoverview">
            <input type="hidden" name="command" value="requestoverview">
            <button type="submit">Vælg</button>
        </form>

        <h3>Gå til lager</h3>
        <form method="post" action="materialoverview">
            <input type="hidden" name="command" value="materialoverview">
            <button type="submit">Vælg</button>
        </form>

    </jsp:body>
</t:pagetemplate>
