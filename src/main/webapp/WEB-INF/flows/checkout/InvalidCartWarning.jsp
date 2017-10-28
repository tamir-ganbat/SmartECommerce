<%@ include file="/WEB-INF/views/header.jspf" %>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger"> Invalid Cart</h1>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> products
				</a>
			</p>
		</div>
		
	</section>
</body>
</html>
