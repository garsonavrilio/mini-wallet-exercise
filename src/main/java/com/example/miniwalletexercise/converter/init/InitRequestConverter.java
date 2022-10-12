package com.example.miniwalletexercise.converter.init;

import static com.example.miniwalletexercise.constant.StatusConstant.DISABLED;
import static com.example.miniwalletexercise.util.Base64Util.encode;

import com.example.miniwalletexercise.dto.init.InitRequestDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class InitRequestConverter {

  public Wallet toEntity(InitRequestDTO initRequestDTO) {
    return Wallet.builder()
        .token(encode(initRequestDTO.getCustomerXid()))
        .status(DISABLED)
        .ownedBy(initRequestDTO.getCustomerXid())
        .enabledAt(ZonedDateTime.now()).balance(0L)
        .build();
  }

}
