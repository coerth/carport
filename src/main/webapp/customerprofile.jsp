<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Kundeoplysninger
    </jsp:attribute>

    <jsp:attribute name="footer">
        Kundeoplysninger
    </jsp:attribute>

    <jsp:body>

        <form action="">

            ${requestScope.AccountDTO.name}

        </form>




    </jsp:body>

</t:pagetemplate>