package com.example.miniwalletexercise.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class ServiceException extends RuntimeException {

  @Getter
  private Map<String, String> errors;

  public ServiceException(Map<String, String> errors) {
    this.errors = errors;
  }
}
