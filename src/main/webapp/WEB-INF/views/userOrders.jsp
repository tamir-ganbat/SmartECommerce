<%@ include file="/WEB-INF/views/header.jspf"%>
<form:form modelAttribute="order" class="form-horizontal">
	<div class="container">
		<div class="hdrOfOrders"><h3>ORDERS</h3></div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="hdrOfTable">Id</th>
					<th class="hdrOfTable">Date</th>
					<th class="hdrOfTable">Total</th>
					<th class="hdrOfTable">Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
					<tr>
						<td class="col-md-1 hdrOfTable tdOfTable">${ order.id }</td>
						<td class="col-md-3 hdrOfTable tdOfTable">${order.orderDate}</td>
						<td class="col-md-1 hdrOfTable tdOfTable">$<em>${order.orderTotal}</em></td>
						<td class="col-md-1 hdrOfTable tdOfTable"><a href="<c:url value="/orders/${ order.id }"/>"> 
							<span class="glyphicon glyphicon-eye-open" /></span> Detail</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="tdOfTable"> </td>
					<td class="tdOfTable"> </td>
					<td class="text-right tdOfTable"><h4>
							<strong>Grand Total: </strong>
						</h4></td>
					<td class="text-center tdOfTable">
						<h4><strong>$${grandTotal}</strong></h4>
					</td>
				</tr>
			</tbody>
		</table>
		<a href="<spring:url value="/products" />" class="btn btn-default">
			<span class="glyphicon-hand-left glyphicon"></span> Back to products
		</a>
	</div>
</form:form>
</body>
</html>
