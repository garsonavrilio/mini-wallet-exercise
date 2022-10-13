package com.example.miniwalletexercise.converter.activity;

import static com.example.miniwalletexercise.constant.ActivityConstant.ENABLED;

import com.example.miniwalletexercise.model.Activity;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.service.activity.ActivityServiceErrors;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter {

  public Activity toEntity(Wallet wallet, String type) {
    switch (type) {
      case ENABLED:
        return enableWalletActivity(wallet);
      default:
        throw ActivityServiceErrors.invalidActivityType();
    }
  }

  private Activity enableWalletActivity(Wallet wallet) {
    return Activity.builder().time(wallet.getUpdatedAt()).type(ENABLED).walletUuid(wallet.getUuid())
        .balance(wallet.getBalance()).build();
  }

}
