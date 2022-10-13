package com.example.miniwalletexercise.converter.wallet.enable;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.enable.EnableWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import org.springframework.stereotype.Component;

@Component
public class EnableWalletResponseConverter {

  public ResponseDTO<EnableWalletResponseDTO> toResponse(Wallet wallet) {
    return ResponseDTO.<EnableWalletResponseDTO>builder()
        .status(SUCCESS)
        .data(constructEnableWalletResponseDTO(wallet))
        .build();
  }

  private EnableWalletResponseDTO constructEnableWalletResponseDTO(Wallet wallet) {
    EnableWalletResponseDTO enableWalletResponseDTO = new EnableWalletResponseDTO();
    enableWalletResponseDTO.setId(wallet.getUuid());
    enableWalletResponseDTO.setBalance(wallet.getBalance());
    enableWalletResponseDTO.setStatus(wallet.getStatus());
    enableWalletResponseDTO.setOwnedBy(wallet.getOwnedBy());
    enableWalletResponseDTO.setEnabledAt(wallet.getEnabledAt());
    return enableWalletResponseDTO;
  }

}
