<%@ include file="/WEB-INF/views/header.jspf"%>

<form:form modelAttribute="order" class="form-horizontal">
	<div class="container">
		<div class="hdrOfOrders"><h3>USERS</h3></div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="hdrOfTable">First Name</th>
					<th class="hdrOfTable">Last Name</th>
					<th class="hdrOfTable">E-Mail</th>
					<th class="hdrOfTable">Street</th>
					<th class="hdrOfTable">City</th>
					<th class="hdrOfTable">State</th>
					<th class="hdrOfTable">Zip Code</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td class="col-md-1 hdrOfTable tdOfTable">${user.firstName }</td>
						<td class="col-md-3 hdrOfTable tdOfTable">${user.lastName }</td>
						<td class="col-md-1 hdrOfTable tdOfTable"><em>${user.email }</em></td>
						<td class="col-md-1 hdrOfTable tdOfTable">${user.address.street }</td>
						<td class="col-md-1 hdrOfTable tdOfTable">${user.address.city }</td>
						<td class="col-md-1 hdrOfTable tdOfTable">${user.address.state }</td>
						<td class="col-md-1 hdrOfTable tdOfTable">${user.address.zipcode }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<spring:url value="/products" />" class="btn btn-default">
			<span class="glyphicon-hand-left glyphicon"></span> Back to products
		</a>
	</div>
</form:form>
<%@ include file="/WEB-INF/views/footer.jspf"%>
