<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Admin</title>
  <style>
    <%@include file="../../resources/style.css" %>
  </style>
</head>

<body class="background">
<div>
  <h2>Register a new user</h2>
  <c:url var="registrationAction" value="/admin/registration"/>

  <form:form action="${registrationAction}" commandName="user">
    <table class="background">
      <tr>
        <td>
          <form:label path="username"><spring:message text="username"/></form:label>
        </td>
        <td>
          <form:input path="username"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="password"><spring:message text="password"/></form:label>
        </td>
        <td>
          <form:password path="password"/>
        </td>
      </tr>


      <tr>
        <td>
          <form:label path="role"><spring:message text="role"/></form:label>
        </td>
        <td>
          <form:input path="role"/>
        </td>
      </tr>



      <tr>
        <td><input type="submit" value="<spring:message text="register"/>"/></td>
      </tr>
    </table>
  </form:form>
</div>

<div>

  <c:if test="${!empty userlist}">
    <table class="tableclass">
      <tr>
        <th style="width: 5%">id</th>
        <th style="width: 10%">username</th>
        <th style="width: 20%">password</th>
        <th style="width: 20%">role</th>
        <th style="width: 5%">delete</th>

      </tr>

      <c:forEach items="${userlist}" var="user">
        <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
          <td>${user.password}</td>
          <td>${user.role}</td>

          <td><a href="<c:url value="/deleteuser/${user.id}"/>">delete</a></td>

        </tr>
        </tr>
      </c:forEach>


    </table>
  </c:if>
</div>



</body>
</html>
