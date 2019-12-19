<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EC Customers</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <style>
            body {font-family: monospace;} 
        </style>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>EC Customers</legend>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr style="cursor: pointer" >
                            <th>customerId</th>
                            <th>discountCode</th>
                            <th>zip</th>
                            <th>name</th>
                            <th>addressLine1</th>
                            <th>addressLine2</th>
                            <th>city</th>
                            <th>state</th>
                            <th>phone</th>
                            <th>fax</th>
                            <th>email</th>
                            <th>creditLimit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${customers}">
                            <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
                                <td>
                                    <a href="./queryPurchaseOrder/${c.customerId}">
                                        ${c.customerId}
                                    </a>
                                </td>
                                <td>${c.discountCode}</td>
                                <td>${c.zip}</td>
                                <td>${c.name}</td>
                                <td>${c.addressLine1}</td>
                                <td>${c.addressLine2}</td>
                                <td>${c.city}</td>
                                <td>${c.state}</td>
                                <td>${c.phone}</td>
                                <td>${c.fax}</td>
                                <td>${c.email}</td>
                                <td>${c.creditLimit}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>


    </body>
</html>