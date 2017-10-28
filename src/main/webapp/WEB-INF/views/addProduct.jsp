<%@ include file="/WEB-INF/views/header.jspf"%>
	<section class="container">
		<form:form method="POST" modelAttribute="newProduct"
			enctype="multipart/form-data" class="form-horizontal">
			<fieldset>
				<legend>Add new product</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
							code="addProduct.form.name.label" /></label>
					<div class="col-lg-5">
						<form:input id="name" path="name" type="text" class="form-control" />
						<form:errors path="name" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="manufacturer"><spring:message
							code="addProduct.form.manufacturer.label" /></label>
					<div class="col-lg-5">
						<form:input id="manufacturer" path="manufacturer" type="text"
							class="form-control" />
						<form:errors path="manufacturer" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description"><spring:message
							code="addProduct.form.description.label" /></label>
					<div class="col-lg-5">
						<form:input id="description" path="description" type="text"
							class="form-control" />
						<form:errors path="description" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="price"><spring:message
							code="addProduct.form.price.label" /></label>
					<div class="col-lg-5">
						<form:input id="price" path="price" type="text"
							class="form-control" />
						<form:errors path="price" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="category"><spring:message
							code="addProduct.form.category.label" /></label>
					<div class="col-lg-5">
						<form:input id="category" path="category" type="text"
							class="form-control" />
						<form:errors path="category" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="qty"><spring:message
							code="addProduct.form.qty.label" /></label>
					<div class="col-lg-5">
						<form:input id="qty" path="qty" type="text" class="form-control" />
						<form:errors path="qty" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="image"> <spring:message
							code="addProduct.form.image.label" />
					</label>
					<div class="col-lg-5">
						<form:input id="image" path="image" type="file"
							class="form-control" />
						<form:errors path="image" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add Products" /> <a
							href="<spring:url value="/products"/>" id="cancel" name="cancel"
							class="btn btn-default">Cancel</a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
