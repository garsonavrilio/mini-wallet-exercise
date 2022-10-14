package com.example.miniwalletexercise.converter.init;

import static com.example.miniwalletexercise.constant.StatusConstant.DISABLED;
import static com.example.miniwalletexercise.util.HashingUtil.hash;

import com.example.miniwalletexercise.dto.init.InitRequestDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class InitRequestConverter {

  public Wallet toEntity(InitRequestDTO initRequestDTO) {
    ZonedDateTime now = ZonedDateTime.now();
    return Wallet.builder()
        .token(hash(initRequestDTO.getCustomerXid()))
        .status(DISABLED)
        .ownedBy(initRequestDTO.getCustomerXid())
        .createdAt(now)
        .updatedAt(now)
        .disabledAt(now)
        .balance(0L)
        .build();
  }

}
