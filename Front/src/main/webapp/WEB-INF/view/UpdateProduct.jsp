
<%@include file="Common.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<form:form action="newproduct" modelAttribute="productmodelupdate" method="post" enctype="multipart/form-data">
<table >
   
    
    <tr>
    <td>Price </td>
    <td><form:input path="price"/></td>
    </tr>
    
    <tr>
    <td>Stock</td>
    <td><form:input path="stock"/></td>
    </tr>
    
        
    <tr>
    <td>Supplier</td>
    <td><form:select path="supplierId">
    <form:option value="0" label="---Select List---"/>
    <form:options items="${listsupp}"/>
    </form:select></td>
    </tr>
    
    
    <tr>
    <td colspan="2"><input type="submit" value="Update"/></td>
    </tr>
</table>

</form:form>

</html>