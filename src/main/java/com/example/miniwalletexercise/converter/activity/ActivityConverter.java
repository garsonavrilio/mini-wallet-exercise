package com.example.miniwalletexercise.converter.activity;

import com.example.miniwalletexercise.model.Activity;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter {

  public Activity toEntity(Wallet wallet, String type) {
    return Activity.builder()
        .time(wallet.getUpdatedAt())
        .type(type)
        .walletUuid(wallet.getOwnedBy())
        .build();
  }

  public Activity toEntity(Wallet wallet, Long amount, UUID referenceId, ZonedDateTime now,
      String type) {
    return Activity.builder()
        .time(now)
        .amount(amount)
        .walletUuid(wallet.getUuid())
        .type(type)
        .referenceId(referenceId)
        .build();
  }

}
