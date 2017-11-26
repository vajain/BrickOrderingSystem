package com.bos.controller;

/**
 * Controller class handling exceptions
 * 
 * @author Vaishali
 * @version 1.0
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bos.exception.OrderErrorResponse;
import com.bos.exception.OrderNotFoundException;

@ControllerAdvice
public class OrderExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<OrderErrorResponse> handleUserNotFoundException(Exception ex) {
		OrderErrorResponse errorResponse = new OrderErrorResponse();
		errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		errorResponse.setErrorMessage(ex.getMessage());
		return new ResponseEntity<OrderErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<OrderErrorResponse> handleGenericException(Exception ex) {
		OrderErrorResponse errorResponse = new OrderErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage("There is some techncal issue");
		return new ResponseEntity<OrderErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}