package com.petstore.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PetStoreExceptionController {
	
	@ExceptionHandler(PetStoreException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public PetStoreExceptionResponse handlePetStoreExceptions(final PetStoreException exception,
			final HttpServletRequest request) {
		PetStoreExceptionResponse error = new PetStoreExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;
	}

}
