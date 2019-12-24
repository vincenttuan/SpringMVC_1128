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
            <tr>
                <td valign="top" style="padding: 5px">
                    <form class="pure-form">
                        <fieldset>
                            <legend>總金額: ${PU_TOTAL[0].TOTAL}</legend>
                        </fieldset>
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <fieldset>
                        <legend>訂購商品（Top 10）</legend>
                        <table class="pure-table pure-table-bordered">
                            <thead>
                                <tr>
                                    <th>customer_id</th>
                                    <th>customer_name</th>
                                    <th>total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="t" items="${PU_TOP10}">
                                    <tr onmouseover="this.style.background = '#CCCCCC'" onmouseout="this.style.background = 'white'">
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
        </table>
    </body>
</html>
