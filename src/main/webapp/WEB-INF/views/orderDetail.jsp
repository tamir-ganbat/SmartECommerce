<%@ include file="/WEB-INF/views/header.jspf"%>
	<div class="container">
		<div class="hdrOfOrders"><h3>Order Detail</h3></div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="hdrOfTable">ItemImage</th>
					<th class="hdrOfTable">Description</th>
					<th class="hdrOfTable">Quantity</th>
					<th class="hdrOfTable">ItemPrice</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cartItem" items="${cartItems}">
					<tr>
						<td class="col-md-1 hdrOfTable tdOfTable">
							<img src="<c:url value="/resources/images/${ cartItem.product.id }.jpg"></c:url>"
								alt="image" style="height: 50px;" />
						</td>
						<td class="col-md-3 hdrOfTable tdOfTable">
							<c:out value="${cartItem.product.name}" />
						</td>
						<td class="col-md-1 hdrOfTable tdOfTable">
							<c:out value="${cartItem.qty}"  />
						</td>
						<td class="col-md-1 hdrOfTable tdOfTable">
							$<c:out value="${cartItem.product.price}" />
						</td>
						<c:set var="subtot" value="${subtot + (cartItem.product.price * cartItem.qty)}" />
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td class="totalPrice">Total price : </td>
					<td class="totalPrice">$<c:out value="${subtot}" /></td>
				<tr>
			</tbody>
		</table>
		<a href="<c:url value="/userOrders/${userId}"/>" class="btn btn-default">
			<span class="glyphicon-hand-left glyphicon"></span> Back to orders
		</a>
	</div>
</body>
</html>
