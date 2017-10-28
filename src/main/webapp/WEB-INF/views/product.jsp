<%@ include file="/WEB-INF/views/header.jspf"%>
<section class="container">
	<div class="row">
		<div class="col-md-5">
			<img
				src="<c:url value="/resources/images/${product.id}.jpg"></c:url>"
				alt="image" class="img-thumbnail" />
		</div>
		<div class="col-md mx-auto">
			<h5>${ product.manufacturer }</h5>
			<h3>${ product.name }</h3>
			<p>${ product.description }</p>
			<p>
				<strong>Category</strong>: ${ product.category }
			</p>
			<p>
				<strong>Available units in stock</strong>: ${ product.qty }
			</p>
			<h4>$${ product.price }</h4>
			<p>
				<input id="star-rating" value="${ product.rate/product.rateNumber }"
					class="rating" readonly="true" data-size="xs" />
			</p>
			<p>
				<a href="<spring:url value="/products"/>" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> back
				</a> 
				<security:authorize access="${ userRole eq 'ROLE_USER'}">
					<a href="#"
						class="btn btn-primary" onClick=cartClick(1,'${first}',${product.id})> <span
						class="glyphicon-info-sign glyphicon"></span> Add into cart
					</a>
					<a href="<spring:url value="/review/add?id=${ product.id }" />"
						class="btn btn-default"> <span class="glyphicon"></span> Review
					</a>
				</security:authorize>
			</p>
		</div>
	</div>
	<hr>
	<div class="grid">
		<c:forEach items="${ reviews }" var="review">
			<div class="row">
				<div class="col-sm-1">
					<div class="thumbnail">
						<img class="img-responsive user-photo"
							src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
					</div>
				</div>
				<div class="col-sm-10">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>myusername</strong> <span class="text-muted">reviewed
								<fmt:formatDate value="${ review.modifiedDate }" type="date" />
							</span> <input id="star-rating" value="${ review.rate }" class="rating"
								readonly="true" data-size="xs" />
						</div>
						<div class="panel-body">${ review.description }</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-star-rating/4.0.2/js/star-rating.min.js"></script>
</body>
</html>