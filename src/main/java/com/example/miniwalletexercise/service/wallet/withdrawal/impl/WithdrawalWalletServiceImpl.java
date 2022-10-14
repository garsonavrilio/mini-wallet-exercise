package com.example.miniwalletexercise.service.wallet.withdrawal.impl;

import static com.example.miniwalletexercise.constant.ActivityConstant.WITHDRAW;
import static com.example.miniwalletexercise.util.WalletValidationUtil.isEnableWithdraw;
import static com.example.miniwalletexercise.util.WalletValidationUtil.isValid;

import com.example.miniwalletexercise.converter.wallet.withdrawal.WithdrawalWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.withdrawal.WithdrawalWalletService;
import com.example.miniwalletexercise.util.WalletValidationUtil;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalWalletServiceImpl implements WithdrawalWalletService {

  @Autowired
  private TokenService tokenService;
  @Autowired
  private WalletRepository walletRepository;
  @Autowired
  private ActivityService activityService;
  @Autowired
  private WalletValidationUtil walletValidationUtil;
  @Autowired
  private WithdrawalWalletResponseConverter withdrawalWalletResponseConverter;

  @Override
  public ResponseDTO<WithdrawalResponseDTO> withdraw(String token, Long amount, UUID referenceId) {
    ZonedDateTime now = ZonedDateTime.now();
    Wallet wallet = isValid(tokenService.getWalletFrom(token));
    walletValidationUtil.validateReferenceIdAndType(referenceId, WITHDRAW);
    isEnableWithdraw(wallet, amount);
    walletRepository.withdraw(amount, now, wallet.getOwnedBy());
    activityService.storeActivity(wallet, amount, referenceId, now, WITHDRAW);
    return withdrawalWalletResponseConverter.toResponse(wallet, amount, referenceId, now);
  }
}
