package com.example.miniwalletexercise.service.wallet.deposit;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositResponseDTO;
import java.util.UUID;

public interface DepositWalletService {

  ResponseDTO<DepositResponseDTO> deposit(String token, Long amount, UUID referenceId);

}
