package com.example.miniwalletexercise.service.token.impl;

import static com.example.miniwalletexercise.constant.ServiceConstant.PREFIX_TOKEN;
import static com.example.miniwalletexercise.util.Base64Util.decode;

import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  @Autowired
  private WalletRepository walletRepository;

  @Override
  public Wallet getWalletFrom(String token) {
    return walletRepository.findWalletByOwnedBy(decode(sanitizeToken(token)));
  }

  @Override
  public String sanitizeToken(String token) {
    String[] tokenSplit = token.split(PREFIX_TOKEN);
    return tokenSplit[1];
  }
}
