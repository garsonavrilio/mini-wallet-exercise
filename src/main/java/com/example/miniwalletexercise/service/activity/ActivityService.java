package com.example.miniwalletexercise.service.activity;

import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletRequestDTO;
import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;

public interface ActivityService {

  void storeActivity(Wallet wallet, String type);

  void storeActivity(Wallet wallet, DepositWalletRequestDTO depositWalletRequestDTO, ZonedDateTime now);
}
