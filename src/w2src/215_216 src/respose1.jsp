<!-- 
file: web/response1.jsp
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <style>
        .center1{
            margin: 0 auto;
            width: 30%;
        }
    </style>
<head>
    <link rel="stylesheet" href="./css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP response products</title>
</head>
<body>
    <h1>The best products of the type # ${param.product_html} # are:</h1>
    <!--                                     (2)product_html
        //
    -->
    <ul class="center1">
	<c:forEach var="item" items="${productsList_servlet}">
        <!--                    (3)productsList_servlet
        //
        -->
            <li>${item}</li>
	</c:forEach>
    </ul>
</body>
</html>