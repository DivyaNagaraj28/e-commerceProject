<%@include file="Common.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 align="center">View Product</h2>
<div class = "row text-center text-lg-left">

<c:forEach items="${listproduct}" var="showP">
<div class="col-lg-3 col-md-4 col-6">
<a href="#" class="d-block mb-4 h-100">
<img class="img-fluid img-thumbnail " src="<c:url value="/resources/images/${showP.productId}.jpg"/>" alt="" width="200" height="400"/>
</a>
</div>
</c:forEach>

</div>