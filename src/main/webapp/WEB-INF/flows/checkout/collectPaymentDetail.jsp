<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
<% pageContext.setAttribute("currentMonth", java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Payment</title>
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

.paymentLabel{
    text-align: right!important;
    font-family: "Amazon Ember",Arial,sans-serif;
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
					<h3>Logo</h3>
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
					<legend>1. Customer Details</legend>
				</fieldset>
				<fieldset>
					<legend>2. Shipping Details</legend>
				</fieldset>
				<fieldset>
					<legend class="selectedLegend">3. Payment Details</legend>
					<p>
						<form:errors path="*" cssStyle="color : red;" />
					</p>
					<div class="form-group">
						<div class=" col-lg-7">
							<div class="form-group">
								<div class=" col-lg-5 paymentLabel">
									<label for="cardNumber">Card number</label>
								</div>
								<div class=" col-lg-7">
									<form:input id="cardNumber" path="payment.cardNumber" type="text" class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<div class=" col-lg-5  paymentLabel">
									<label for="nameOnTheCard">Name on card</label>
								</div>
								<div class=" col-lg-7 ">
									<form:input id="nameOnTheCard" path="payment.name" type="text" class="form:input-large" />
								</div>
							</div>
							<div class="form-group">
								<div class=" col-lg-5  paymentLabel">
									<label>Expiration date</label>
								</div>
								<div class=" col-lg-7">
									<span>
										<form:select id="month" path="payment.expirationMonth"  class="a-native-dropdown a-button-span3">
										  <option value="1">01</option>
										  <option value="2">02</option>
										  <option value="3">03</option>
										  <option value="4">04</option>
										  <option value="5">05</option>
										  <option value="6">06</option>
										  <option value="7">07</option>
										  <option value="8">08</option>
										  <option value="9">09</option>
										  <option value="10" selected>10</option>
										  <option value="11">11</option>
										  <option value="12">12</option>
										</form:select>
									</span>
									<span>
										<form:select id="year" path="payment.expirationYear">
											<form:option value="${currentYear}">${currentYear}</form:option>
											<form:option value="${currentYear + 1}">${currentYear + 1}</form:option>
											<form:option value="${currentYear + 2}">${currentYear + 2}</form:option>
											<form:option value="${currentYear + 3}">${currentYear + 3}</form:option>
											<form:option value="${currentYear + 4}">${currentYear + 4}</form:option>
											<form:option value="${currentYear + 5}">${currentYear + 5}</form:option>
											<form:option value="${currentYear + 6}">${currentYear + 6}</form:option>
											<form:option value="${currentYear + 7}">${currentYear + 7}</form:option>
											<form:option value="${currentYear + 8}">${currentYear + 8}</form:option>
										</form:select>
									</span>
								</div>
							</div>
						</div>
						<div class=" col-lg-5">
							<div class="row" style="font-size: small;">
								<p>SmartECommerce accepts all major credit and debit cards:</p>
								<img src="<c:url value="/resources/images/cardIcons.gif"></c:url>" alt="image"/>
							</div>
						</div>
					</div>
					
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button id="back" class="btn btn-default" name="_eventId_backToCollectShippingDetail">back</button>
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Confirm"  name="_eventId_collectPaymentDetailCollected"/>
							<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
						</div>
					</div>
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