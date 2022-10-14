package com.example.miniwalletexercise.converter.wallet.withdrawal;

import static com.example.miniwalletexercise.constant.StatusConstant.SUCCESS;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class WithdrawalWalletResponseConverter {

  public ResponseDTO<WithdrawalResponseDTO> toResponse(Wallet wallet, Long amount, UUID referenceId, ZonedDateTime now) {
    return ResponseDTO.<WithdrawalResponseDTO>builder()
        .status(SUCCESS)
        .data(WithdrawalResponseDTO.builder()
            .withdrawal(constructWithdrawalWalletResponseDTO(wallet, amount, referenceId, now))
            .build())
        .build();
  }

  private WithdrawalWalletResponseDTO constructWithdrawalWalletResponseDTO(Wallet wallet,
      Long amount, UUID referenceId, ZonedDateTime now) {
    WithdrawalWalletResponseDTO withdrawalWalletResponseDTO = new WithdrawalWalletResponseDTO();
    withdrawalWalletResponseDTO.setId(wallet.getUuid());
    withdrawalWalletResponseDTO.setAmount(amount);
    withdrawalWalletResponseDTO.setWithdrawnAt(now);
    withdrawalWalletResponseDTO.setReferenceId(referenceId);
    withdrawalWalletResponseDTO.setWithdrawnBy(wallet.getOwnedBy());
    withdrawalWalletResponseDTO.setStatus(wallet.getStatus());
    return withdrawalWalletResponseDTO;
  }

}
