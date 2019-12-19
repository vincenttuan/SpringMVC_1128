<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EC Purchase Order</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <style>
            body {font-family: monospace;} 
        </style>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>EC Purchase Order</legend>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr style="cursor: pointer" >
                            <th>orderNum</th>
                            <th>customerId</th>
                            <th>productId</th>
                            <th>quantity</th>
                            <th>shippingCost</th>
                            <th>salesDate</th>
                            <th>freightCompany</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${purchaseOrders}">
                            <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
                                <td>${p.orderNum}</td>
                                <td>${p.customerId}</td>
                                <td>${p.productId}</td>
                                <td>${p.quantity}</td>
                                <td>${p.shippingCost}</td>
                                <td>${p.salesDate}</td>
                                <td>${p.freightCompany}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </fieldset>
        </form>


    </body>
</html>