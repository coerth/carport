<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Rediger kundeoplysninger
    </jsp:attribute>

    <jsp:attribute name="footer">
        Rediger kundeoplysninger
    </jsp:attribute>

    <jsp:body>

        <form action="fc/">
            <input type="hidden" name="command" value="customermodify"/>
            <div class="mb-3">
                <label for="name" class="form-label">Navn:</label>
                <br>
                <input type="text" class="form-label" id="name" value="${sessionScope.customer.name}">

            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <br>
                <input type="email" class="form-label" id="email" value="${sessionScope.customer.getEmail()}">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <br>
                <input type="password" class="form-label" id="password" value="${sessionScope.customer.getPassword()}">
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">By:</label>
                <br>
                <input type="text" class="form-label" id="city" value="${sessionScope.customer.city}">
            </div>
            <div class="mb-3">
                <label for="zip" class="form-label">Postnummer:</label>
                <br>
                <input type="number" class="form-label" id="zip" value="${sessionScope.customer.zip}">
            </div>
            <div class="mb-3">
                <label for="mobile" class="form-label">Telefon nr.:</label>
                <br>
                <input type="number" class="form-label" id="mobile" value="${sessionScope.customer.mobile}">
            </div>
            <button type="submit">Opdater</button>
        </form>



    </jsp:body>

</t:pagetemplate>