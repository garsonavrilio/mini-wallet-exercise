package com.example.miniwalletexercise.service.wallet.enable.impl;

import static com.example.miniwalletexercise.constant.StatusConstant.ENABLED;

import com.example.miniwalletexercise.constant.ActivityConstant;
import com.example.miniwalletexercise.converter.wallet.enable.EnableWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.enable.EnableWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.enable.EnableWalletService;
import com.example.miniwalletexercise.service.wallet.enable.EnableWalletServiceErrors;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnableWalletServiceImpl implements EnableWalletService {

  @Autowired
  private TokenService tokenService;
  @Autowired
  private WalletRepository walletRepository;
  @Autowired
  private EnableWalletResponseConverter enableWalletResponseConverter;
  @Autowired
  private ActivityService activityService;

  @Override
  public ResponseDTO<WalletResponseDTO<EnableWalletResponseDTO>> enableWallet(String token) {
    Wallet wallet = walletRepository.save(
        updateWallet(validate(tokenService.getWalletFrom(token))));
    activityService.storeActivity(wallet, ActivityConstant.ENABLED);
    return enableWalletResponseConverter.toResponse(wallet);
  }

  private Wallet updateWallet(Wallet wallet) {
    ZonedDateTime now = ZonedDateTime.now();
    wallet.setUpdatedAt(now);
    wallet.setEnabledAt(now);
    wallet.setStatus(ENABLED);
    return wallet;
  }

  private Wallet validate(Wallet wallet) {
    if (wallet.getStatus().equals(ENABLED)) {
      throw EnableWalletServiceErrors.alreadyEnabled();
    }
    return wallet;
  }
}
