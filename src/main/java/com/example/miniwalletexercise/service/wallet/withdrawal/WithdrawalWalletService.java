package com.example.miniwalletexercise.service.wallet.withdrawal;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletRequestDTO;

public interface WithdrawalWalletService {

  ResponseDTO<WithdrawalResponseDTO> withdraw(String token,
      WithdrawalWalletRequestDTO withdrawalWalletRequestDTO);
}
