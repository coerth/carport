<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         VELKOMMEN TIL FOG TRÆLAST OG BYGGECENTER
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>


        <c:if test="${sessionScope.customer == null}">
            <p>For at begynde at shoppe din nye carport, skal du først logge ind her: <a
                    href="login.jsp">Log ind</a></p>
            <br>Hvis ikke du allerede har en bruger, kan du registrere dig her: <a
                href="register.jsp">Registrer</a>
        </c:if>

        <c:if test="${sessionScope.customer != null}">
          <div class="row">
          <div class="col-sm-6">
            <div class="card" style="width: 18rem;">
                <img src="..." class="card-img-top" alt="Byg selv">
                <div class="card-body">
                    <h5 class="card-title">Byg selv</h5>
                    <p class="card-text">Her kan du selv bygge en carport ud fra dine ønskede mål.</p>
                    <a href="#" class="btn btn-primary">Vælg</a>
                </div>
            </div>
          </div>
            <div class="col-sm-6">
            <div class="card" style="width: 18rem;">
                <img src="${pageContext.request.contextPath}/images/ProductModel.png" class="card-img-top" alt="Standard carport">
                <div class="card-body">
                    <h5 class="card-title">Standard carport</h5>
                    <p class="card-text">Vælg ud fra vores store udvalg af carporte!</p>
                    <a href="https://www.johannesfog.dk/byggecenter/have--fritid/byg-selv-produkter/" class="btn btn-primary">Vælg</a>
                </div>
            </div>
            </div>
          </div>
        </c:if>
        <br>


    </jsp:body>

</t:pagetemplate>