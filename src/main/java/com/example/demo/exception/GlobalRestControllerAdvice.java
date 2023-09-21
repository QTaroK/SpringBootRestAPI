package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

}
