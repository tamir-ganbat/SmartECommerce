<%@ include file="/WEB-INF/views/header.jspf" %>
	<div class="container">
		<div class="row">
			<form:form modelAttribute="order" class="form-horizontal">
				<input type="hidden" name="_flowExecutionKey"
					value="${flowExecutionKey}" />

				<div
					class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
					<div class="text-center">
						<h1>Receipt</h1>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
								<strong>Shipping Address</strong> <br>
								${order.shippingDetail.street}
								<br>
								${order.shippingDetail.state}  ,${order.shippingDetail.zipcode}
								<br>
<%-- 								${order.shippingDetail.shippingAddress.country} --%>
<!-- 								<br> -->
							</address>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6 text-right">
							<p>
								<em>Shipping DateDate: <fmt:formatDate type="date"
										value="${order.orderDate}" /></em>
							</p>
						</div>
					</div>
					<div class="row">

						<table class="table table-striped">
							<thead>
								<tr>
									<th>Product</th>
									<th>#</th>
									<th class="text-center">Price</th>
									<th class="text-center">Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cartItem" items="${order.cart.products}">
									<tr>
										<td class="col-md-9"><em>${cartItem.name}</em></td>
										<td class="col-md-1" style="text-align: center">
											${cartItem.qty}</td>
										<td class="col-md-1 text-center">${cartItem.price}</td>
										<td class="col-md-1 text-center">${cartItem.qty * cartItem.price}</td>
									</tr>
								</c:forEach>

								<tr>
									<td> </td>
									<td> </td>
									<td class="text-right"><h4>
											<strong>Grand Total: </strong>
										</h4></td>
									<td class="text-center text-danger"><h4>
											<strong>$${order.cart.total}</strong>
										</h4></td>
								</tr>
							</tbody>
						</table>
						<button id="back" class="btn btn-default"
							name="_eventId_backToCollectShippingDetail">back</button>

						<button type="submit" class="btn btn-success"
							name="_eventId_orderConfirmed">
							Confirm   <span class="glyphicon glyphicon-chevron-right"></span>
						</button>
						<button id="btnCancel" class="btn btn-default"
							name="_eventId_cancel">Cancel</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
