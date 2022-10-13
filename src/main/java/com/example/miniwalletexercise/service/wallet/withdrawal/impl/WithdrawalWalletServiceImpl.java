package com.example.miniwalletexercise.service.wallet.withdrawal.impl;

import static com.example.miniwalletexercise.constant.ActivityConstant.DEPOSIT;
import static com.example.miniwalletexercise.constant.ActivityConstant.WITHDRAW;
import static com.example.miniwalletexercise.util.WalletValidationUtil.isEnableWithdraw;
import static com.example.miniwalletexercise.util.WalletValidationUtil.isValid;

import com.example.miniwalletexercise.converter.wallet.withdrawal.WithdrawalWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletRequestDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.withdrawal.WithdrawalWalletService;
import com.example.miniwalletexercise.util.WalletValidationUtil;
import java.time.ZonedDateTime;
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
  public ResponseDTO<WithdrawalResponseDTO> withdraw(String token,
      WithdrawalWalletRequestDTO withdrawalWalletRequestDTO) {
    ZonedDateTime now = ZonedDateTime.now();
    Wallet wallet = isValid(tokenService.getWalletFrom(token));
    walletValidationUtil.validateReferenceIdAndType(withdrawalWalletRequestDTO.getReferenceId(),
        WITHDRAW);
    isEnableWithdraw(wallet, withdrawalWalletRequestDTO);
    walletRepository.withdraw(withdrawalWalletRequestDTO.getAmount(), now, wallet.getOwnedBy());
    activityService.storeActivity(wallet, withdrawalWalletRequestDTO, now);
    return withdrawalWalletResponseConverter.toResponse(wallet, withdrawalWalletRequestDTO, now);
  }
}
