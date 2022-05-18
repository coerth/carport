<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Forespørgselsliste
    </jsp:attribute>

    <jsp:attribute name="footer">
            Forespørgselsliste
    </jsp:attribute>

    <jsp:body>

        <h3>Her er alle forespørgelser</h3>

        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Kunde ID</th>
                <th scope="col">Forespørgsel ID</th>
                <th scope="col">Længde</th>
                <th scope="col">Bredde</th>
                <th scope="col">Tagtype</th>
                <th scope="col">Taghældning</th>
                <th scope="col">Godkendt</th>
                <th scope="col">Skur Længde</th>
                <th scope="col">Skur Bredde</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${requestScope.carportRequestArraylist}">
                <tr>
                    <th  scope="row">${item.customerId}</th>
                    <td>${item.requestId}</td>
                    <td>${item.length}</td>
                    <td>${item.width}</td>
                    <td>${item.roofType}</td>
                    <td>${item.roofIncline}</td>
                    <td>${item.}</td>
                    <td>${item.typeId}</td>
                    <td><form action="fc/delete"><input type="hidden" name="command" value="deletematerial"/><button name="delete" value="${item.materialId}">Slet</button> </form><button name="modify" value="${item.materialId}">Rediger</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>
</t:pagetemplate>