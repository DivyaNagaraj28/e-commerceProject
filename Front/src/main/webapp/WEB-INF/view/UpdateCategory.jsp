<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="Common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Update</title>
</head>
<body>

	<form action="updateCategory" method="post">
		<table align="center">
			<tr>
				<td>CategoryId</td>
				<td><input type="text" id="categoryId" name="categoryId"
					value="${show.categoryId}" readonly="readonly"  /></td>
			</tr>
			
			<tr>
				<td>CategoryName</td>
				<td><input type="text" id="categoryName" name="categoryName"
					value="${show.categoryName}" /></td>
			</tr>
			<tr>
				<td>CategoryDesc</td>
				<td><input type="text" id="categoryDesc" name="categoryDesc"
					value="${show.categoryDesc}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-success" type="submit"
					value="Update" /></td>
			</tr>

		</table>
	</form>
</body>
</html>
