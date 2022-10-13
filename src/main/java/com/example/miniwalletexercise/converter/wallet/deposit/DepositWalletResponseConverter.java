package com.example.miniwalletexercise.converter.wallet.deposit;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class DepositWalletResponseConverter {

  public ResponseDTO<DepositResponseDTO> toResponse(Wallet wallet,
      DepositWalletRequestDTO depositWalletRequestDTO, ZonedDateTime now) {
    return ResponseDTO.<DepositResponseDTO>builder()
        .status(SUCCESS)
        .data(DepositResponseDTO.builder()
                .deposit(constructDepositWalletResponseDTO(wallet, depositWalletRequestDTO, now))
            .build())
        .build();
  }

  private DepositWalletResponseDTO constructDepositWalletResponseDTO(Wallet wallet,
      DepositWalletRequestDTO depositWalletRequestDTO, ZonedDateTime now) {
    DepositWalletResponseDTO depositWalletResponseDTO = new DepositWalletResponseDTO();
    depositWalletResponseDTO.setId(wallet.getUuid());
    depositWalletResponseDTO.setDepositedBy(wallet.getOwnedBy());
    depositWalletResponseDTO.setAmount(depositWalletRequestDTO.getAmount());
    depositWalletResponseDTO.setStatus(wallet.getStatus());
    depositWalletResponseDTO.setDepositedAt(now);
    depositWalletResponseDTO.setReferenceId(depositWalletRequestDTO.getReferenceId());
    return depositWalletResponseDTO;
  }

}
