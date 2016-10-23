<%--
  Created by IntelliJ IDEA.
  User: thangnguyen-imac
  Date: 10/22/16
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Upload file with single page</title>
    <link href="<c:url value='/static/bootstrap/css/bootstrap.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet" type="text/css">
</head>
<body>

<div class="jumbotron">
    <div class="container">

        <div class="panel panel-primary">
            <div class="panel-heading">
                    <h3 class="panel-title">SpringMVC Upload Single File</h3>
            </div>

            <div class="panel-body">
                <form:form action="singleUploadFile" modelAttribute="fileBucket" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="container">
                            <div class="form-group col-md-12">
                                <label for="">Upload a file: </label>
                                <form:input type="file" name="file" path="file" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="file" cssClass="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="container">
                            <div class="form-actions input-sm">
                                <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
