package edu.ntnu.idatt2105.trivium.exception;

import edu.ntnu.idatt2105.trivium.exception.auth.InvalidCredentialsException;
import edu.ntnu.idatt2105.trivium.exception.user.UserAlreadyExistsException;
import edu.ntnu.idatt2105.trivium.exception.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler that handles various exceptions thrown by the application.
 * Customizes the response for different types of exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Handles validation errors for method arguments.
   *
   * @param e The MethodArgumentNotValidException containing validation errors.
   * @param headers The headers for the response.
   * @param status The HTTP status code.
   * @param request The current web request.
   * @return A ResponseEntity containing the error response.
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    String error = e.getMessage();
    if (e instanceof MethodArgumentNotValidException validationException) {
      FieldError fieldError = validationException.getFieldError();
      if (fieldError != null) {
        error = fieldError.getDefaultMessage();
      }
    }
    return ExceptionResponse.toResponseEntity(HttpStatus.BAD_REQUEST, error);
  }

  /**
   * Handles exceptions by returning an {@link HttpStatus#UNAUTHORIZED} response.
   *
   * @param e The exception.
   * @return A ResponseEntity containing the error response.
   */
  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<Object> handleUnauthorized(Exception e) {
    return ExceptionResponse.toResponseEntity(HttpStatus.UNAUTHORIZED, e.getMessage());
  }

  /**
   * Handles exceptions by returning an {@link HttpStatus#CONFLICT} response.
   *
   * @param e The exception.
   * @return A ResponseEntity containing the error response.
   */
  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<Object> handleConflict(Exception e) {
    return ExceptionResponse.toResponseEntity(HttpStatus.CONFLICT, e.getMessage());
  }

  /**
   * Handles exceptions by returning an {@link HttpStatus#NOT_FOUND} response.
   *
   * @param e The exception.
   * @return A ResponseEntity containing the error response.
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleNotFound(Exception e) {
    return ExceptionResponse.toResponseEntity(HttpStatus.NOT_FOUND, e.getMessage());
  }
}