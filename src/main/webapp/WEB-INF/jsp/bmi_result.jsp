<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI Result</title>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>BMI Result</legend>
                <input type="number" value="${bmi.h}" disabled><p>
                <input type="number" value="${bmi.w}" disabled><p>
                <input type="number" value="${bmi.bmi}" readonly><p>
                <button type="button" class="pure-button pure-button-primary" onclick="history.back()">
                    返回
                </button>
            </fieldset>
        </form>
    </body>
</html>