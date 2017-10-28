<%@ include file="/WEB-INF/views/header.jspf"%>
<form:form modelAttribute="signup" action="signup" method="post" class="form-horizontal">
<fieldset>
	<div>
		<form:errors path="*" cssStyle="color : red; " />
	</div>
	<legend><spring:message code="signup.form.title" /></legend>
	<br>
	<p>
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="firstName"><spring:message code="signup.form.firstName" /></label>
		<div class="col-lg-5">
			<form:input id="firstName" path="firstName" type="text" class="form-control" />
			<form:errors path="firstName" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="lastName"><spring:message code="signup.form.lastName" /></label>
		<div class="col-lg-5">
			<form:input id="lastName" path="lastName" type="text" class="form-control" />
			<form:errors path="lastName" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="email"><spring:message code="signup.form.email" /></label>
		<div class="col-lg-5">
			<form:input id="email" path="email" type="text" class="form-control" />
			<form:errors path="email" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="gender"><spring:message code="signup.form.userCredentials.username" /></label>
		<div class="col-lg-5">
			<form:input id="userCredentials.username" path="userCredentials.username" type="text" class="form-control" />${ error }
			<form:errors path="userCredentials.username" cssStyle="color : red;" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="password"><spring:message code="signup.form.userCredentials.password" /></label>
		<div class="col-lg-5">
			<form:input id="userCredentials.password" path="userCredentials.password" type="password" class="form-control" />
			<form:errors path="userCredentials.password" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="street"><spring:message code="signup.form.address.street" /></label>
		<div class="col-lg-5">
			<form:input id="street" path="address.street" type="text" class="form-control" />
			<form:errors path="address.street" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="city"><spring:message code="signup.form.address.city" /></label>
		<div class="col-lg-5">
			<form:input id="city" path="address.city" type="text" class="form-control" />
			<form:errors path="address.city" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="state"><spring:message code="signup.form.address.state" /></label>
		<div class="col-lg-5">
			<form:input id="state" path="address.state" type="text" class="form-control" />
			<form:errors path="address.state" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-lg-2 col-lg-2" for="zipcode"><spring:message code="signup.form.address.zipcode" /></label>
		<div class="col-lg-5">
			<form:input id="zipcode" path="address.zipcode" type="text" class="form-control" />
			<form:errors path="address.zipcode" cssStyle="color : red;" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-lg-offset-2 col-lg-10">
			<input id="submit" type="submit" class="btn btn-primary">
		</div>
	</div>
	</fieldset>
</form:form>

<%@ include file="/WEB-INF/views/footer.jspf"%>
