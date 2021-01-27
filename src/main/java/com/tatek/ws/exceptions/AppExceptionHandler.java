package com.tatek.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tatek.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {	
	
	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> handlerNullPointerException(Exception ex, WebRequest request) {
		
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();
		
		ErrorMessage errormessage = new ErrorMessage(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errormessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handlerAnyException(Exception ex, WebRequest request) {
		 
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();
		
		ErrorMessage errormessage = new ErrorMessage(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errormessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
