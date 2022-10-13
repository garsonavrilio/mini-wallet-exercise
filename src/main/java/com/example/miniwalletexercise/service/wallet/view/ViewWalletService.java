package com.example.miniwalletexercise.service.wallet.view;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.view.ViewWalletResponseDTO;

public interface ViewWalletService {

  ResponseDTO<WalletResponseDTO<ViewWalletResponseDTO>> view(String token);

}
