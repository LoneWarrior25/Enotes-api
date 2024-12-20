package com.Enotes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Enotes.util.CommonUtils;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> resourceNotFoundException(Exception e) {

		// return new ResponseEntity<>(e.getMessage(),
		// HttpStatus.INTERNAL_SERVER_ERROR);

		return CommonUtils.createErrorResponseMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointerException(Exception e) {

		// return new ResponseEntity<>(e.getMessage(),
		// HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtils.createErrorResponseMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception e) {

		// return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return CommonUtils.createErrorResponseMessage(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleValidationException(ValidationException e) {

		// return new ResponseEntity<>(e.getErrors(),HttpStatus.BAD_REQUEST);
		return CommonUtils.createErrorResponse(e.getErrors(), HttpStatus.BAD_REQUEST);

	}
}
