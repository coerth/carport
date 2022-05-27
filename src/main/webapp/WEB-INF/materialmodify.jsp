<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Rediger materialer
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the adminsite
    </jsp:attribute>

    <jsp:body>

        <form action="modify" method="post">
            <input type="hidden" name="command" value="materialmodify"/>
            <input type="hidden" name="materialId" value="${requestScope.material.materialId}">
            <div class="form-group">
                <label for="name">Navn</label>
                <input type="text" class="form-control" name="name" id="name" value="${requestScope.material.name}">
            </div>
            <div class="form-group">
                <label for="price">Pris</label>
                <input type="number" class="form-control" name="price" id="price" value="${requestScope.material.price}">
            </div>
            <div class="form-group">
                <label for="unit">Enhed</label>
                <input type="text" class="form-control" name="unit" id="unit" value="${requestScope.material.unit}">
            </div>
            <div class="form-group">
                <label for="unit">Antal</label>
                <input type="text" class="form-control" name="quantity" id="quantity" value="${requestScope.material.quantity}">
            </div>
            <div class="form-group">
                <label for="length">Længde</label>
                <input type="number" class="form-control" name="length" id="length" value="${requestScope.material.length}">
            </div>
            <div class="form-group">
                <label for="width">Bredde</label>
                <input type="number" class="form-control" name="width" id="width" value="${requestScope.material.width}">
            </div>
            <div class="form-group">
                <label for="height">Højde</label>
                <input type="number" class="form-control" name="height" id="height" value="${requestScope.material.height}">
            </div>
            <div class="form-group">
                <label for="typeId">Type ID</label>
                <input type="number" class="form-control" name="typeId" id="typeId" value="${requestScope.material.typeId}">
            </div>

            <button type="submit" class="btn btn-primary">Godkend</button>
        </form>



    </jsp:body>

</t:pagetemplate>