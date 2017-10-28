<%@ include file="/WEB-INF/views/header.jspf" %>
	<div class="row">
		<div class="col-sm-2">
			<div class="sidebar-nav">
				<div class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".sidebar-navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<span class="visible-xs navbar-brand">Sidebar menu</span>
					</div>
					<div class="navbar-collapse collapse sidebar-navbar-collapse">
						<ul class="nav navbar-nav">
							<c:forEach items="${ category }" var="cat">
								<li><a href="<c:url value="${ url }&category=${ cat }"></c:url>">${ cat }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-10">
			<section class="container">
			<div class="row">
				<c:forEach items="${ search }" var="product">
					<div class="col-md-4" style="margin-top: 30px;">
						<div class="thumbnail">
							<img
								src="<c:url value="/resources/images/${ product.id }.jpg"></c:url>"
								alt="image" style="height: 250px;" />
							<div class="caption">
								<h5>${ product.manufacturer }</h5>
								<h4>${ product.name }</h4>
								<p>${ product.description }</p>
								<p>$${ product.price }</p>
								<p>Available ${ product.qty } units in stock</p>
								<a href="<spring:url value="/product?id=${ product.id }" />"
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon"></span> Details
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>