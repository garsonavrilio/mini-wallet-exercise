package com.example.miniwalletexercise.service.wallet.enable;

import com.example.miniwalletexercise.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;

public class EnableWalletServiceErrors {

  public static ServiceException alreadyEnabled() {
    Map<String, String> errors = new HashMap<>();
    errors.put("Wallet", "Already enabled");
    return new ServiceException(errors);
  }

}
