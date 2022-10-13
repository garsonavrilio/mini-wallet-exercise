package com.example.miniwalletexercise.service.wallet.disable.impl;

import static com.example.miniwalletexercise.constant.StatusConstant.DISABLED;
import static com.example.miniwalletexercise.constant.StatusConstant.ENABLED;

import com.example.miniwalletexercise.constant.ActivityConstant;
import com.example.miniwalletexercise.converter.wallet.disable.DisableWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.disable.DisableWalletService;
import com.example.miniwalletexercise.service.wallet.disable.DisableWalletServiceErrors;
import com.example.miniwalletexercise.service.wallet.enable.EnableWalletServiceErrors;
import java.time.ZonedDateTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisableWalletServiceImpl implements DisableWalletService {

  @Autowired
  private TokenService tokenService;
  @Autowired
  private WalletRepository walletRepository;
  @Autowired
  private ActivityService activityService;
  @Autowired
  private DisableWalletResponseConverter disableWalletResponseConverter;

  @Override
  public ResponseDTO<WalletResponseDTO<DisableWalletResponseDTO>> disableWallet(String token,
      DisableWalletRequestDTO disableWalletRequestDTO) {
    validate(disableWalletRequestDTO);
    Wallet wallet = validate(tokenService.getWalletFrom(token));
    ZonedDateTime now = ZonedDateTime.now();
    walletRepository.disable(wallet.getOwnedBy(), now);
    activityService.storeActivity(wallet, ActivityConstant.DISABLED);
    return disableWalletResponseConverter.toResponse(wallet, now);
  }

  private Wallet validate(Wallet wallet) {
    if (wallet.getStatus().equals(DISABLED)) {
      throw DisableWalletServiceErrors.alreadyDisabled();
    }
    return wallet;
  }
  private void validate(DisableWalletRequestDTO disableWalletRequestDTO){
    if(Objects.isNull(disableWalletRequestDTO.getIsDisabled()) || !disableWalletRequestDTO.getIsDisabled()){
      throw DisableWalletServiceErrors.invalidRequest();
    }
  }
}
