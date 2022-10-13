package com.example.miniwalletexercise.service.wallet.enable;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.enable.EnableWalletResponseDTO;

public interface EnableWalletService {

  ResponseDTO<EnableWalletResponseDTO> enableWallet(String token);

}
