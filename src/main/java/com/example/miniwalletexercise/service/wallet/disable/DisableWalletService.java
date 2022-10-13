package com.example.miniwalletexercise.service.wallet.disable;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletResponseDTO;

public interface DisableWalletService {

  ResponseDTO<WalletResponseDTO<DisableWalletResponseDTO>> disableWallet(String token,
      DisableWalletRequestDTO disableWalletRequestDTO);

}
