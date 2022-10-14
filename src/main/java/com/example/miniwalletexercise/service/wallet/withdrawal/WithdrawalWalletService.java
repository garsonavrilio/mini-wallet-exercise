package com.example.miniwalletexercise.service.wallet.withdrawal;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import java.util.UUID;

public interface WithdrawalWalletService {

  ResponseDTO<WithdrawalResponseDTO> withdraw(String token, Long amount, UUID referenceId);
}
