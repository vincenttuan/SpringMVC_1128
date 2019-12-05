<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weather</title>
    </head>
    <body style="padding: 15px">
        <form class="pure-form">
            <fieldset>
                <legend>Weather</legend>
                氣溫 : ${weather.temp} <p />
                壓力 : ${weather.pressure} <p />
                濕度 : ${weather.humidity} <p />
                最低 : ${weather.temp_min} <p />
                最高 : ${weather.temp_max} <p />
                <img src="http://openweathermap.org/img/wn/${weather.icon}@2x.png"> <p />
                <button type="button" class="pure-button pure-button-primary" onclick="history.back()">
                    返回
                </button>
            </fieldset>
        </form>
    </body>
</html>