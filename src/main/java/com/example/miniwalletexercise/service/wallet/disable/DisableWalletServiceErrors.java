package com.example.miniwalletexercise.service.wallet.disable;

import com.example.miniwalletexercise.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;

public class DisableWalletServiceErrors {

  public static ServiceException alreadyDisabled() {
    Map<String, String> errors = new HashMap<>();
    errors.put("Wallet", "Already disabled");
    return new ServiceException(errors);
  }

  public static ServiceException invalidRequest() {
    Map<String, String> errors = new HashMap<>();
    errors.put("Request", "is invalid");
    return new ServiceException(errors);
  }
}
