<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Derby PU</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
    </head>
    <body style="padding: 10px">
        <table>
            <td valign="top" style="padding: 5px">
                <table>
                    <tr>
                        <td valign="top">
                            <fieldset>
                                <legend>訂購商品（Top 10）</legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th>no</th>
                                            <th>customer_id</th>
                                            <th>customer_name</th>
                                            <th>total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="t" varStatus="n" items="${PU_TOP10}">
                                            <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
                                                <td>${n.count}</td>
                                                <td align="center">${t.customer_id}</td>
                                                <td>${t.customer_name}</td>
                                                <td align="right">${t.total}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </fieldset>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" style="padding: 5px">
                            <form class="pure-form">
                                <fieldset>
                                    <legend>總金額: 
                                        <fmt:formatNumber type="currency" 
                                                          value="${PU_TOTAL[0].TOTAL}" />
                                    </legend>
                                </fieldset>
                            </form>
                        </td>
                    </tr>
                </table>
            </td>
            <td valign="top" style="padding: 5px">
                <table>
                    <tr>
                        <td valign="top">
                            <fieldset>
                                <legend>訂購商品明細</legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th>ORDER_NUM</th>
                                            <th>CUSTOMER_ID</th>
                                            <th>CUSTOMER_NAME</th>
                                            <th>PRODUCT_ID</th>
                                            <th>PRODUCT_NAME</th>
                                            <th>PRODUCT_CODE_NAME</th>
                                            <th>QUANTITY</th>
                                            <th>PURCHASE_COST</th>
                                            <th>RATE</th>
                                            <th>SUBTOTAL</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="p" items="${PU_VIEW}">
                                            <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
                                                <td align="center">${p.ORDER_NUM}</td>
                                                <td align="center">${p.CUSTOMER_ID}</td>
                                                <td>${p.CUSTOMER_NAME}</td>
                                                <td align="center">${p.PRODUCT_ID}</td>
                                                <td>${p.PRODUCT_NAME}</td>
                                                <td>${p.PRODUCT_CODE_NAME}</td>
                                                <td align="right">${p.QUANTITY}</td>
                                                <td align="right">${p.PURCHASE_COST}</td>
                                                <td align="right">${p.RATE}</td>
                                                <td align="right">${p.SUBTOTAL}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </fieldset>
                        </td>
                    </tr>
                </table>
            </td>
            
        </table>

    </body>
</html>
