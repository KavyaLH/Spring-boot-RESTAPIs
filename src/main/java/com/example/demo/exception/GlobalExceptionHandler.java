package com.example.demo.exception;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception, WebRequest request) {
		ExceptionDetails errorDetails = new ExceptionDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointerException(NullPointerException exception, WebRequest request) {
		ExceptionDetails errorDetails = new ExceptionDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}

	/*
	 * @ExceptionHandler(HttpMessageNotReadableException.class) public
	 * ResponseEntity<?>
	 * handleHttpMessageNotReadableException(HttpMessageNotReadableException
	 * exception) { return new
	 * ResponseEntity("Please check Json Object in the body section",
	 * HttpStatus.BAD_REQUEST); }
	 */

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
		ExceptionDetails errorDetails = new ExceptionDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest request) {
		return new ResponseEntity("Entity not found in database. Please try with another value",
				HttpStatus.BAD_REQUEST);
	}

}