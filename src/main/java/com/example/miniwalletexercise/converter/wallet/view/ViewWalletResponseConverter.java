package com.example.miniwalletexercise.converter.wallet.view;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.view.ViewWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import org.springframework.stereotype.Component;

@Component
public class ViewWalletResponseConverter {

  public ResponseDTO<ViewWalletResponseDTO> toResponse(Wallet wallet) {
    return ResponseDTO.<ViewWalletResponseDTO>builder()
        .data(constructViewWalletResponseDTO(wallet))
        .status(SUCCESS)
        .build();
  }

  private ViewWalletResponseDTO constructViewWalletResponseDTO(Wallet wallet) {
    ViewWalletResponseDTO viewWalletResponseDTO = new ViewWalletResponseDTO();
    viewWalletResponseDTO.setId(wallet.getUuid());
    viewWalletResponseDTO.setStatus(wallet.getStatus());
    viewWalletResponseDTO.setOwnedBy(wallet.getOwnedBy());
    viewWalletResponseDTO.setBalance(wallet.getBalance());
    viewWalletResponseDTO.setEnabledAt(wallet.getEnabledAt());
    return viewWalletResponseDTO;
  }

}
