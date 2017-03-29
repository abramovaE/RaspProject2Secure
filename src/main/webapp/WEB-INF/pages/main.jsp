<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Raspberries</title>
    <style>
      <%@include file="../../resources/style.css" %>
    </style>

    <script type="text/javascript">
      function showTime()
      {
        var dat = new Date();
        var H = '' + dat.getHours();
        H = H.length<2 ? '0' + H:H;
        var M = '' + dat.getMinutes();
        M = M.length<2 ? '0' + M:M;
        var S = '' + dat.getSeconds();
        S =S.length<2 ? '0' + S:S;
        var clock = H + ':' + M + ':' + S;
        document
                .getElementById('time_div')
                .innerHTML=clock;
        setTimeout(showTime,1000);  // перерисовать 1 раз в сек.
      }
    </script>

    <%--<link rel="stylesheet" href="../css/style.css">--%>
  </head>

  <body class="background">
    <h1>Raspberries List</h1>
    <div class="information">
      <div>${date}</div>
      <div id="time_div"></div><script type="text/javascript">  showTime();</script>
      <div>Working raspberries: ${workingRaspberries}</div>
      <div>Not working raspberries: ${notWorkingraspberries}</div>
      <br>
      <br>
    </div>


      <c:if test="${!empty raspberries}">
        <table class="tableclass">
          <tr>
            <th style="width: 3%">id</th>
            <th style="width: 7%">ip</th>
            <th style="width: 20%">adress</th>
            <th style="width: 20%">primechanie</th>
            <th style="width: 5%">isWork</th>
            <th style="width: 5%">edit</th>
            <th style="width: 10%">upal</th>
            <th style="width: 10%">podnalsa</th>
            <th style="width: 10%">downtime</th>
            <th style="width: 10%">uptime</th>
          </tr>

          <c:forEach items="${raspberries}" var="raspberry">
              <tr class="${raspberry.isWork eq false ? "background-pink" : "background-green"}">
                <td>${raspberry.id}</td>
                <td>${raspberry.ip}</td>
                <td>${raspberry.adress}</td>
                <td>${raspberry.primechanie}</td>
                <td>${raspberry.isWork}</td>
                <td><a href="<c:url value="/editraspberry/${raspberry.id}"/>">edit</a></td>
                <td>${raspberry.fallenDate}</td>
                <td>${raspberry.risenDate}</td>
                <td>${raspberry.getTimeDiff(raspberry.downtime)}</td>
                <td>${raspberry.getTimeDiff(raspberry.uptime)}</td>
              </tr>
            </tr>
          </c:forEach>
        </table>
      </c:if>
  </body>

</html>


