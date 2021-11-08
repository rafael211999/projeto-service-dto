package org.serratec.backend.h2banco.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmailException.class)
	
	protected ResponseEntity<Object> handlerEmailException(EmailException ex) {
		EmailException emailException = new EmailException(ex.getMessage());
		return ResponseEntity.unprocessableEntity().body(emailException);
	}

}
