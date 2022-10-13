package com.example.miniwalletexercise.service.wallet.view.impl;

import static com.example.miniwalletexercise.constant.StatusConstant.ENABLED;

import com.example.miniwalletexercise.converter.wallet.view.ViewWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.view.ViewWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.view.ViewWalletService;
import com.example.miniwalletexercise.service.wallet.view.ViewWalletServiceErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewWalletServiceImpl implements ViewWalletService {

  @Autowired
  private TokenService tokenService;
  @Autowired
  private ViewWalletResponseConverter viewWalletResponseConverter;

  @Override
  public ResponseDTO<WalletResponseDTO<ViewWalletResponseDTO>> view(String token) {
    return viewWalletResponseConverter.toResponse(validate(tokenService.getWalletFrom(token)));
  }

  private Wallet validate(Wallet wallet) {
    if (wallet.getStatus().equals(ENABLED)) {
      return wallet;
    }
    throw ViewWalletServiceErrors.walletDisabled();
  }
}
