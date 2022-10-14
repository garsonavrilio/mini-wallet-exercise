package com.example.miniwalletexercise.service.activity;

import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import java.util.UUID;

public interface ActivityService {

  void storeActivity(Wallet wallet, String type);

  void storeActivity(Wallet wallet, Long amount, UUID referenceId, ZonedDateTime now, String type);

}
