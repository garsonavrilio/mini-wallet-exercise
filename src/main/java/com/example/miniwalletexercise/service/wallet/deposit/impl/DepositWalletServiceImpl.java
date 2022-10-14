package com.example.miniwalletexercise.service.wallet.deposit.impl;

import static com.example.miniwalletexercise.constant.ActivityConstant.DEPOSIT;
import static com.example.miniwalletexercise.util.WalletValidationUtil.isValid;

import com.example.miniwalletexercise.converter.wallet.deposit.DepositWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.deposit.DepositWalletService;
import com.example.miniwalletexercise.util.WalletValidationUtil;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositWalletServiceImpl implements DepositWalletService {

  @Autowired
  private TokenService tokenService;
  @Autowired
  private WalletRepository walletRepository;
  @Autowired
  private ActivityService activityService;
  @Autowired
  private WalletValidationUtil walletValidationUtil;
  @Autowired
  private DepositWalletResponseConverter depositWalletResponseConverter;

  @Transactional
  @Override
  public ResponseDTO<DepositResponseDTO> deposit(String token, Long amount, UUID referenceId) {
    ZonedDateTime now = ZonedDateTime.now();
    Wallet wallet = isValid(tokenService.getWalletFrom(token));
    walletValidationUtil.validateReferenceIdAndType(referenceId, DEPOSIT);
    walletRepository.deposit(amount, now, wallet.getOwnedBy());
    activityService.storeActivity(wallet, amount, referenceId, now, DEPOSIT);
    return depositWalletResponseConverter.toResponse(wallet, amount, referenceId, now);
  }
}
