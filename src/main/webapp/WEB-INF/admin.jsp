<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the adminsite
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the adminsite
    </jsp:attribute>

    <jsp:body>

        <c:forEach items="${applicationScope.materialArrayList}" var="item">
            ${item}
        </c:forEach>

    </jsp:body>

</t:pagetemplate>