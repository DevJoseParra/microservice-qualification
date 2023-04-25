package com.joseparra.qualificationmicroservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
		return this.getErrorMessage(ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST.value());
	}

	private ErrorMessage getErrorMessage(String messageException, String descriptionRequest, int httpStatusCode) {
		return ErrorMessage.builder().statusCode(httpStatusCode).timestamp(new Date()).message(messageException)
				.description(descriptionRequest).build();
	}
}
