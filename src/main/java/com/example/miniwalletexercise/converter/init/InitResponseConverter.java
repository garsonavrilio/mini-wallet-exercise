package com.example.miniwalletexercise.converter.init;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import org.springframework.stereotype.Component;

@Component
public class InitResponseConverter {

  public ResponseDTO<InitResponseDTO> toResponse(Wallet wallet){
    return ResponseDTO.<InitResponseDTO>builder()
        .data(InitResponseDTO.builder()
            .token(wallet.getToken())
            .build())
        .status(SUCCESS)
        .build();
  }

}
