package com.bos.exception;

/**
 * This is custom exception class when order not found
 * 
 * @author Vaishali
 * @version 1.0
 */

public class OrderNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}