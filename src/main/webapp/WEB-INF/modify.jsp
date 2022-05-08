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

        ${requestScope.material.name}

        <form>
            <div class="form-group">
                <label for="name">Navn</label>
                <input type="text" class="form-control" id="name" value=${requestScope.material.name}>
            </div>
            <div class="form-group">
                <label for="price">Pris</label>
                <input type="text" class="form-control" id="price" value=${requestScope.material.price}>
            </div>
            <div class="form-group">
                <label for="unit">Enhed</label>
                <input type="text" class="form-control" id="unit" value=${requestScope.material.unit}>
            </div>
            <div class="form-group">
                <label for="length">Længde</label>
                <input type="text" class="form-control" id="length" value=${requestScope.material.length}>
            </div>
            <div class="form-group">
                <label for="width">Bredde</label>
                <input type="text" class="form-control" id="width" value=${requestScope.material.width}>
            </div>
            <div class="form-group">
                <label for="height">Højde</label>
                <input type="text" class="form-control" id="height" value=${requestScope.material.height}>
            </div>
            <div class="form-group">
                <label for="typeId">Typde ID</label>
                <input type="text" class="form-control" id="typeId" value=${requestScope.material.typeId}>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>



    </jsp:body>

</t:pagetemplate>