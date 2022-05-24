<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Din forespørgsel
    </jsp:attribute>

    <jsp:attribute name="footer">
            Forespørgsel

    </jsp:attribute>

    <jsp:body>

        <table class="table table-striped table-hover">
            <thead>
            <tr>

                <th scope="col">Længde</th>
                <th scope="col">Bredde</th>
                <th scope="col">Tagtype</th>
                <th scope="col">Taghældning</th>
                <th scope="col">Godkendt</th>
                <th scope="col">Skur Længde</th>
                <th scope="col">Skur Bredde</th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>${requestScope.newCarportRequest.length}</td>
                <td>${requestScope.newCarportRequest.width}</td>
                <td>${requestScope.newCarportRequest.roofType}</td>
                <td>${requestScope.newCarportRequest.roofIncline}</td>
                <td>${requestScope.newCarportRequest.approved}</td>
                <td>${requestScope.newCarportRequest.shedWidth}</td>
                <td>${requestScope.newCarportRequest.shedLength}</td>

            </tr>
            <br>

            </tbody>
        </table>

        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Launch demo modal
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ${requestScope.svgdrawing}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>


       <%-- <button id="toggle" onclick="myFunction()">Vis carport tegning</button>
        <div id="carportSVG" style="display: none">
                ${requestScope.svgdrawing}
        </div>
        <br>
        <script>
            const targetDiv = document.getElementById("carportSVG");
            const button = document.getElementById("toggle");
            button.onclick = function () {
                if (targetDiv.style.display !== "none") {
                    targetDiv.style.display = "none";
                } else {
                    targetDiv.style.display = "block";
                }
            };
        </script>
--%>

    </jsp:body>
</t:pagetemplate>
