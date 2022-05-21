<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <h2 style="text-align: center; margin-bottom: 50px">VELKOMMEN TIL FOG TRÆLAST OG BYGGECENTER</h2>


        <c:if test="${sessionScope.customer == null}">
            <p>For at begynde at shoppe din nye carport, skal du først logge ind i toppen</p>
            <p>Hvis ikke du allerede har en bruger, skal du registrere dig for at shoppe</p>
        </c:if>

        <c:if test="${sessionScope.customer != null}">
          <div class="col d-flex justify-content-center">
            <div class="row">
          <div class="col-sm-6">
            <div class="card" style="width: 18rem; margin-right: 100px" >
                <img src="${pageContext.request.contextPath}/images/bygselv.jpg" class="card-img-top" alt="Byg selv">
                <div class="card-body">
                    <h5 class="card-title">Byg selv</h5>
                    <p class="card-text">Her kan du selv bygge en carport ud fra dine ønskede mål.</p>
                    <a href="quickbuild.jsp" class="btn btn-primary">Vælg</a>
                </div>
            </div>
          </div>

            <div class="col-sm-6">
            <div class="card" style="width: 18rem; margin-left: 100px" >
                <img src="${pageContext.request.contextPath}/images/standardcarport.jpg" class="card-img-top" alt="Standard carport">
                <div class="card-body">
                    <h5 class="card-title">Standard carport</h5>
                    <p class="card-text">Vælg ud fra vores store udvalg af carporte!</p>
                    <a href="https://www.johannesfog.dk/byggecenter/have--fritid/byg-selv-produkter/" class="btn btn-primary">Vælg</a>
                </div>
            </div>
            </div>
          </div>
          </div>
        </c:if>
        <br>


    </jsp:body>

</t:pagetemplate>