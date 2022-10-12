package com.example.miniwalletexercise.service.auth.impl;

import static com.example.miniwalletexercise.constant.ServiceConstant.PREFIX_TOKEN;
import static com.example.miniwalletexercise.util.Base64Util.decode;

import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.auth.AuthService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private WalletRepository walletRepository;

  @Override
  public boolean hasAccess(String token) {
    if (isInvalid(token)) {
      return false;
    }
    return Objects.nonNull(walletRepository.findWalletByOwnedBy(decode(sanitizeToken(token))));
  }

  private boolean isInvalid(String token) {
    return Objects.isNull(token) || !token.startsWith(PREFIX_TOKEN);
  }

  private String sanitizeToken(String token) {
    String[] tokenSplit = token.split(PREFIX_TOKEN);
    return tokenSplit[1];
  }
}
