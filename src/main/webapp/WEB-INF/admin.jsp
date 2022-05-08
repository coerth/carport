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
        <br>
        <br>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Materiale ID</th>
                    <th scope="col">Navn</th>
                    <th scope="col">Pris</th>
                    <th scope="col">Enhed</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Bredde</th>
                    <th scope="col">Højde</th>
                    <th scope="col">Type ID</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${applicationScope.materialArrayList}">
                <tr>
                    <th  scope="row">${item.materialId}</th>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.unit}</td>
                    <td>${item.length}</td>
                    <td>${item.width}</td>
                    <td>${item.height}</td>
                    <td>${item.typeId}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>

</t:pagetemplate>