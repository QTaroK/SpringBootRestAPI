package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.demo.dto.ApiErrorDto;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e, WebRequest request) {
    List<String> errors = new ArrayList<String>();
    errors.add(e.getMessage());
    ApiErrorDto apiErrorDto = new ApiErrorDto(HttpStatus.BAD_REQUEST, e.getErrorCode(), errors);

    return handleExceptionInternal(e, apiErrorDto, new HttpHeaders(), apiErrorDto.getStatus(), request);

  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {

    List<String> errors = new ArrayList<String>();
    for (FieldError error : e.getBindingResult().getFieldErrors()) {
      errors.add(error.getField() + ": " + error.getDefaultMessage());
      logger.info(error.getField() + ": " + error.getDefaultMessage());
    }
    for (ObjectError error : e.getBindingResult().getGlobalErrors()) {
      errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
      logger.info(error.getObjectName() + ": " + error.getDefaultMessage());
    }
    String errorCode = String.valueOf(HttpStatus.BAD_REQUEST.value());
    ApiErrorDto apiError = new ApiErrorDto(HttpStatus.BAD_REQUEST, errorCode, errors);
    return handleExceptionInternal(e, apiError, headers, apiError.getStatus(), request);
  }

}
