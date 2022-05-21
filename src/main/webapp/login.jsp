<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Log ind
    </jsp:attribute>

    <jsp:attribute name="footer">
            Log ind
    </jsp:attribute>

    <jsp:body>

        <h3>Her kan du logge ind</h3>

        <form action="fc/login" method="post">
            <input type="hidden" name="command" value="login"/>
            <label for="email">Email: </label>
            <input type="text" id="email" name="email"/>
            <label for="password">Kodeord: </label>
            <input type="password" id="password" name="password"/>
            <input type="submit"  value="Log ind"/>
        </form>

    </jsp:body>
</t:pagetemplate>