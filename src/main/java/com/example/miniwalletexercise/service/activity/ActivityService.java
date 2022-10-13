package com.example.miniwalletexercise.service.activity;

import com.example.miniwalletexercise.model.Wallet;

public interface ActivityService {

  void storeActivity(Wallet wallet, String type);
}
