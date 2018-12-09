<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Common.jsp"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
</head>
<table align="center" border="2">
<tr>
<td>Category_Id</td>
<td>Category_Name</td>
<td>Category_Desc</td>
<td>Modulate</td>
</tr>

 <c:forEach items="${listcategory}" var="display">
<tr>
<td>${display.categoryId}</td>
<td>${display.categoryName}</td>
<td>${display.categoryDescrip}</td>

<td>

<a style="background-color: green;"href="<c:url value="/editCategory/${display.categoryId}"/>">Edit</a>
<a style="background-color: red;" href="<c:url value="/deleteCategory/${display.categoryId}"/>">Delete</a>
</td>
</tr>
</c:forEach> 

</table>
</html>