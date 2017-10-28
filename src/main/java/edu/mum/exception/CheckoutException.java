package edu.mum.exception;

public class CheckoutException extends RuntimeException {

	private static final long serialVersionUID = -5192041563033358491L;
	private String order;

	public CheckoutException(String order) {
		this.order = order;
	}

	public String getOrder() {
		return order;
	}
}
