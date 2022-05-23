<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Admin side
    </jsp:attribute>

    <jsp:attribute name="footer">
            Admin side
    </jsp:attribute>

    <jsp:body>

        <div class="row" style="margin: 50px">
            <div class="col">
                <form action="fc/">
                <div class="card" style="width: 18rem;">
                    <input type="hidden" name="command" value="orderoverview">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Se alle ordre</h5>
                        <button type="submit" class="btn btn-primary">Go somewhere</button>
                    </div>
                </div>
                </form>
        </div>

            <div class="col">
                <form action="fc/">
                <div class="card" style="width: 18rem;">
                    <input type="hidden" name="command" value="requestoverview">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Se alle forespørgsler</h5>
                        <button type="submit" class="btn btn-primary">Go somewhere</button>
                    </div>
                </div>
                </form>
        </div>

            <div class="col">
                <form action="fc/">
                <div class="card" style="width: 18rem;">
                    <input type="hidden" name="command" value="materialoverview">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Gå til lager</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <button type="submit" class="btn btn-primary">Go somewhere</button>
                    </div>
                </div>
                </form>
        </div>
        </div>

    </jsp:body>
</t:pagetemplate>
