package com.example.miniwalletexercise.service.wallet.deposit;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletRequestDTO;

public interface DepositWalletService {

  ResponseDTO<DepositResponseDTO> deposit(String token,
      DepositWalletRequestDTO depositWalletRequestDTO);

}
