<%@ include file="/WEB-INF/views/header.jspf" %>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger"> Thank you</h1>
				<p>Thanks for the order. Your order will be delivered to you on 
				<fmt:formatDate type="date"	value="${order.orderDate}" />!</p>
				<p>Your Order Number is ${order.id}</p>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<p>
				<a href="<c:url value="/confirm"/>" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> products
				</a>
			</p>
		</div>
		
	</section>
</body>
</html>
