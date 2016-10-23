<%--
  Created by IntelliJ IDEA.
  User: thangnguyen-imac
  Date: 10/22/16
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home page</title>
    <link href="<c:url value='/static/bootstrap/css/bootstrap.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet" type="text/css">
</head>
<body>

<div class="jumbotron">
    <div class="container">
        <h1>Welcome to fileuploader Example</h1>
        <a href="<c:url value='/uploadSinglePage'/>">Single File</a>
        OR
        <a href="<c:url value='/uploadMultiPage'/>">Single File</a>
    </div>
</div>
</body>
</html>
