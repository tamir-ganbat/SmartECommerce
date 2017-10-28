<%@ include file="/WEB-INF/views/header.jspf"%>
<section class="container">
	<div class="row">
		<c:forEach items="${ products }" var="product">
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
						<security:authorize access="${ userRole eq 'ROLE_USER'}">
							<a href="#"
								class="btn btn-primary" onClick=cartClick(1,'${first}',${product.id})> <span
								class="glyphicon-info-sign glyphicon"></span> Add into cart
							</a>
						</security:authorize>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<c:url var="firstUrl" value="/products" />
	<c:url var="lastUrl" value="/products/pages/${page.totalPages}" />
	<c:url var="prevUrl" value="/products/pages/${currentIndex - 1}" />
	<c:url var="nextUrl" value="/products/pages/${currentIndex + 1}" />
	<nav aria-label="Page navigation" class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${currentIndex < 2}">
					<li class="page-item disabled"><a class="page-link" href="#">First</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="${firstUrl}">First</a></li>
					<li class="page-item"><a class="page-link" href="${prevUrl}">Previous</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				<c:url var="pageUrl" value="/products/pages/${i}" />
				<c:choose>
					<c:when test="${i == currentIndex}">
						<li class="page-item active"><a class="page-link"
							href="${pageUrl}"><c:out value="${i}" /></a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="${pageUrl}"><c:out
									value="${i}" /></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${currentIndex == page.totalPages}">
					<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Last</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="${nextUrl}">Next</a></li>
					<li class="page-item"><a class="page-link" href="${lastUrl}">Last</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</section>
</body>
</html>