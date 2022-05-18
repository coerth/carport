<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Forespørgelse
    </jsp:attribute>

    <jsp:attribute name="footer">
            Forespørgelse
    </jsp:attribute>

    <jsp:body>

        <h3>Her er forespørgelse nr ${requestScope.carportRequest.requestId}</h3>

        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Forespørgsel ID</th>
                <th scope="col">Længde</th>
                <th scope="col">Bredde</th>
                <th scope="col">Tagtype</th>
                <th scope="col">Taghældning</th>
                <th scope="col">Godkendt</th>
                <th scope="col">Skur Længde</th>
                <th scope="col">Skur Bredde</th>

            </tr>
            </thead>
            <tbody>

                <tr>
                    <th  scope="row">${requestScope.carportRequest.requestId}</th>
                    <td>${requestScope.carportRequest.length}</td>
                    <td>${requestScope.carportRequest.width}</td>
                    <td>${requestScope.carportRequest.roofType}</td>
                    <td>${requestScope.carportRequest.roofIncline}</td>
                    <td>${requestScope.carportRequest.approved}</td>
                    <td>${requestScope.carportRequest.shedLength}</td>
                    <td>${requestScope.carportRequest.shedWidth}</td>
                </tr>
                <br>
            </tbody>
        </table>

        <h3>Kunde Oplysninger:</h3>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Kunde ID</th>
                <th scope="col">Kunde Navn</th>
                <th scope="col">Kunde Adresse</th>
                <th scope="col">Mobil Nr.</th>

            </tr>
            </thead>
            <tbody>
                <tr>
                    <th  scope="row">${requestScope.customer.customerId}</th>
                    <td>${requestScope.customer.name}</td>
                    <td>${requestScope.customer.address}</td>
                    <td>${requestScope.customer.mobile}</td>
                </tr>
                <br>
            </tbody>
        </table>

        <form action="fc/approveRequest"><input type="hidden" name="command" value="requestapprove"/><button name="requestId" class="btn btn-success" value="${requestScope.carportRequest.requestId}">Godkend</button></form>
        <form action="fc/denyRequest"><input type="hidden" name="command" value="requestdeny"/><button name="requestId" class="btn btn-outline-danger" value="${requestScope.carportRequest.requestId}">Afvis</button></form>


    </jsp:body>
</t:pagetemplate>