<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form:form method="GET" action="/url-handler/redirect">
  <div class="w3-content w3-panel w3-card-4 w3-white" style="width: 400px; height: 200px">
    <h5>The shortened URL has been generated: </h5><h4 class="w3-text-blue">${shortenedURL}</h4>
    <input type="hidden" name="shortenedUrl" value="${shortenedURL}"/>
    <input type="submit" value="Go to URL"/>
  </div>
</form:form>
