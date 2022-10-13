package com.example.miniwalletexercise.converter.wallet.withdrawal;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class WithdrawalWalletResponseConverter {

  public ResponseDTO<WithdrawalResponseDTO> toResponse(Wallet wallet,
      WithdrawalWalletRequestDTO withdrawalWalletRequestDTO, ZonedDateTime now) {
    return ResponseDTO.<WithdrawalResponseDTO>builder()
        .status(SUCCESS)
        .data(WithdrawalResponseDTO.builder()
            .withdrawal(constructWithdrawalWalletResponseDTO(wallet, withdrawalWalletRequestDTO, now))
            .build())
        .build();
  }

  private WithdrawalWalletResponseDTO constructWithdrawalWalletResponseDTO(Wallet wallet,
      WithdrawalWalletRequestDTO withdrawalWalletRequestDTO, ZonedDateTime now) {
    WithdrawalWalletResponseDTO withdrawalWalletResponseDTO = new WithdrawalWalletResponseDTO();
    withdrawalWalletResponseDTO.setId(wallet.getUuid());
    withdrawalWalletResponseDTO.setAmount(withdrawalWalletRequestDTO.getAmount());
    withdrawalWalletResponseDTO.setWithdrawnAt(now);
    withdrawalWalletResponseDTO.setReferenceId(withdrawalWalletRequestDTO.getReferenceId());
    withdrawalWalletResponseDTO.setWithdrawnBy(wallet.getOwnedBy());
    withdrawalWalletResponseDTO.setStatus(wallet.getStatus());
    return withdrawalWalletResponseDTO;
  }

}
