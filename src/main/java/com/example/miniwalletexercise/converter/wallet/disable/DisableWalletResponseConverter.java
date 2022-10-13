package com.example.miniwalletexercise.converter.wallet.disable;

import static com.example.miniwalletexercise.constant.StatusConstant.DISABLED;
import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class DisableWalletResponseConverter {

  public ResponseDTO<WalletResponseDTO<DisableWalletResponseDTO>> toResponse(Wallet wallet,
      ZonedDateTime now) {
    return ResponseDTO.<WalletResponseDTO<DisableWalletResponseDTO>>builder()
        .status(SUCCESS)
        .data(WalletResponseDTO.<DisableWalletResponseDTO>builder()
            .wallet(constructDisableWalletResponseDTO(wallet, now))
            .build())
        .build();
  }

  private DisableWalletResponseDTO constructDisableWalletResponseDTO(Wallet wallet,
      ZonedDateTime now) {
    DisableWalletResponseDTO disableWalletResponseDTO = new DisableWalletResponseDTO();
    disableWalletResponseDTO.setId(wallet.getUuid());
    disableWalletResponseDTO.setBalance(wallet.getBalance());
    disableWalletResponseDTO.setOwnedBy(wallet.getOwnedBy());
    disableWalletResponseDTO.setStatus(DISABLED);
    disableWalletResponseDTO.setDisabledAt(now);
    return disableWalletResponseDTO;
  }

}
