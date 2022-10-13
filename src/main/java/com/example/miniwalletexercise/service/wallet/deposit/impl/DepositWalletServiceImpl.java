package com.example.miniwalletexercise.service.wallet.deposit.impl;

import static com.example.miniwalletexercise.constant.ActivityConstant.DEPOSIT;
import static com.example.miniwalletexercise.util.WalletValidationUtil.isValid;

import com.example.miniwalletexercise.converter.wallet.deposit.DepositWalletResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletRequestDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.activity.ActivityService;
import com.example.miniwalletexercise.service.token.TokenService;
import com.example.miniwalletexercise.service.wallet.deposit.DepositWalletService;
import com.example.miniwalletexercise.util.WalletValidationUtil;
import java.time.ZonedDateTime;
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
  public ResponseDTO<DepositResponseDTO> deposit(String token,
      DepositWalletRequestDTO depositWalletRequestDTO) {
    ZonedDateTime now = ZonedDateTime.now();
    Wallet wallet = isValid(tokenService.getWalletFrom(token));
    walletValidationUtil.validateReferenceIdAndType(depositWalletRequestDTO.getReferenceId(), DEPOSIT);
    walletRepository.deposit(depositWalletRequestDTO.getAmount(), now, wallet.getOwnedBy());
    activityService.storeActivity(wallet, depositWalletRequestDTO, now);
    return depositWalletResponseConverter.toResponse(wallet, depositWalletRequestDTO, now);
  }
}
