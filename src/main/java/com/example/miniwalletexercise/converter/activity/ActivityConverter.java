package com.example.miniwalletexercise.converter.activity;

import static com.example.miniwalletexercise.constant.ActivityConstant.DEPOSIT;
import static com.example.miniwalletexercise.constant.ActivityConstant.DISABLED;
import static com.example.miniwalletexercise.constant.ActivityConstant.ENABLED;
import static com.example.miniwalletexercise.constant.ActivityConstant.WITHDRAW;

import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletRequestDTO;
import com.example.miniwalletexercise.model.Activity;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.service.activity.ActivityServiceErrors;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter {

  public Activity toEntity(Wallet wallet, String type) {
    switch (type) {
      case ENABLED:
        return enableWalletActivity(wallet);
      case DISABLED:
        return disableWalletActivity(wallet);
      default:
        throw ActivityServiceErrors.invalidActivityType();
    }
  }

  public Activity toEntity(Wallet wallet, DepositWalletRequestDTO depositWalletRequestDTO, ZonedDateTime now) {
    return Activity.builder()
        .time(now)
        .amount(depositWalletRequestDTO.getAmount())
        .walletUuid(wallet.getUuid())
        .type(DEPOSIT)
        .referenceId(depositWalletRequestDTO.getReferenceId())
        .build();
  }

  public Activity toEntity(Wallet wallet, WithdrawalWalletRequestDTO withdrawalWalletRequestDTO, ZonedDateTime now) {
    return Activity.builder()
        .time(now)
        .amount(withdrawalWalletRequestDTO.getAmount())
        .walletUuid(wallet.getUuid())
        .type(WITHDRAW)
        .referenceId(withdrawalWalletRequestDTO.getReferenceId())
        .build();
  }

  private Activity enableWalletActivity(Wallet wallet) {
    return Activity.builder().time(wallet.getUpdatedAt()).type(ENABLED).walletUuid(wallet.getOwnedBy()).build();
  }

  private Activity disableWalletActivity(Wallet wallet) {
    return Activity.builder().time(wallet.getUpdatedAt()).type(DISABLED).walletUuid(wallet.getOwnedBy()).build();
  }

}
