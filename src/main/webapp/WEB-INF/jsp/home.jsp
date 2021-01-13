<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form:form method="POST" action="url-handler/shorten-url">
  <div class="w3-content w3-panel w3-card-4 w3-white w3-padding-24" style="width: 400px; height: 200px">
    <table>
      <tr>
      <td>
        Enter URL
      </td>
      <td>
        <input type="text" name="originalUrl"/>
      </td>
      <td>
      <td>
        <input type="submit" value="submit"/>
      </td>
      <td>
      </tr>
    </table>
  </div>
</form:form>
</html>
