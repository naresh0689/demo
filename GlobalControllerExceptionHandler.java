package com.social.common;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handles errors that controllers are not handling.
 * 
 * @author Shris Infotech
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation") // 409
	@ExceptionHandler({DataIntegrityViolationException.class, NullPointerException.class})
	public void conflict() {
		// Nothing to do
	}

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError() {
		return "Database Error";
	}
}
