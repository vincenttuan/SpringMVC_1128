<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <title>Student</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="padding: 15px">
        ${student}
        <form:form modelAttribute="student" class="pure-form" method="post" action="../mvc/student/add">
            <fieldset>
                <legend>Student</legend>
                <form:input path="name" placeholder="請輸入姓名" /><p>
                <form:radiobutton value="boy" path="sex" />男 
                <form:radiobutton value="girl" path="sex" />女<p>
                <button type="submit" class="pure-button pure-button-primary">修改</button>
            </fieldset>
        </form:form>
    </body>
</html>
