package com.example.miniwalletexercise.service.init.impl;

import com.example.miniwalletexercise.converter.init.InitRequestConverter;
import com.example.miniwalletexercise.converter.init.InitResponseConverter;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitRequestDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;
import com.example.miniwalletexercise.repository.wallet.WalletRepository;
import com.example.miniwalletexercise.service.init.InitService;
import com.example.miniwalletexercise.service.init.InitServiceErrors;
import java.util.Objects;
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
  public ResponseDTO<InitResponseDTO> init(InitRequestDTO initRequestDTO) {
    if (isNotExist(initRequestDTO)) {
      return initResponseConverter.toResponse(
          walletRepository.save(initRequestConverter.toEntity(initRequestDTO)));
    }
    throw InitServiceErrors.alreadyExist();
  }

  private boolean isNotExist(InitRequestDTO initRequestDTO) {
    return Objects.isNull(walletRepository.findWalletByOwnedBy(initRequestDTO.getCustomerXid()));
  }

}
