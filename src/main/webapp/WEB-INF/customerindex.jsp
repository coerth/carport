<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Kundeoplysninger
    </jsp:attribute>

    <jsp:attribute name="footer">
        Kundeoplysninger
    </jsp:attribute>

    <jsp:body>

        <div class="row" style="margin: 50px">
            <div class="col">
                <form action="fc/">
                    <div class="card" style="width: 18rem;">
                        <input type="hidden" name="command" value="customermodify">
                        <div class="card-body">
                            <h5 class="card-title">Se kundeoplysninger</h5>
                            <button type="submit" class="btn btn-primary">Vælg</button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="col">
                <form action="fc/">
                    <div class="card" style="width: 18rem;">
                        <input type="hidden" name="command" value="customerrequestoverview">
                        <div class="card-body">
                            <h5 class="card-title">Se alle forespørgsler</h5>
                            <button type="submit" class="btn btn-primary">Vælg</button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="col">
                <form action="fc/">
                    <div class="card" style="width: 18rem;">
                        <input type="hidden" name="command" value="customermodify">
                        <div class="card-body">
                            <h5 class="card-title">Se ordrehistorik</h5>
                            <button type="submit" class="btn btn-primary">Vælg</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>