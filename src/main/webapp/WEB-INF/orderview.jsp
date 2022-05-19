<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Ordreoversigt
    </jsp:attribute>

    <jsp:attribute name="footer">
            Ordreoversigt
    </jsp:attribute>

    <jsp:body>

        <h3>Ordren med id ${requestScope.orderDTO.order.orderId} er nu sendt til kunden.</h3>

        <br>Husk at kigge ordren igennem og gå evt. tilbage og ret i den.

        <thead>
        <tr>
            <th scope="col">Ordre id</th>
            <th scope="col">Dato og tid</th>
            <th scope="col">Kundens id</th>
            <th scope="col">Carport type (1 = intet skur, 2 = skur)</th>


        </tr>
        </thead>
        <tbody>

        <tr>
            <th  scope="row">${requestScope.orderDTO.order.orderId}</th>
            <td>${requestScope.orderDTO.order.dateTime}</td>
            <td>${requestScope.orderDTO.order.customerId}</td>
            <td>${requestScope.orderDTO.order.carportType}</td>

        </tr>
        <br>
        Ordren indeholder:
        <table class="table table-striped table-hover">

        <br>
        <thead>
        <tr>
            <th scope="col">Materiale:</th>
            <th scope="col">Beskrivelse:</th>
            <th scope="col">Antal: </th>
            <th scope="col">Pris: </th>


        </tr>
        </thead>
        <tbody>
    <c:forEach var="item" items="${requestScope.orderDTO.bomlineArrayList}">
        <tr>
            <td>${item.material.name}</td>
            <td>${item.descriptionId}</td>
            <td>${item.quantity}</td>
            <td>${item.material.price * item.quantity}</td>

        </tr>
    </c:forEach>

        </tbody>
        </table>


        <p><a href="../index.jsp">Til forsiden</a></p>

    </jsp:body>
</t:pagetemplate>
