package com.muka.marry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserModelNotFoundException extends RuntimeException {

  public UserModelNotFoundException(String exception) {
    super(exception);
  }

}