<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Edit raspberry</title>
  <style>
    <%@include file="../../resources/style.css" %>
  </style>
</head>
<body class="background">
<h1>Edit raspberry</h1>
<table class="tableclass">
  <tr>
    <th style="width: 3%">id</th>
    <th style="width: 7%">ip</th>
    <th style="width: 20%">adress</th>
    <th style="width: 20%">primechanie</th>
    <th style="width: 5%">isWork</th>
    <th style="width: 10%">upal</th>
    <th style="width: 10%">podnalsa</th>
    <th style="width: 10%">downtime</th>
    <th style="width: 10%">uptime</th>
  </tr>


  <tr class="${raspberry.isWork eq false ? "background-pink" : "background-green"}">
    <td>${raspberry.id}</td>
    <td>${raspberry.ip}</td>
    <td>${raspberry.adress}</td>
    <td>${raspberry.primechanie}</td>
    <td>${raspberry.isWork}</td>
    <td>${raspberry.fallenDate}</td>
    <td>${raspberry.risenDate}</td>
    <td>${raspberry.getTimeDiff(raspberry.downtime)}</td>
    <td>${raspberry.getTimeDiff(raspberry.downtime)}</td>
  </tr>


  <c:url var="saveAction" value="/main/save"/>

  <form:form action="${saveAction}" commandName="raspberry">
    <table>
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" disabled="true"/>
          <form:hidden path="id"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="ip">
            <spring:message text="ip"/>
          </form:label>
        </td>
        <td>
          <form:input path="ip" readonly="true" disabled="true"/>
          <form:hidden path="ip"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="adress">
            <spring:message text="adress"/>
          </form:label>
        </td>
        <td>
          <form:input path="adress"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="primechanie">
            <spring:message text="primechanie"/>
          </form:label>
        </td>
        <td>
          <form:input path="primechanie"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="isWork">
            <spring:message text="isWork"/>
          </form:label>
        </td>
        <td>
          <form:input path="isWork" readonly="true" disabled="true"/>
          <form:hidden path="isWork"/>
        </td>
      </tr>


      <tr>
        <td>
          <form:label path="fallenDate">
            <spring:message text="fallenDate"/>
          </form:label>
        </td>
        <td>
          <form:input path="fallenDate" readonly="true" disabled="true"/>
          <form:hidden path="fallenDate"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="risenDate">
            <spring:message text="risenDate"/>
          </form:label>
        </td>
        <td>
          <form:input path="risenDate" readonly="true" disabled="true"/>
          <form:hidden path="risenDate"/>
        </td>
      </tr>


      <tr>
        <td>
          <form:label path="uptime">
            <spring:message text="uptime"/>
          </form:label>
        </td>
        <td>
          <form:input path="uptime" readonly="true" disabled="true"/>
          <form:hidden path="uptime"/>
        </td>
      </tr>

      <tr>
        <td>
          <form:label path="downtime">
            <spring:message text="downtime"/>
          </form:label>
        </td>
        <td>
          <form:input path="downtime" readonly="true" disabled="true"/>
          <form:hidden path="downtime"/>
        </td>
      </tr>


      <tr>
        <td><input type="submit" value="<spring:message text="Edit Raspberry"/>"/></td>
      </tr>
    </table>
  </form:form>



</table>
</body>
</html>
