package com.example.miniwalletexercise.service.auth.impl;

import static com.example.miniwalletexercise.constant.ServiceConstant.PREFIX_TOKEN;

import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.auth.AuthService;
import com.example.miniwalletexercise.service.token.TokenService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private WalletRepository walletRepository;
  @Autowired
  private TokenService tokenService;

  @Override
  public boolean hasAccess(String token) {
    if (isInvalid(token)) {
      return false;
    }
    return Objects.nonNull(walletRepository.findWalletByToken(tokenService.sanitizeToken(token)));
  }

  private boolean isInvalid(String token) {
    return Objects.isNull(token) || !token.startsWith(PREFIX_TOKEN);
  }
}
