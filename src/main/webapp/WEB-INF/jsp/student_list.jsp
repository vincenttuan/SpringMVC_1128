<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
    </head>
    <body style="padding: 15px">
        <h1>Student List</h1>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>name</th>
                    <th>sex</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="s" items="${students}">
                <tr>
                    <td><a href="./get/${s.name}">${s.name}</a></td>
                    <td>${s.sex}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
