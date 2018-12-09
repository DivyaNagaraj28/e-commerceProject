
<%@include file="Common.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<form:form action="newproduct" modelAttribute="productmodel"
	method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName" /></td>
		</tr>

		<tr>
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>

		<tr>
			<td>Stock</td>
			<td><form:input path="stock" /></td>
		</tr>

		<tr>
			<td>Category</td>
			<td><form:select path="categoryId">
					<form:option value="0" label="---Select List---" />
					<form:options items="${listcate}" />
				</form:select></td>
		</tr>

		<tr>
			<td>Supplier</td>
			<td><form:select path="supplierId">
					<form:option value="0" label="---Select List---" />
					<form:options items="${listsupp}" />
				</form:select></td>
		</tr>


		<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="productImage"/></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc" /></td>
		</tr>


		<tr>
			<td></td>
			<td colspan="2"><input type="submit" value="Add" /></td>
		</tr>
	</table>

</form:form>
<div class="container">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Stock</th>
				<th>DoChanges</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listproduct}" var="showP">
				<tr>
					<td>${showP.productId}</td>
					<td>${showP.productName}</td>
					<td>${showP.categoryId}</td>
					<td>${showP.price}</td>
					<td>${showP.supplierId}</td>

					<td><a class="btn btn-success"
						href="<c:url value="/updateProduct"/>">Update</a> <a
						class="btn btn-danger"
						href="<c:url value="/deleteProduct/${showP.productId}"/>">Delete</a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</html>