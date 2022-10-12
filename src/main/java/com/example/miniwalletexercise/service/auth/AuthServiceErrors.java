package com.example.miniwalletexercise.service.auth;

import com.example.miniwalletexercise.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;

public class AuthServiceErrors {

  public static ServiceException invalidToken(){
    Map<String, String> errors = new HashMap<>();
    errors.put("Token", "Invalid Token");
    return new ServiceException(errors);
  }
}
