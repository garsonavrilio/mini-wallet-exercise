package com.example.miniwalletexercise.converter.init;

import static com.example.miniwalletexercise.constant.StatusConstant.DISABLED;
import static com.example.miniwalletexercise.util.HashingUtil.hash;

import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class InitRequestConverter {

  public Wallet toEntity(UUID customerXid) {
    ZonedDateTime now = ZonedDateTime.now();
    return Wallet.builder()
        .token(hash(customerXid))
        .status(DISABLED)
        .ownedBy(customerXid)
        .createdAt(now)
        .updatedAt(now)
        .disabledAt(now)
        .balance(0L)
        .build();
  }

}
