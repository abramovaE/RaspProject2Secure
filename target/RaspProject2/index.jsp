<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
    <head>
        <title>index</title>
        <style>
            <%@include file="resources/style.css" %>
        </style>
    </head>

    <body class="backgroundindex">

        <div class="mainmenu">
            <a href="<c:url value="/admin"/>" target="_self"><div class="button">admin</div></a>
            <%--<br>--%>
            <a href="<c:url value="/main"/>" target="_self"> <div class="button">raspberries</div></a>
            <%--<br>--%>
        </div>
    </body>
</html>
