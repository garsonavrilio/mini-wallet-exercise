package com.example.miniwalletexercise.service.init.impl;

import com.example.miniwalletexercise.converter.init.InitRequestConverter;
import com.example.miniwalletexercise.converter.init.InitResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;
import com.example.miniwalletexercise.model.Wallet;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.init.InitService;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitServiceImpl implements InitService {

  @Autowired
  private WalletRepository walletRepository;
  @Autowired
  private InitRequestConverter initRequestConverter;
  @Autowired
  private InitResponseConverter initResponseConverter;

  @Override
  public ResponseDTO<InitResponseDTO> init(UUID customerXid) {
    Wallet wallet = walletRepository.findWalletByOwnedBy(customerXid);
    if (isNotExist(wallet)) {
      return initResponseConverter.toResponse(
          walletRepository.save(initRequestConverter.toEntity(customerXid)));
    }
    return initResponseConverter.toResponse(wallet);
  }

  private boolean isNotExist(Wallet wallet) {
    return Objects.isNull(wallet);
  }

}
