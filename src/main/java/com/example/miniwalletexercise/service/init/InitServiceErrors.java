package com.example.miniwalletexercise.service.init;

import com.example.miniwalletexercise.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;

public class InitServiceErrors {

  public static ServiceException alreadyExist(){
    Map<String, String> errors = new HashMap<>();
    errors.put("Customer", "Already Exist");
    return new ServiceException(errors);
  }

}
