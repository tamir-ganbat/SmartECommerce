<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
<style type="text/css">
.banner {
	padding-bottom: 0px;
	padding-top: 0px;
	border-bottom: solid 1px #DDD !important;
	background: linear-gradient(to bottom, #ffffff 86%, #d8d8d8 113%);
	margin-bottom: 21px;
}

.cart {
	border: solid 1px #DDD !important;
	height: 271px;
	border-radius: 10px;
	padding: 5px;
}

.cartHeader {
	font-weight: 700;
	font-size: 17px;
	line-height: 1.255;
	padding-left: 15px;
}

.miLine {
	width: 25%;
	height: 0px;
	maring-bottom: 0px;
	margin-bottom: 0px;
	margin-top: 0px;
	float: right;
}

.total {
	color: #B12704 !important;
	font-size: 17px !important;
	font-weight: 700 !important;
}

.selectedLegend {
	color: #c45500 !important;
	font-weight: 700;
	font-size: 17px;
	line-height: 1.255;
}

legend {
	font-weight: 700;
	font-size: 17px;
	line-height: 1.255;
}

.divider {
	background: linear-gradient(to bottom, rgba(0, 0, 0, .14),
		rgba(0, 0, 0, .03) 3px, transparent);
}
input{
    border-radius: 3px;
    border: 1px solid #a6a6a6;
}
</style>
</head>
<body>
	<section>
		<div class="banner">
			<div class="container">
				<div class="col-md-2">
					<a href="<c:url value="/products"></c:url>"><h3>Smart-E</h3></a>
				</div>
				<div class="col-md-8" style="text-align: center">
					<h3>Checkout</h3>
				</div>
				<div class="col-md-2" style="text-align: right">
					<form:form modelAttribute="order" class="form-horizontal">
						<button id="btnCancel" class="btn btn-default"
						name="_eventId_checkoutCancelled" style="margin-top: 15px;">Cancel</button>	
						</form:form>
				</div>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="col-md-9">
			<form:form modelAttribute="order" class="form-horizontal">
				<fieldset>
					<legend class="selectedLegend">1. Customer Details</legend>

					<p>
						<form:errors path="*" cssStyle="color : red;" />
					</p>

					<div class="form-group">
						<label class="control-label col-lg-2" for="street">Street</label>
						<div class="col-lg-10">
							<form:input id="street" path="user.address.street" type="text" class="form:input-large" placeholder="1000 North 4th etc" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="city">City</label>
						<div class="col-lg-10">
							<form:input id="city" path="user.address.city" type="text" class="form:input-large" placeholder="Fairfield etc"   />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="state">State</label>
						<div class="col-lg-10">
							<form:input id="state" path="user.address.state" type="text" class="form:input-large" placeholder="CA/IA/..."/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="zipcode">Zip Code</label>
						<div class="col-lg-10">
							<form:input id="zipcode" path="user.address.zipcode" type="text" class="form:input-large" placeholder="12345" />
						</div>
					</div>

<!-- 					<div class="form-group"> -->
<!-- 						<label class="control-label col-lg-2" for="country">Country</label> -->
<!-- 						<div class="col-lg-10"> -->
<%-- 							<form:select id="country" path="address.country"> --%>
<%-- 								<form:option value="" label="Select country"></form:option> --%>
<%-- 								<form:option value="US" label="United State"></form:option> --%>
<%-- 								<form:option value="CHINA" label="China"></form:option> --%>
<%-- 								<form:option value="MNG" label="Mongolia"></form:option> --%>
<%-- 							</form:select> --%>
<!-- 						</div> -->
<!-- 					</div> -->

					<input type="hidden" name="_flowExecutionKey"
						value="${flowExecutionKey}" />

					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Add" name="_eventId_customerInfoCollected" />
						</div>
					</div>

				</fieldset>
				<fieldset>
					<legend>2. Shipping detail</legend>
				</fieldset>
				<fieldset>
					<legend>3. Payment</legend>
				</fieldset>
			</form:form>
		</div>
		<div class="col-md-3" style="position: fixed; margin-left: 63%;">
			<div class="cart">
				<h3 class="cartHeader">Order Summary</h3>
				<hr>
				<div class="col-md-9">
					<p>Items:</p>
				</div>
				<div class="col-md-3">${order.cart.total}$</div>
				<div class="col-md-9">
					<p>Shipping &amp; handling:</p>
				</div>
				<div class="col-md-3">${order.shipping}$</div>
				<hr class="miLine">
				<div class="col-md-9">
					<p>Total before tax:</p>
				</div>
				<div class="col-md-3">${order.cart.total + order.shipping}$</div>
				<div class="col-md-9">
					<p>Tax:</p>
				</div>
				<div class="col-md-3">${order.tax}$</div>
				<div class="col-md-9">
					<p class="total">Order total:</p>
				</div>
				<div class="col-md-3">
					<p class="total">${order.orderTotal}$</p>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
