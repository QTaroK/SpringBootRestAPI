package com.example.demo.exception;

public class UserNotFoundException extends Exception {

  private final String errorCode;

  public UserNotFoundException(String message) {
    super(message);
    this.errorCode = "404";
  }

  public String getErrorCode() {
    return errorCode;
  }

}
