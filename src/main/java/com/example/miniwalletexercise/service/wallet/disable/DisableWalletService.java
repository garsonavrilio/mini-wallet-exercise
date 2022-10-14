package com.example.miniwalletexercise.service.wallet.disable;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletResponseDTO;
import java.util.UUID;

public interface DisableWalletService {

  ResponseDTO<WalletResponseDTO<DisableWalletResponseDTO>> disableWallet(String token,
      Boolean isDisabled);

}
