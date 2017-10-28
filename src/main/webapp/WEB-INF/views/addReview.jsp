<%@ include file="/WEB-INF/views/header.jspf"%>
<div class="container">
	<form:form method="POST" modelAttribute="newReview"
		class="form-horizontal">
		<fieldset>
			<legend>Add new review</legend>
			<form:input path="rate" id="star-rating" value="4" class="rating"
				data-size="xs" />
			<form:errors path="rate" cssClass="text-danger" />
			<div class="form-group">
				<label for="description">Review:</label>
				<form:textarea class="form-control" rows="5" cols="80"
					path="description" />
				<form:errors path="description" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add Review" /> <a href="<spring:url value="/products"/>"
						id="cancel" name="cancel" class="btn btn-default">Cancel</a>
				</div>
			</div>
		</fieldset>
	</form:form>
</div>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-star-rating/4.0.2/js/star-rating.min.js"></script>
</body>
</html>