package com.example.miniwalletexercise.service.token;

import com.example.miniwalletexercise.model.Wallet;

public interface TokenService {

  Wallet getWalletFrom(String token);

  String sanitizeToken(String token);

}
