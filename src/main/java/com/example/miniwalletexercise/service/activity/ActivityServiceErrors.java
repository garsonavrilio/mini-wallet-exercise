package com.example.miniwalletexercise.service.activity;

import com.example.miniwalletexercise.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;

public class ActivityServiceErrors {

  public static ServiceException invalidActivityType(){
    Map<String, String> errors = new HashMap<>();
    errors.put("Activity", "Invalid type");
    return new ServiceException(errors);
  }

}
