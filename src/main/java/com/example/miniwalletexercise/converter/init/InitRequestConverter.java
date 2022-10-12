package com.example.miniwalletexercise.converter.init;

import static com.example.miniwalletexercise.constant.StatusConstant.DISABLED;
import com.example.miniwalletexercise.dto.init.InitRequestDTO;
import com.example.miniwalletexercise.generator.HashCodeGenerator;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitRequestConverter {

  @Autowired
  private HashCodeGenerator hashCodeGenerator;

  public Wallet toEntity(InitRequestDTO initRequestDTO){
    return Wallet.builder()
        .token(hashCodeGenerator.generateHashCode(initRequestDTO.getCustomerXid().toString()))
        .status(DISABLED)
        .ownedBy(initRequestDTO.getCustomerXid())
        .enabledAt(ZonedDateTime.now())
        .balance(0L)
        .build();
  }

}
