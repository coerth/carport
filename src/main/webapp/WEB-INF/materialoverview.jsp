<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <br>
        <br>

        <form action="modify">
            <input type="hidden" name="command" value="materialgetbyid"/>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Materiale ID</th>
                    <th scope="col">Navn</th>
                    <th scope="col">Pris</th>
                    <th scope="col">Enhed</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Bredde</th>
                    <th scope="col">Højde</th>
                    <th scope="col">Type ID</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${requestScope.materialArrayList}">
                <tr>
                    <th  scope="row">${item.materialId}</th>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.unit}</td>
                    <td>${item.quantity}</td>
                    <td>${item.length}</td>
                    <td>${item.width}</td>
                    <td>${item.height}</td>
                    <td>${item.typeId}</td>
                    <td><form action="fc/delete"><input type="hidden" name="command" value="deletematerial"/><button name="delete" value="${item.materialId}">Slet</button> </form><button name="modify" value="${item.materialId}">Rediger</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
        <form action="fc/create" method="post">
            <input type="hidden" name="command" value="creatematerial"/>
                <div class="form-group">
                    <label for="name">Navn</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="Navn">
                </div>
                <div class="form-group">
                    <label for="price">Pris</label>
                    <input type="number" class="form-control" name="price" id="price" placeholder="Pris">
                </div>
                <div class="form-group">
                    <label for="unit">Enhed</label>
                    <input type="text" class="form-control" name="unit" id="unit" placeholder="Enhed">
                </div>
                <div class="form-group">
                    <label for="quantity">Antal</label>
                    <input type="text" class="form-control" name="quantity" id="quantity" placeholder="Antal">
                </div>
                <div class="form-group">
                    <label for="length">Længde</label>
                    <input type="number" class="form-control" name="length" id="length" placeholder="Længde">
                </div>
                <div class="form-group">
                    <label for="width">Bredde</label>
                    <input type="number" class="form-control" name="width" id="width" placeholder="Bredde">
                </div>
                <div class="form-group">
                    <label for="height">Højde</label>
                    <input type="number" class="form-control" name="height" id="height" placeholder="Højde">
                </div>
                <div class="form-group">
                    <label for="typeId">Type ID</label>
                    <input type="number" class="form-control" name="typeId" id="typeId" placeholder="Type Id">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>


        </form>

    </jsp:body>

</t:pagetemplate>