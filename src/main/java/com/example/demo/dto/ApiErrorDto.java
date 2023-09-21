package com.example.demo.dto;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorDto {
  private HttpStatus status;
  private String errorCode;
  private List<String> errors;

  public ApiErrorDto(HttpStatus status, String errorCode, List<String> errors) {
    this.status = status;
    this.errorCode = errorCode;
    this.errors = errors;
  }

  public ApiErrorDto(HttpStatus status, String errorCode, String error) {
    this.status = status;
    this.errorCode = errorCode;
    errors = Arrays.asList(error);
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

}
