<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="Common.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body>

	<form action="newCategory" method="post">
		<center>
			CategoryName <input type="text" id="categoryName" name="categoryName" />
			<br> <br>
			CategoryDesc <input type="text" id="categoryDesc" name="categoryDesc" /> 
			<br> <br>
	    <input type="submit" value="Add" />
		</center>
		<br>
		<div class="container">

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Category-Id</th>
						<th>Category-Name</th>
						<th>Category-Description</th>
						<th>DoChanges</tr>
					
    </thead>
    <tbody>



 <c:forEach items="${listcategory}" var="show">
<tr>
<td>${show.categoryId}</td>
<td>${show.categoryName}</td>
<td>${show.categoryDescrip}</td>

<td>

<a class="btn btn-success" href="<c:url value="/updateCategory"/>">Update</a>
<a class="btn btn-danger" href="<c:url value="/deleteCategory/${show.categoryId}"/>">Delete</a>

</td>
</tr>
</c:forEach> 
</tbody>
  </table>
  </div>
	</form>
</body>
</html>