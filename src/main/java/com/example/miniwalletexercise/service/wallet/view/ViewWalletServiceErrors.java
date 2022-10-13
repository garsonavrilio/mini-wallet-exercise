package com.example.miniwalletexercise.service.wallet.view;

import com.example.miniwalletexercise.exception.ServiceException;
import java.util.HashMap;
import java.util.Map;

public class ViewWalletServiceErrors {

  public static ServiceException walletDisabled() {
    Map<String, String> errors = new HashMap<>();
    errors.put("Wallet", "status is disabled");
    return new ServiceException(errors);
  }

}
