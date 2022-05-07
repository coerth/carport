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

        <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            <link rel="stylesheet" href="./css/kunder.css">

            <div class="header" align="center">
                <h1 style="margin: 50px">Oversigt over aterialer</h1>

            </div>
        </head>

        <body>

        <table>
            <form action="#" method="post">
                <thead>
                <tr>
                    <th>Materiale ID</th>
                    <th>Navn</th>
                    <th>Pris</th>
                    <th>Enhed</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>
                    <th>Type ID</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${applicationScope.materialArrayList}">
                    <tr>
                        <td>${item.materialId}</td>
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
            </form>
        </table>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        </body>


    </jsp:body>

</t:pagetemplate>