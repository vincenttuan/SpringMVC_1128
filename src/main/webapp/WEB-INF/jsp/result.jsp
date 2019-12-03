<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello SpringMVC</title>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>Result</legend>
                <input type="number" value="${x}" disabled><p>
                <input type="number" value="${y}" disabled><p>
                <input type="number" value="${result}" readonly><p>
                <button type="button" class="pure-button pure-button-primary" onclick="history.back()">
                    返回
                </button>
            </fieldset>
        </form>
    </body>
</html>